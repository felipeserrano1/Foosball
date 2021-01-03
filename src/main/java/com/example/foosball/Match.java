package com.example.foosball;

import javafx.util.Pair;

public class Match {
    private Pair<Player, Player> players;
    private Integer rp1, rp2;

    public Match(Player p1, Player p2) {
        this.players = new Pair<>(p1, p2);
    }

    public void getMatch() {
        this.getPlayers();
        this.getScore();
    }

    public Player getP1() {
        return players.getKey();
    }

    public Player getP2() {
        return players.getValue();
    }

    public void getPlayers() {
        System.out.println("Match: " + players.getKey() + " vs " + players.getValue());
    }

    public void getScore() {
        if(rp1 == null && rp2 == null) {
            System.out.println("Score:  - ");
        }
        else {
            System.out.println("Score: " + this.getRp1() + " - " + this.getRp2());
        }
    }

    public boolean sameMatch(Match match) {
        if ((this.getP1() == match.getP2()) && (this.getP2() == match.getP1())) {
            return true;
        }
        return false;
    }

    public Integer getRp1() {
        return rp1;
    }

    public void setRp1(Integer rp1) {
        this.rp1 = rp1;
    }

    public Integer getRp2() {
        return rp2;
    }

    public void setRp2(Integer rp2) {
        this.rp2 = rp2;
    }
}
