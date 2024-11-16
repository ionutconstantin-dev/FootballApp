package com.football.FootballApp.api.controller;

import com.football.FootballApp.api.model.Player;
import com.football.FootballApp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player")
    public Player getPlayer(@RequestParam String name) {
        return playerService.getPlayer(name);
    }
}
