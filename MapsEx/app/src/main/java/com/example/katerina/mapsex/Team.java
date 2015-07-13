package com.example.katerina.mapsex;


import java.util.ArrayList;

/**
 * Created by Katerina on 06.07.2015.
 */
public class Team {
    public String id;
    public String num_players;
    public String name;
    public ArrayList<User> arr_players;

    public Team(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getNum_players() {
        return num_players;
    }

    public void setNum_players(String num_players) {
        this.num_players = num_players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getArr_players() {
        return arr_players;
    }

    public void setArr_players(ArrayList<User> arr_players) {
        this.arr_players = arr_players;
    }


}
