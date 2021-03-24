package com.example.foosball;

import java.util.ArrayList;

public class FoosballManager {
    private ArrayList<Player> players;
    private ArrayList<Tournament> tournaments;

    public FoosballManager() {
        this.players = new ArrayList<>();
        this.tournaments = new ArrayList<>();
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayerByName(String name) throws IllegalArgumentException{
        for (var p: this.players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid name");
    }

    public Player getPlayerByID(int id) throws IllegalArgumentException{
        for (var p: this.players) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid ID");
    }

    public String createPlayers(ArrayList<Player> listPlayers) {
        players.addAll(listPlayers);
        return "Players created!";
    }

    public ArrayList<Tournament> getAllTournaments() {
        return this.tournaments;
    }

    public String createTournament(String name) {
        this.tournaments.add(new Tournament(name));

        return "Tournament was created!";
    }

    public String addPlayerTournament(int idPlayer, int idTournament) throws IllegalArgumentException {
        try {
            if(this.getPlayerByID(idPlayer) != null)
                this.getTournamentByID(idTournament).addPlayer(getPlayerByID(idPlayer));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return "Player added to tournament!";
    }

    //in this case there is no exception because the method called in this method has already an exception
    public ArrayList<Player> getAllPlayersFromTournament(String nameTournament) {
        return this.getTournamentByName(nameTournament).getPlayers();
    }

    public Tournament getTournamentByName(String name) throws IllegalArgumentException {
        for (var t: this.tournaments) {
            if(t.getName().equals(name)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Invalid name");
    }

    public Tournament getTournamentByID(int id) throws IllegalArgumentException {
        for (var t: this.tournaments) {
            if(t.getId() == id) {
                return t;
            }
        }
        throw new IllegalArgumentException("Invalid id");
    }

    public String removePlayer(int idTournament, int idPlayer) {
        try {
            if(this.getPlayerByID(idPlayer) != null) {
                this.getTournamentByID(idTournament).getPlayers().remove(getPlayerByID(idPlayer));
                return "Player removed from tournament!";
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return "Player doesn't belong to that tournament!";
    }

}
