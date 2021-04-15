package com.example.foosball.services;

import com.example.foosball.models.TournamentPlayers;
import com.example.foosball.repository.PlayerRepository;
import com.example.foosball.models.Player;
import com.example.foosball.models.Tournament;
import com.example.foosball.repository.TournamentPlayerRepository;
import com.example.foosball.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class FoosballService {
    private final PlayerRepository playerRepository;
    private final TournamentRepository tournamentRepository;
    private final TournamentPlayerRepository tournamentPlayerRepository;

    @Autowired
    public FoosballService(PlayerRepository playerRepository, TournamentRepository tournamentRepository, TournamentPlayerRepository tournamentPlayerRepository) {
        this.playerRepository = playerRepository;
        this.tournamentRepository = tournamentRepository;
        this.tournamentPlayerRepository = tournamentPlayerRepository;
    }

    public ArrayList<Player> getAllPlayers() throws Exception {
        try {
            ArrayList<Player> list = new ArrayList<>();
            playerRepository.findAll().forEach(list::add);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public Player getPlayerByName(String name) throws Exception{
        Player player;
        try {
            player = playerRepository.getByName(name);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return player;
    }

    public Player getPlayerByID(int id) throws Exception {
        try {
            var player = new Player(playerRepository.findById(id).get().getPlayerId(), playerRepository.findById(id).get().getName(), playerRepository.findById(id).get().getAge());
            return player;
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }

    public String createPlayers(ArrayList<Player> listPlayers) throws Exception {
        ArrayList<Player> list = listPlayers;
        try {
            playerRepository.saveAll(listPlayers).forEach(list::add);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return "Players created!";
    }

    public ArrayList<Tournament> getAllTournaments() throws Exception {
        try {
            ArrayList<Tournament> list = new ArrayList<>();
            tournamentRepository.findAll().forEach(list::add);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public String createTournament(ArrayList<Tournament> listTournaments) throws Exception {
        ArrayList<Tournament> list = listTournaments;
        try {
            tournamentRepository.saveAll(listTournaments).forEach(list::add);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return "Tournaments created!";
    }

    public String addPlayerTournament(ArrayList<TournamentPlayers> listTournamentPlayer) throws Exception {
        ArrayList<TournamentPlayers> list = listTournamentPlayer;
        try {
            tournamentPlayerRepository.saveAll(listTournamentPlayer).forEach(list::add);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return "Player was added to tournament";
    }

    public ArrayList<TournamentPlayers> getAllPlayersFromTournament(int tournament_id) throws Exception{
        try {
            ArrayList<TournamentPlayers> list;
            list = tournamentPlayerRepository.findAllByTournamentId(tournament_id);
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Tournament getTournamentByName(String name) throws Exception {
        Tournament tournament;
        try {
            tournament = tournamentRepository.getByName(name);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return tournament;
    }

    public Tournament getTournamentByID(int id) throws Exception {
        try {
            var tournament = new Tournament(tournamentRepository.findById(id).get().getTournamentId(), tournamentRepository.findById(id).get().getName());
            return tournament;
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }

    // preguntar en caso de que una funcion a largo plazo si hacerla ahora (un jugador en dos torneos distintos)
    public String removePlayer(Player player) throws Exception{
        try {
            playerRepository.delete(player);
            var playerTournament = tournamentPlayerRepository.getByPlayerId(player.getPlayerId());
            tournamentPlayerRepository.delete(playerTournament.get(0));
        } catch (Exception e) {
            throw new Exception(e);
        }
        return "Player was removed!";
    }

    public String removeTournament(Tournament tournament) throws Exception{
        try {
            tournamentRepository.delete(tournament);
            var playerTournament = tournamentPlayerRepository.findAllByTournamentId(tournament.getTournamentId());
            for(TournamentPlayers p: playerTournament)
                tournamentPlayerRepository.delete(p);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return "Tournament was removed!";
    }

    public String removePlayerFromTournament(int id) throws Exception{
        try {
            var tournamentPlayer = tournamentPlayerRepository.getByPlayerId(id);
            tournamentPlayerRepository.delete(tournamentPlayer.get(0));
        } catch (Exception e) {
            throw new Exception(e);
        }
        return "Player was removed from the tournament!";
    }

}
