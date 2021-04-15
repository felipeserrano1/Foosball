package com.example.foosball.views.requests;

import com.example.foosball.models.Tournament;

import java.util.ArrayList;

public class CreateTournamentRequest {
    private ArrayList<Tournament> tournaments;

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    @Override
    public String toString() {
        String results = "+";
        for(var t : tournaments) {
            results += t.toString();
        }
        return results;
    }
}