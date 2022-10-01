package com.personal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.model.Game;
import com.personal.repository.GameRepository;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    public Number addGame(Game game) {
        return gameRepository.addGame(game);
    }
}
