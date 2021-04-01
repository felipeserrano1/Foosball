package com.example.foosball;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {

    //private static final AtomicInteger count = new AtomicInteger(0);
    //private int id = 0;
    private int id;
    private String name;
    private int age;

    public Player(int id, String name, int age) {
        //this.id = count.incrementAndGet();
        this.id = id;
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

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PlayerRequest{" +
                "name='" + name + '\'' +
                "id=" + id + '\'' +
                "age=" + id + '\'' +
                '}';
    }
}
