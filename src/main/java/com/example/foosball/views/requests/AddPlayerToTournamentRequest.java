package com.example.foosball.views.requests;

import com.example.foosball.models.TournamentPlayers;

import java.util.ArrayList;

public class AddPlayerToTournamentRequest {
    private ArrayList<TournamentPlayers> tournamentPlayers;

    public ArrayList<TournamentPlayers> getTournamentPlayers() {
        return tournamentPlayers;
    }

    public void setTournamentPlayers(ArrayList<TournamentPlayers> tournamentPlayers) {
        this.tournamentPlayers = tournamentPlayers;
    }

    @Override
    public String toString() {
        String results = "+";
        for(var p : tournamentPlayers) {
            results += p.toString();
        }
        return results;
    }
}
