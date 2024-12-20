package com.football.FootballApp.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.football.FootballApp.Constants;
import com.football.FootballApp.model.Player;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class PlayerService {

    private final Gson gson;

    public PlayerService(Gson gson) {
        this.gson = gson;
    }

    public Player getPlayer(String name) throws Exception {

        String endpoint = "https://v3.football.api-sports.io/players/profiles?search=" + name;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("x-rapidapi-key", Constants.API_KEY)
                .header("x-rapidapi-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = gson.fromJson(httpResponse.body(), JsonObject.class);

        JsonArray jsonArrayResponse = jsonObject.getAsJsonArray("response");

        JsonObject playerObject = jsonArrayResponse.get(0).getAsJsonObject().getAsJsonObject("player");
        Player player = gson.fromJson(playerObject, Player.class);

        return player;
    }
}
