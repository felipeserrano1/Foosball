package com.example.foosball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoosballController {
    private List<Player> players = new ArrayList<>();

    @Autowired
    public FoosballController() {

    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return this.players;
    }

    @GetMapping("/players/{name}")
    public Player getPlayerByName(@PathVariable(value="name") String name) {
        System.out.println("finding player with name " + name);

        for (var p: this.players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        throw new IllegalArgumentException("invalid name");
    }

    @PostMapping("/players")
    public String createPlayer(@RequestBody PlayerRequest playerRequest) {
        System.out.println("player received " + playerRequest);

        return "player added";
    }
}
