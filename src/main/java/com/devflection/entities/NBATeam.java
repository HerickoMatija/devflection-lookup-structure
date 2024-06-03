package com.devflection.entities;

public enum NBATeam {
    CELTICS,
    NETS,
    KNICKS,
    SIXERS,
    RAPTORS,
    BULLS,
    CAVALIERS,
    PISTONS,
    PACERS,
    BUCKS,
    HAWKS,
    HORNETS,
    HEAT,
    MAGIC,
    WIZARDS,
    NUGGETS,
    TIMBERWOLVES,
    THUNDER,
    TRAILBLAZERS,
    JAZZ,
    WARRIORS,
    CLIPPERS,
    LAKERS,
    SUNS,
    KINGS,
    MAVERICKS,
    ROCKETS,
    GRIZZLIES,
    PELICANS,
    SPURS;

    public static NBATeam fromString(String name) {
        for (NBATeam team : NBATeam.values()) {
            if (team.name().equalsIgnoreCase(name)) {
                return team;
            }
        }
        throw new IllegalArgumentException("No team found with name: " + name);
    }
}
