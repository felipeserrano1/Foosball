package com.example.foosball.controllers;

import com.example.foosball.models.TournamentPlayers;
import com.example.foosball.repository.PlayerRepository;
import com.example.foosball.repository.TournamentPlayerRepository;
import com.example.foosball.repository.TournamentRepository;
import com.example.foosball.views.requests.*;
import com.example.foosball.services.FoosballService;
import com.example.foosball.models.Player;
import com.example.foosball.models.Tournament;
import com.example.foosball.views.responses.BaseResponse;
import com.example.foosball.views.responses.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FoosballController {
    private FoosballService foosballService;

    @Autowired
    public FoosballController(PlayerRepository playerRepository, TournamentRepository tournamentRepository, TournamentPlayerRepository tournamentPlayerRepository) {
        this.foosballService = new FoosballService(playerRepository, tournamentRepository, tournamentPlayerRepository);
    }

    @GetMapping("/players")
    public BaseResponse getAllPlayers() throws Exception {
        try {
            return new BaseResponse(foosballService.getAllPlayers(), null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
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
        String payload = String.format("id:%d name:%s age:%d", player.getPlayerId(), player.getName(), player.getAge());
        return new BaseResponse(payload,null);
    }

    @PostMapping("/players")
    public BaseResponse createPlayers(@RequestBody CreatePlayerRequest createPlayerRequest) {
        try {
            return new BaseResponse(foosballService.createPlayers(createPlayerRequest.getPlayers()), null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
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
        try {
            return new BaseResponse(foosballService.getAllTournaments(), null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/tournaments")
    public BaseResponse createTournament(@RequestBody CreateTournamentRequest createTournamentRequest) {
        try {
            return new BaseResponse(foosballService.createTournament(createTournamentRequest.getTournaments()), null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/tournaments/players")
    public BaseResponse addPlayerTournament(@RequestBody AddPlayerToTournamentRequest addPlayerToTournamentRequest) {
        try {
            return new BaseResponse(foosballService.addPlayerTournament(addPlayerToTournamentRequest.getTournamentPlayers()),null);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/tournaments/{id}/players")
    public BaseResponse getAllPlayersFromTournament(@PathVariable(value="id") int id) {
        var playersTournament = new ArrayList<TournamentPlayers>();
        try {
            playersTournament = foosballService.getAllPlayersFromTournament(id);
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse(playersTournament,null);
    }

    @DeleteMapping("/players")
    public BaseResponse removePlayer(@RequestBody DeletePlayerRequest deletePlayerRequest) {
        try {
            var player = new Player(deletePlayerRequest.getPlayer_id(), deletePlayerRequest.getName(), deletePlayerRequest.getAge());
            foosballService.removePlayer(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseResponse("Player was removed!", null);
    }

    @DeleteMapping("/tournaments")
    public BaseResponse removeTournament(@RequestBody DeleteTournamentRequest deleteTournamentRequest) {
        try {
            var tournament = new Tournament(deleteTournamentRequest.getTournamentId(), deleteTournamentRequest.getName());
            foosballService.removeTournament(tournament);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseResponse("Tournament was removed!", null);
    }

    @DeleteMapping("/tournaments/players")
    public BaseResponse removePlayerFromTournament(@RequestBody DeletePlayerFromTournamentRequest deletePlayerFromTournamentRequest) {
        try {
            foosballService.removePlayerFromTournament(deletePlayerFromTournamentRequest.getId());
        } catch (Exception e) {
            return new BaseResponse(null, new ErrorResponse(e.getMessage()));
        }
        return new BaseResponse("Player was removed from the tournament!", null);
    }
}
