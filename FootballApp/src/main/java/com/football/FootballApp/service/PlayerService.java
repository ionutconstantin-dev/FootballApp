package com.football.FootballApp.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.football.FootballApp.Constants;
import com.football.FootballApp.model.Player;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class PlayerService {

    private final Gson gson;

    public PlayerService(Gson gson) {
        this.gson = gson;
    }

    public Player getPlayer(String name) {
        try {
            // Encode the player name
            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);

            // Build the API URL
            String url = "https://v3.football.api-sports.io/players/profiles?search=" + encodedName;

            // Create HTTP request
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("x-rapidapi-key", Constants.API_KEY)
                    .header("x-rapidapi-host", "v3.football.api-sports.io")
                    .GET()
                    .build();

            // Send the request and receive the response
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonArray playersArray = jsonResponse.getAsJsonArray("response");

            // Ensure there's at least one player in the response
            if (playersArray != null && playersArray.size() > 0) {
                JsonObject playerJson = playersArray.get(0).getAsJsonObject().getAsJsonObject("player");

                // Map the JSON object to the Player model
                return gson.fromJson(playerJson, Player.class);
            } else {
                throw new RuntimeException("No players found for the given name.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching player data", e);
        }
    }
}
