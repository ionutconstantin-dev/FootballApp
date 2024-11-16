package com.football.FootballApp.service;

import com.football.FootballApp.api.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    Player player;

    public PlayerService() {
        player = new Player(1, "Cristiano", "Ronaldo", 39, "Al-Nassr");
    }

    public Player getPlayer(String name) {
        if (name.equalsIgnoreCase(player.getFirstName()) || name.equalsIgnoreCase(player.getLastName())) {
            return player;
        }
        return null;
    }


}
