package com.devflection.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.devflection.entities.NBAGame;
import com.devflection.entities.NBATeam;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class GameScheduleService {

    private Map<NBATeam, List<NBAGame>> gameLookupStructure;

    public GameScheduleService() {
        initializeLookup();
    }

    private void initializeLookup() {
        List<NBAGame> games = parseGameScheduleFile();

        Map<NBATeam, List<NBAGame>> lookupStructure = new HashMap<>();

        for (NBAGame game : games) {
            // add game to home team
            lookupStructure.putIfAbsent(game.getHomeTeam(), new ArrayList<>());
            lookupStructure.get(game.getHomeTeam()).add(game);
            // add game to away team
            lookupStructure.putIfAbsent(game.getAwayTeam(), new ArrayList<>());
            lookupStructure.get(game.getAwayTeam()).add(game);
        }

        gameLookupStructure = lookupStructure;
    }

    public List<NBAGame> getRegularSeasonGamesForTeam(NBATeam team) {
        return gameLookupStructure.get(team);
    }

    // This is a mock method that in our case uses an example list of games in our resources folder,
    // but you can imagine this could be a long running network call or DB query
    private List<NBAGame> parseGameScheduleFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            InputStream is = getClass().getClassLoader().getResourceAsStream("lookupSource/lookupSource.json");
            JsonGameSchedule jsonGameSchedule = mapper.readValue(is, JsonGameSchedule.class);

            // Imagine this parsing takes a really long time
            Thread.sleep(60000L);

            return jsonGameSchedule.games;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    static class JsonGameSchedule {
        private List<NBAGame> games;

        public JsonGameSchedule() {
        }

        public void setGames(List<NBAGame> games) {
            this.games = games;
        }

        public List<NBAGame> getGames() {
            return games;
        }
    }
}
