package com.example.katerina.mapsex;

import android.text.format.Time;

/**
 * Created by Katerina on 06.07.2015.
 */
public class User {
    public  String id;
    public String name;
    public String surname;
    public String email;
    public Team team;
    public boolean isAmin;
    public Time createdTime;

    public User(String id, String name){
             this.id = id;
               this.name = name;
           }
}
