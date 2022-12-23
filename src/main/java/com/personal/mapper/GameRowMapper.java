package com.personal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.personal.model.Game;

@Component("gameRowMapper")
public class GameRowMapper implements RowMapper<Game>{
    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {

        Game gameToReturn = new Game(rs.getInt("id"), rs.getString("winner"), rs.getString("loser"), rs.getString("league"), 
                rs.getInt("odds"), rs.getDouble("percentage"), rs.getTimestamp("date"), rs.getString("result"));

        return gameToReturn;
    }
}
