package com.example.foosball.models;

import javax.persistence.*;

@Entity(name = "tournament_players")
public class TournamentPlayers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "tournament_id")
    private int tournamentId;
    @Column(name = "tournament_name")
    private String tournamentName;
    @Column(name = "player_id")
    private int playerId;
    @Column(name = "player_name")
    private String playerName;

    public TournamentPlayers() {}

    public TournamentPlayers(int id, int playerId, String playerName, int tournamentId, String tournamentName) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    @Override
    public String toString() {
        return "TournamentPlayers{" +
                "id=" + id +
                ", tournamentId=" + tournamentId +
                ", tournamentName='" + tournamentName + '\'' +
                ", playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
