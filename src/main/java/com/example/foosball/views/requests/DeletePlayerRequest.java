package com.example.foosball.views.requests;

public class DeletePlayerRequest {
    private int player_id;
    private int age;
    private String name;

    public DeletePlayerRequest(int player_id, int age, String name) {
        this.player_id = player_id;
        this.age = age;
        this.name = name;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
