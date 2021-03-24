package com.example.foosball.request;


import com.example.foosball.Match;
import com.example.foosball.Player;

import java.util.ArrayList;

public class TournamentRequest {
    private String name;
    private int id;
    private ArrayList<Player> players;
    private ArrayList<Match> schedule;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TournamentRequest{" +
                "name='" + name + '\'' +
                "id=" + id + '\'' +
                '}';
    }

    public void getPlayers() {
        for(Player p: players)
            System.out.println(p.getName());
    }
}