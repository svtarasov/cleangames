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
}
