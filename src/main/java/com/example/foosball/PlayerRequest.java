package com.example.foosball;

import java.util.List;

public class PlayerRequest {
    private String name;
    private String caca;
    private List<String> algo;

    public List<String> getAlgo() {
        return algo;
    }

    public void setAlgo(List<String> algo) {
        this.algo = algo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaca() {
        return caca;
    }

    public void setCaca(String caca) {
        this.caca = caca;
    }

    @Override
    public String toString() {
        return "PlayerRequest{" +
                "name='" + name + '\'' +
                ", caca='" + caca + '\'' +
                ", algo=" + algo +
                '}';
    }
}
