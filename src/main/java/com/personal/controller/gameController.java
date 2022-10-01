package com.personal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public @ResponseBody Number addGame(@RequestBody Game game) {
        return gameService.addGame(game);
    }
}
