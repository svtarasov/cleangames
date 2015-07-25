package com.datamodel.datamodels;

import android.text.format.Time;

/**
 * Created by Katerina on 06.07.2015.
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private Team team;
    private boolean isAdmin;
    private Time createdTime;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    public User(int id, String name){
             this.id = id;
               this.name = name;
           }
    public User(int id, String name, String surname,boolean isAdmin ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
    }

    public User(int id, String name, String surname, Team team, boolean isAdmin ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.team = team;
        this.isAdmin = isAdmin;
    }

    public User(){}

    public User(int id, boolean isAdmin, Team team, String email, String surname, String name, Time createdTime) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.team = team;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.createdTime = createdTime;
    }
}
