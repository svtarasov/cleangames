package com.datamodel.datamodels;


import java.util.ArrayList;

/**
 * Created by Katerina on 06.07.2015.
 */
public class Team {
    public String id;
    public String num_players;
    public String name;
    public ArrayList<User> arr_players;
    public int total_scores;


    public int getTotal_scores() {
        return total_scores;
    }

    public void setTotal_scores(int total_scores) {
        this.total_scores = total_scores;
    }

    public Team(){}
    public Team(String id,String name){
        this.id = id;
        this.name = name;
    }
    public Team(String id, String name, int scores){
        this.id = id;
        this.name = name;
        this.total_scores = scores;
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
