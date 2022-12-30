package com.personal.repository;

import java.util.List;

import com.personal.model.Game;

public interface GameRepository {
    public List<Game> getGames();
    public Game getGame(Number gameId);
    public List<Game> getGamesWithResult();
    public List<Game> getPastGamesWithNoResult();
    public List<Game> getGamesByLeague(String league);
    public Number addGame(Game game);
    public void updateGameResult(Game game);
}
