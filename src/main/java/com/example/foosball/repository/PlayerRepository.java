package com.example.foosball.repository;

import com.example.foosball.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Player getByName(String name);
}
