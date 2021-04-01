package com.example.foosball;
import java.util.ArrayList;

public class Tournament {
    private String name;
    private int id;
    private ArrayList<Player> players;
    private ArrayList<Match> schedule;

    public Tournament() {}

    public Tournament(int id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
        this.schedule = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }


    public void deletePlayer(Player player) {
        players.remove(player);
    }

    public void getSchedule() {
        ArrayList<Match> aux = new ArrayList<>();
        for(Match m: this.schedule) {
            System.out.println(m.getPlayers());
            System.out.println(m.getScore());
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setSchedule(ArrayList<Match> schedule) {
        this.schedule = schedule;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

//    public ArrayList<Player> getListPlayers() {
//        return this.players;
//    }
//    public ArrayList<Match> generateSchedule() {
//        ArrayList<Match> aux = new ArrayList<>();
//        for(Player p1: players) {
//            for(Player p2: players) {
//                var match = new Match(p1, p2);
//                boolean matchAlready = false;
//                for(Match m: aux) {
//                    if (m.sameMatch(match))
//                        matchAlready = true;
//                }
//                if((p1 != p2) && (matchAlready == false)) {
//                    aux.add(match);
//                }
//            }
//        }
//        var random = new Random();
//        while(aux.size() != 0) {
//            int randomNum = random.nextInt(players.size());
//            schedule.add(aux.get(randomNum));
//            aux.remove(randomNum);
//        }
//        return schedule;
//    }
}
