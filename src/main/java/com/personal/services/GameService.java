package com.personal.services;

import java.util.List;

import com.personal.model.Game;

public interface GameService {
    public List<Game> getGames();
    public Game getGame(Number gameId);
    public List<Game> getGamesWithResult();
    public List<Game> getPastGamesWithNoResult();
    public Number addGame(Game game);
    public void updateGameResult(Game game);
}
