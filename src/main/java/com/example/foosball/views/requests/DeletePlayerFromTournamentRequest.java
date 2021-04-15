package com.example.foosball.views.requests;

public class DeletePlayerFromTournamentRequest {
    private int id;
    private String player_name, tournament_name;

    public DeletePlayerFromTournamentRequest(int id, String player_name, String tournament_name) {
        this.id = id;
        this.player_name = player_name;
        this.tournament_name = tournament_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }
}
