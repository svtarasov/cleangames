package com.datamodel.datamodels;

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
    public boolean isAdmin;

    public Time getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Time createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAmin(boolean isAmin) {
        this.isAdmin = isAdmin;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }


    public Time createdTime;

    public User(String id, String name){
             this.id = id;
               this.name = name;
           }
    public User(String id, String name, String surname,boolean isAdmin ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
    }

    public User(String id, String name, String surname, Team team, boolean isAdmin ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.team = team;
        this.isAdmin = isAdmin;
    }

    public User(){}
}
