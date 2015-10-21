package com.datamodel.datamodels;

import android.graphics.Bitmap;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class CheckIn {
    private int ID;
    private User user;
    private Team team;
    private LatLng location;
    private ArrayList<Param> garb_param;
    private Bitmap photo;
    private String comment;


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

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
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
    public CheckIn(String comment, ArrayList<Param> garbage, LatLng location,Bitmap photo) {
        this.garb_param=garbage;
        this.comment = comment;
        this.location = location;
        this.photo=photo;
    }
    public CheckIn(String comment, ArrayList<Param> garbage, LatLng location) {
        this.garb_param=garbage;
        this.comment = comment;
        this.location = location;

    }

    public String getName() {
        return comment;
    }


}
