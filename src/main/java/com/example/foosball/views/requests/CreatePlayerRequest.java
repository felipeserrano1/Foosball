package com.example.foosball.views.requests;

import com.example.foosball.models.Player;

import java.util.ArrayList;

public class CreatePlayerRequest {
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
