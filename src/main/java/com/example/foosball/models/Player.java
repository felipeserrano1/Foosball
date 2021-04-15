package com.example.foosball.models;

import javax.persistence.*;

@Entity(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;
    @Column(name = "player_name")
    private String name;
    private int age;

    public Player(int playerId, String name, int age) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
    }

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void changePlayerName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreatePlayerRequest{" +
                "name='" + name + '\'' +
                "id=" + playerId + '\'' +
                "age=" + age + '\'' +
                '}';
    }
}
