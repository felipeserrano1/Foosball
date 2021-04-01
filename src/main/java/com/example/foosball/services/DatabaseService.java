package com.example.foosball.services;

public class DatabaseService {
    private String url;

    public String getUrl() {
        return url;
    }

    public DatabaseService() {
        this.url = "jdbc:mysql://localhost:3306/foosball";
    }
}
