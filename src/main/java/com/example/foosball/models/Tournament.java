package com.example.foosball.models;

import javax.persistence.*;

@Entity(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private int tournamentId;
    @Column(nullable = false)
    private String name;

    public Tournament() {}

    public Tournament(int id, String name) {
        this.tournamentId = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public String toString() {
        return "CreateTournamentRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
