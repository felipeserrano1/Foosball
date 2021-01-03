package com.example.foosball;

public class Player {
    private String name;
    //private LinkedHashMap<Player, Match> record;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void changePlayerName(String name) {
        this.name = name;
    }
}
