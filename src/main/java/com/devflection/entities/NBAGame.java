package com.devflection.entities;

import java.time.ZonedDateTime;

public class NBAGame {

    private NBATeam homeTeam;
    private NBATeam awayTeam;
    private ZonedDateTime gameTime;

    public NBAGame() {
    }

    public NBAGame(NBATeam homeTeam, NBATeam awayTeam, ZonedDateTime gameTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameTime = gameTime;
    }

    public NBATeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(NBATeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public NBATeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(NBATeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public ZonedDateTime getGameTime() {
        return gameTime;
    }

    public void setGameTime(ZonedDateTime gameTime) {
        this.gameTime = gameTime;
    }
}
