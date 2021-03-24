package com.example.foosball.request;

import java.util.UUID;

public class AddPlayerToTournamentRequest {
    private int idTournament, idPlayer;
    private String nameTournament, namePlayer;

    public AddPlayerToTournamentRequest(int idTournament, int idPlayer, String nameTournament, String namePlayer) {
        this.idTournament = idTournament;
        this.idPlayer = idPlayer;
        this.nameTournament = nameTournament;
        this.namePlayer = namePlayer;
    }

    public int getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNameTournament() {
        return nameTournament;
    }

    public void setNameTournament(String nameTournament) {
        this.nameTournament = nameTournament;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }
}
