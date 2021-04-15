package com.example.foosball.repository;

import com.example.foosball.models.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Integer> {
    Tournament getByName(String name);
}
