package com.naukma.soccer.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final String URL_WITH_PARAM = "https://apiv2.apifootball.com/?action=%s&%s" +
            "&APIkey=4e13de1b619129d2c759b355af66eb73810a4bc26fc6286bd3ba5420788858b0";
    private static final String URL_ACTION = "https://apiv2.apifootball.com/?action=%s" +
            "&APIkey=4e13de1b619129d2c759b355af66eb73810a4bc26fc6286bd3ba5420788858b0";
    private static final String URL_TWO_PARAM = "https://apiv2.apifootball.com/?action=%s&%s&%s" +
            "&APIkey=4e13de1b619129d2c759b355af66eb73810a4bc26fc6286bd3ba5420788858b0";
    private static final String URL_THREE_PARAM = "https://apiv2.apifootball.com/?action=%s&%s&%s&%s" +
            "&APIkey=4e13de1b619129d2c759b355af66eb73810a4bc26fc6286bd3ba5420788858b0";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/countries")
    public JsonNode getCountries() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format(URL_ACTION, "get_countries"), String.class);

        return getJsonNode(response);
    }

    @GetMapping("/players/{name}")
    public JsonNode getPlayerByName(@NotNull @PathVariable final String name) {
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format(URL_WITH_PARAM, "get_players", "player_name=" + name), String.class);

        return getJsonNode(response);
    }

    @GetMapping("/players/id/{id}")
    public JsonNode getPlayerById(@NotNull @PathVariable final String id) {
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format(URL_WITH_PARAM, "get_players", "player_id=" + id), String.class);

        return getJsonNode(response);
    }

    @GetMapping("/teams/{league}")
    public JsonNode getTeamsByLeague(@NotNull @PathVariable final int league) {
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format(URL_WITH_PARAM, "get_teams", "league_id=" + league), String.class);

        return getJsonNode(response);
    }

    @GetMapping("/battle")
    public JsonNode getBattleBetweenCommands() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format(URL_TWO_PARAM, "get_H2H", "firstTeam=Chelsea", "secondTeam=Arsenal"), String.class);

        return getJsonNode(response);
    }

    @GetMapping("/live")
    public JsonNode getLiveMatches() {
        //TODO
        LocalDate today = LocalDate.now();
        String query = String.format(URL_TWO_PARAM, "get_events","from=" + today, "to=" + today);
        ResponseEntity<String> response = restTemplate.getForEntity(
                query, String.class);
        return getJsonNode(response);
    }

    @GetMapping("/today")
    public JsonNode getTodayMatches() {
        LocalDate today = LocalDate.now();
        String query = String.format(URL_TWO_PARAM, "get_events", "from=" + today, "to=" + today);
        ResponseEntity<String> response = restTemplate.getForEntity(
                query, String.class);
        return getJsonNode(response);
    }

    private JsonNode getJsonNode(ResponseEntity<String> response) {
        JsonNode root = null;
        try {
            root = objectMapper.readTree(response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

}
