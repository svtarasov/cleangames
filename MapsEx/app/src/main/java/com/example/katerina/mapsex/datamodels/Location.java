package com.example.katerina.mapsex.datamodels;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Katerina on 10.07.2015.
 */
public class Location {
    public int ID;
    public int project_ID;
    public String name;
    public LocationRole role;
    public LatLng loc;

    public int getID() {
        return ID;
    }

    public int getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(int project_ID) {
        this.project_ID = project_ID;
    }

    public String getName() {
        return name;
    }

    public LocationRole getRole() {
        return role;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLoc() {
        return loc;
    }

    public void setLoc(LatLng loc) {
        this.loc = loc;
    }

    public Location(String name, LocationRole role,LatLng loc ){
        this.name=name;
        this.role=role;
        this.loc=loc;
    }



}
