package com.example.foosball.request;

public class AddPlayerToTournamentRequest {
    private int idTournament, player_id;
    private String player_name;

    public AddPlayerToTournamentRequest(int idTournament, int player_id, String player_name) {
        this.idTournament = idTournament;
        this.player_id = player_id;
        this.player_name = player_name;
    }

    public int getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }
}
