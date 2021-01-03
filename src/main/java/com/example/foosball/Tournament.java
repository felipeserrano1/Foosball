package com.example.foosball;

import java.util.ArrayList;
import java.util.Random;

public class Tournament {
    private String name;
    private ArrayList<Player> players;
    private ArrayList<Match> schedule;
    //private HashMap<Player, Integer> standings;

    public Tournament(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.schedule = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getPlayers() {
        for(Player p: players)
            System.out.println(p.getName());
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void deletePlayer(Player player) {
        players.remove(player);
    }

//    public void getSchedule() {
//
//    }

    public ArrayList<Match> generateSchedule() {
        ArrayList<Match> aux = new ArrayList<>();
        for(Player p1: players) {
            for(Player p2: players) {
                var match = new Match(p1, p2);
                boolean matchAlready = false;
                for(Match m: aux) {
                    if (m.sameMatch(match))
                        matchAlready = true;
                }
                if((p1 != p2) && (matchAlready == false)) {
                    aux.add(match);
                }
            }
        }
        var random = new Random();
        while(aux.size() != 0) {
            int randomNum = random.nextInt(players.size());
            schedule.add(aux.get(randomNum));
            aux.remove(randomNum);
        }
        return schedule;
    }
}
