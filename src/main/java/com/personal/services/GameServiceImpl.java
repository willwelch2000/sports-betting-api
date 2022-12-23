package com.personal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.model.Game;
import com.personal.repository.GameRepository;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public List<Game> getGames() {
        return gameRepository.getGames();
    }

    @Override
    public Game getGame(Number gameId) {
        return gameRepository.getGame(gameId);
    }

    @Override
    public List<Game> getGamesWithResult() {
        return gameRepository.getGamesWithResult();
    }

    @Override
    public List<Game> getPastGamesWithNoResult() {
        return gameRepository.getPastGamesWithNoResult();
    }

    @Override
    public Number addGame(Game game) {
        return gameRepository.addGame(game);
    }

    @Override
    public void updateGameResult(Game game) {
        gameRepository.updateGameResult(game);
    }
}
