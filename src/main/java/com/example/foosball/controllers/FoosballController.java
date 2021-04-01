package com.example.foosball.controllers;

import com.example.foosball.services.FoosballService;
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
    private FoosballService foosballService;

    @Autowired
    public FoosballController() {
        this.foosballService = new FoosballService();
    }

    @GetMapping("/players")
    public BaseResponse getAllPlayers() {
        return new BaseResponse(foosballService.getPlayers(), null);
    }

    @GetMapping("/players/name/{name}")
    public BaseResponse getPlayerByName(@PathVariable(value="name") String name) {
        Player player;
        try {
            player = foosballService.getPlayerByName(name);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(player, null);
    }

    @GetMapping("/players/id/{id}")
    public BaseResponse getPlayerByID(@PathVariable(value="id") int id) {
        Player player;
        try {
            player = foosballService.getPlayerByID(id);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        String payload = String.format("id:%d  name:%s  age:%d", player.getId(), player.getName(), player.getAge());
        return new BaseResponse(payload, null);
    }

    @PostMapping("/players")
    public BaseResponse createPlayers(@RequestBody PlayerRequest playerRequest) {
        return new BaseResponse(foosballService.createPlayers(playerRequest.getPlayers()), null);
    }

    @GetMapping("/tournaments/id/{id}")
    public BaseResponse getTournamentByID(@PathVariable(value="id") int id) {
        Tournament tournament;
        try {
            tournament = foosballService.getTournamentByID(id);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(tournament, null);
    }

    @GetMapping("/tournaments/name/{name}")
    public BaseResponse getTournamentByName(@PathVariable(value="name") String name) {
        Tournament tournament;
        try {
            tournament = foosballService.getTournamentByName(name);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(tournament, null);
    }

    @GetMapping("/tournaments")
    public BaseResponse getAllTournaments() {
        return new BaseResponse(foosballService.getAllTournaments(), null);
    }

    @PostMapping("/tournaments")
    public BaseResponse createTournament(@RequestBody CreateTournamentRequest createTournamentRequest) {
        try {
            return new BaseResponse(foosballService.createTournament(createTournamentRequest.getName()), null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/tournaments")
    public BaseResponse addPlayerTournament(@RequestBody AddPlayerToTournamentRequest addPlayerToTournamentRequest) {
        try {
            new BaseResponse(foosballService.addPlayerTournament(addPlayerToTournamentRequest.getIdTournament(), addPlayerToTournamentRequest.getPlayer_name(), addPlayerToTournamentRequest.getPlayer_id()),null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse("Player was added to tournament!",null);
    }

    @GetMapping("/tournaments/{id}/players")
    public BaseResponse getAllPlayersFromTournament(@PathVariable(value="id") int id) {
        var players = new ArrayList<Player>();
        try {
            players = foosballService.getAllPlayersFromTournament(id);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(players,null);
    }

    @DeleteMapping("/tournaments")
    public BaseResponse removePlayerFromTournament(@RequestBody DeletePlayerFromTournamentRequest deletePlayerFromTournamentRequest) {
        try {
            foosballService.removePlayerFromTournament(deletePlayerFromTournamentRequest.getTournament_id(), deletePlayerFromTournamentRequest.getPlayer_id());
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse("Player was removed from the tournament!", null);
    }
}
