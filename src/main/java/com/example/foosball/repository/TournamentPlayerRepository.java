package com.example.foosball.repository;

import com.example.foosball.models.Player;
import com.example.foosball.models.TournamentPlayers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TournamentPlayerRepository extends CrudRepository<TournamentPlayers, Integer> {
    ArrayList<TournamentPlayers> getByPlayerId(int player_id);
    ArrayList<TournamentPlayers> findAllByTournamentId(int tournamentId);
}
