package com.example.foosball.services;

import com.example.foosball.Player;
import com.example.foosball.Tournament;
import com.example.foosball.response.BaseResponse;
import com.example.foosball.response.ErrorResponse;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FoosballService {
    private ArrayList<Player> players;
    private ArrayList<Tournament> tournaments;
    private DatabaseService databaseService;


    public FoosballService() {
        this.players = new ArrayList<>();
        this.tournaments = new ArrayList<>();
        this.databaseService = new DatabaseService();
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public ArrayList<Player> getPlayers() {
        ArrayList listPlayers = new ArrayList();
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = "SELECT * FROM players";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                var player = new Player(rs.getInt("player_id"), rs.getString("name"), rs.getInt("age"));
                listPlayers.add(player);
            }
            st.close();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return listPlayers;
    }

    public Player getPlayerByName(String name) throws Exception{
        //esta bien esto?
        Player player = new Player();
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = String.format("SELECT * FROM players WHERE name = '%s'", name);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                //var player = new Player(rs.getInt("player_id") + " " + rs.getString("name") + " " + rs.getInt("age"));
                player.setId(rs.getInt("player_id"));
                player.setName(rs.getString("name"));
                player.setAge(rs.getInt("age"));
                st.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return player;
    }

    public Player getPlayerByID(int id) throws Exception{
        var player = new Player();
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = String.format("SELECT * FROM players WHERE player_id = %d",id);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                //var player = new Player(rs.getInt("player_id") + " " + rs.getString("name") + " " + rs.getInt("age"));
                player.setId(rs.getInt("player_id"));
                player.setName(rs.getString("name"));
                player.setAge(rs.getInt("age"));
                st.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return player;
    }

    public String createPlayers(ArrayList<Player> listPlayers) {
        ArrayList<Player> lista = listPlayers;
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            Statement st = conn.createStatement();
            for(int i = 0; i < lista.size(); i++) {
                String name = lista.get(i).getName();
                int age = lista.get(i).getAge();
                String query = String.format("INSERT INTO players(name, age) VALUES('%s', %d)", name, age );
                int rowsAffected = st.executeUpdate(query);
            }
            st.close();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return "Players created!";
    }

    public ArrayList<Tournament> getAllTournaments() {
        ArrayList<Tournament> lista = new ArrayList();
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = "SELECT * FROM tournaments";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                var tournament = new Tournament(rs.getInt("tournament_id"), rs.getString("name"));
                lista.add(tournament);
            }
            st.close();
            return lista;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    public String createTournament(String name) throws Exception {
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = String.format("INSERT INTO tournaments(name) VALUES('%s')", name);
            System.out.println(query);
            Statement st = conn.createStatement();
            int rowsAffected = st.executeUpdate(query);
            System.out.println("rowsAffected" + rowsAffected);
            st.close();
        }
        catch (Exception e) {
            throw new Exception(e);
        }

        return "Tournament was created!";
    }

    public String addPlayerTournament(int idTournament, String player_name, int player_id) throws Exception {
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            Statement st = conn.createStatement();
            String query = String.format("INSERT INTO tournament_players VALUES(%d,'%s',%d)", idTournament, player_name, player_id);
            int rowsAffected = st.executeUpdate(query);
            st.close();
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return player_name + " added to tournament!";
    }

    //in this case there is no exception because the method called in this method has already an exception

    public ArrayList<Player> getAllPlayersFromTournament(int tournament_id) throws Exception{
        ArrayList<Player> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            Statement st = conn.createStatement();
            String query = String.format("SELECT * FROM tournament_players WHERE id = %d", tournament_id);
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                var player = new Player(rs.getInt("id"), rs.getString("player_name"), rs.getInt("player_id"));
                lista.add(player);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return lista;
    }

    public Tournament getTournamentByName(String name) throws Exception {
        var tournament = new Tournament();
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = String.format("SELECT * FROM tournaments WHERE name = '%s'", name);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                tournament.setId(rs.getInt("tournament_id"));
                tournament.setName(rs.getString("name"));
            }            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return tournament;
    }

    public Tournament getTournamentByID(int id) throws Exception {
        var tournament = new Tournament();
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = String.format("SELECT * FROM tournaments WHERE tournament_id = %d ", id);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                tournament.setId(rs.getInt("tournament_id"));
                tournament.setName(rs.getString("name"));
            }
            st.close();
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return tournament;
    }

    public String removePlayerFromTournament(int tournament_id, int player_id) throws Exception{
        try {
            Connection conn = DriverManager.getConnection(databaseService.getUrl(), "root", "root");
            String query = String.format("DELETE FROM tournament_players WHERE id = %d AND player_id = %d", tournament_id, player_id);
            Statement st = conn.createStatement();
            int affectedRow = st.executeUpdate(query);
            st.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return "Player was removed from the tournament!";
    }

}
