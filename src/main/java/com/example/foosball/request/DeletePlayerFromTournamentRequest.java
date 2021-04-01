package com.example.foosball.request;

public class DeletePlayerFromTournamentRequest {
    private int player_id, tournament_id;

    public DeletePlayerFromTournamentRequest(int player_id, int tournament_id) {
        this.player_id = player_id;
        this.tournament_id = tournament_id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int idPlayer) {
        this.player_id = player_id;
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int idTournament) {
        this.tournament_id = tournament_id;
    }
}
