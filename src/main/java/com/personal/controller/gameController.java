package com.personal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.model.Game;
import com.personal.services.GameService;

@Controller
@RequestMapping("games")
public class gameController {

    @Autowired
    GameService gameService;

    @GetMapping()
    public @ResponseBody List<Game> getGames() {
        return gameService.getGames();
    }

    @GetMapping("{gameId}")
    public @ResponseBody Game getGame(@PathVariable("gameId") Number gameId) {
        return gameService.getGame(gameId);
    }

    @GetMapping("result")
    public @ResponseBody List<Game> getGamesWithResult() {
        return gameService.getGamesWithResult();
    }
    
    @GetMapping("pastNoResult")
    public @ResponseBody List<Game> getPastGamesWithNoResult() {
        return gameService.getPastGamesWithNoResult();
    }
    
    @GetMapping("byLeague/{league}")
    public @ResponseBody List<Game> getGamesByLeague(@PathVariable("league") String league) {
        return gameService.getGamesByLeague(league);
    }

    @PostMapping
    public @ResponseBody Number addGame(@RequestBody Game game) {
        return gameService.addGame(game);
    }

    @PutMapping
    public @ResponseBody Object updateGameResult(@RequestBody Game game) {
        gameService.updateGameResult(game);
        return null;
    }
}
