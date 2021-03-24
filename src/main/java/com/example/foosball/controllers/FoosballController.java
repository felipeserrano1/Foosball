package com.example.foosball.controllers;

import com.example.foosball.FoosballManager;
import com.example.foosball.Player;
import com.example.foosball.Tournament;
import com.example.foosball.request.*;
import com.example.foosball.response.BaseResponse;
import com.example.foosball.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FoosballController {
    private FoosballManager foosballManager;

    @Autowired
    public FoosballController() {
        this.foosballManager = new FoosballManager();
    }

    @GetMapping("/players")
    public BaseResponse getAllPlayers() {
        return new BaseResponse(foosballManager.getPlayers(), null);
    }

    @GetMapping("/players/{name}")
    public BaseResponse getPlayerByName(@PathVariable(value="name") String name) {
        Player player;
        try {
            player = foosballManager.getPlayerByName(name);
        } catch (IllegalArgumentException e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(player, null);
    }

    @GetMapping("/players/{id}")
    public BaseResponse getPlayerByID(@PathVariable(value="id") int id) {
        Player player;
        try {
            player = foosballManager.getPlayerByID(id);
        } catch (IllegalArgumentException e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(player.getName() + player.getId(), null);
    }

    @PostMapping("/players")
    public BaseResponse createPlayers(@RequestBody PlayerRequest playerRequest) {
        return new BaseResponse(foosballManager.createPlayers(playerRequest.getPlayers()), null);
    }

    @GetMapping("/tournaments/id/{id}")
    public BaseResponse getTournamentByID(@PathVariable(value="id") int id) {
        Tournament tournament;

        try {
            tournament = foosballManager.getTournamentByID(id);
        } catch (IllegalArgumentException e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }

        return new BaseResponse(tournament, null);
    }

    @GetMapping("/tournaments/name/{name}")
    public BaseResponse getTournamentByName(@PathVariable(value="name") String name) {
        Tournament tournament;

        try {
            tournament = foosballManager.getTournamentByName(name);
        } catch (IllegalArgumentException e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }

        return new BaseResponse(tournament, null);
    }

    @GetMapping("/tournaments")
    public BaseResponse getAllTournaments() {
        return new BaseResponse(foosballManager.getAllTournaments(), null);
    }

    @PostMapping("/tournaments")
    public BaseResponse createTournament(@RequestBody TournamentRequest tournamentRequest) {
        return new BaseResponse(foosballManager.createTournament(tournamentRequest.getName()), null);
    }

    @PutMapping("/tournaments")
    public BaseResponse addPlayerTournament(@RequestBody AddPlayerToTournamentRequest addPlayerToTournamentRequest) {
        try {
            new BaseResponse(foosballManager.addPlayerTournament(addPlayerToTournamentRequest.getIdPlayer(), addPlayerToTournamentRequest.getIdTournament()),null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse("Player was added to tournament!",null);
    }

    @GetMapping("/tournaments/{name}/players")
    public BaseResponse getAllPlayersFromTournament(@PathVariable(value="name") String name) {
        var players = new ArrayList<Player>();
        try {
            players = foosballManager.getAllPlayersFromTournament(name);
        } catch (IllegalArgumentException e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(players,null);
    }

    @DeleteMapping("/tournaments")
    public BaseResponse removePlayerFromTournament(@RequestBody DeletePlayerFromTournamentRequest deletePlayerFromTournamentRequest) {
        try {
            foosballManager.removePlayer(deletePlayerFromTournamentRequest.getIdTournament(), deletePlayerFromTournamentRequest.getIdPlayer());
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse("Player was removed from the tournament!", null);
    }
}
