package com.personal.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.personal.mapper.GameRowMapper;
import com.personal.model.Game;

@Repository("gameRepository")
public class GameRepositoryImpl implements GameRepository {

    private final String GET_GAMES_SQL = "SELECT * FROM Game";
    private final String GET_GAME_SQL = "SELECT * FROM Game "
        + "WHERE id = ?";
    private final String GET_GAMES_RESULT_SQL = "SELECT * FROM Game WHERE "
        + "result != 'U'";
    private final String GET_PAST_GAMES_NO_RESULT_SQL = "SELECT * FROM Game WHERE "
        + "result = 'U' and date < current_date()";
    private final String UPDATE_GAME_RESULT_SQL = "UPDATE Game "
        + "SET result = ? where id = ?";
    private final String GET_GAMES_BY_LEAGUE_SQL = "SELECT * FROM Game WHERE "
        + "league = ?";
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    GameRowMapper gameRowMapper;

    @Override
    public List<Game> getGames() {
        return jdbcTemplate.query(GET_GAMES_SQL, gameRowMapper);
    }

    @Override
    public Game getGame(Number gameId) {
        return jdbcTemplate.queryForObject(GET_GAME_SQL, gameRowMapper, gameId);
    }

    @Override
    public List<Game> getGamesWithResult() {
        return jdbcTemplate.query(GET_GAMES_RESULT_SQL, gameRowMapper);
    }

    @Override
    public List<Game> getPastGamesWithNoResult() {
        return jdbcTemplate.query(GET_PAST_GAMES_NO_RESULT_SQL, gameRowMapper);
    }

    @Override
    public List<Game> getGamesByLeague(String league) {
        return jdbcTemplate.query(GET_GAMES_BY_LEAGUE_SQL, gameRowMapper, league);
    }
    
    @Override
    public Number addGame(Game game) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.setGeneratedKeyName("id");

        Map<String, Object> data = new HashMap<>();
        data.put("winner", game.getWinner());
        data.put("loser", game.getLoser());
        data.put("odds", game.getOdds());
        data.put("percentage", game.getPercentage());
        data.put("league", game.getLeague());
        data.put("date", game.getDate());
        data.put("result", game.getResult());

        List<String> columns = new ArrayList<>();
        columns.add("winner");
        columns.add("loser");
        columns.add("odds");
        columns.add("percentage");
        columns.add("league");
        columns.add("date");
        columns.add("result");

        insert.setTableName("game");
        insert.setColumnNames(columns);
        return insert.executeAndReturnKey(data);
    }

    @Override
    public void updateGameResult(Game game) {
        jdbcTemplate.update(UPDATE_GAME_RESULT_SQL, game.getResult(), game.getId());
    }
}
