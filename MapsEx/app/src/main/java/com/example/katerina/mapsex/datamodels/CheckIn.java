package com.example.katerina.mapsex.datamodels;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class CheckIn {
    public int ID;
    public User user;
    public Team team;
    public LatLng location;
    public ArrayList<Param> garb_param;
    public int photo;
    public String comment;
    private LatLng position;

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public ArrayList<Param> getGarb_param() {
        return garb_param;
    }

    public void setGarb_param(ArrayList<Param> garb_param) {
        this.garb_param = garb_param;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getID() {
        return ID;
    }

    public CheckIn(String comment, LatLng location) {
        this.comment = comment;
        this.location = location;
    }

    public String getName() {
        return comment;
    }

    public LatLng getPosition() {
        return position;
    }
}
