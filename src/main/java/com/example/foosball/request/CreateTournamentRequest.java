package com.example.foosball.request;


import com.example.foosball.Match;
import com.example.foosball.Player;

import java.util.ArrayList;

public class CreateTournamentRequest {
    private String name;
    private ArrayList<Player> players;
    private ArrayList<Match> schedule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreateTournamentRequest{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", schedule=" + schedule +
                '}';
    }

    public void getPlayers() {
        for(Player p: players)
            System.out.println(p.getName());
    }
}