package com.personal.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.personal.model.Game;

@Repository("gameRepository")
public class GameRepositoryImpl implements GameRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
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

        List<String> columns = new ArrayList<>();
        columns.add("winner");
        columns.add("loser");
        columns.add("odds");
        columns.add("percentage");
        columns.add("league");
        columns.add("date");

        insert.setTableName("game");
        insert.setColumnNames(columns);
        return insert.executeAndReturnKey(data);
    }
}
