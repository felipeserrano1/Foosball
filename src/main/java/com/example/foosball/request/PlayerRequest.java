package com.example.foosball.request;

import com.example.foosball.Player;

import java.util.ArrayList;

public class PlayerRequest {
    private ArrayList<Player> players;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        String results = "+";
        for(var p : players) {
            results += p.toString();
        }
        return results;
    }
}
