package com.football.FootballApp.service;

import com.football.FootballApp.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private Player player;

    PlayerService() {
        player = new Player(1, "Cristiano", "Ronaldo", 39, "Al-Nassr");
    }

    public Player getPlayer(String name) {
        if (name.equalsIgnoreCase(player.getFirstName()) || name.equalsIgnoreCase(player.getLastName())) {
            return player;
        }
        return null;
    }
}
