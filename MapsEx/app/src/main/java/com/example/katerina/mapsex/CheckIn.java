package com.example.katerina.mapsex;

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

    public CheckIn(String comment, LatLng position) {
        this.comment = comment;
        this.position = position;
    }

    public String getName() {
        return comment;
    }

    public LatLng getPosition() {
        return position;
    }
}
