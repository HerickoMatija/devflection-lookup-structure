package com.devflection.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devflection.entities.NBAGame;
import com.devflection.entities.NBATeam;
import com.devflection.services.GameScheduleService;

@RestController
public class GameScheduleController {

    private final GameScheduleService gameScheduleService;

    public GameScheduleController(GameScheduleService gameScheduleService) {
        this.gameScheduleService = gameScheduleService;
    }

    @GetMapping("/getGamesForTeam")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*")
    public List<NBAGame> getGamesForTeamVersion1(@RequestParam("team") String team) {
        long startTime = System.currentTimeMillis();

        NBATeam nbaTeam = NBATeam.fromString(team);
        List<NBAGame> games = gameScheduleService.getRegularSeasonGamesForTeam(nbaTeam);

        long endTime = System.currentTimeMillis();
        System.out.println(
            String.format("Request for team '%s' took '%s' milliseconds", team, endTime - startTime)
        );

        return games;
    }
}
