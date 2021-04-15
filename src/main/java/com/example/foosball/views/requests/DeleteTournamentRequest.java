package com.example.foosball.views.requests;

public class DeleteTournamentRequest {
    private int tournamentId;
    private String name;

    public DeleteTournamentRequest(int id, String name) {
        this.tournamentId = id;
        this.name = name;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
