package com.example.foosball.request;

public class DeletePlayerFromTournamentRequest {
    private int idPlayer, idTournament;

    public DeletePlayerFromTournamentRequest(int idPlayer, int idTournament) {
        this.idPlayer = idPlayer;
        this.idTournament = idTournament;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }
}
