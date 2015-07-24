package com.datamodel.datamodels;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Katerina on 10.07.2015.
 */
public class Location {


    private int ID;
    private int project_ID;
    private String comment;
    private LocationRole role;
    private LatLng loc;

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }

    public int getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(int project_ID) {
        this.project_ID = project_ID;
    }

    public String getComment() {
        return comment;
    }

    public LocationRole getRole() {
        return role;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public LatLng getLoc() {
        return loc;
    }

    public void setLoc(LatLng loc) {
        this.loc = loc;
    }

    public Location(int ID, int project_ID, String name, LocationRole role, LatLng loc ){
        this.ID = ID;
        this.project_ID = project_ID;
        this.comment =name;
        this.role=role;
        this.loc=loc;
    }

    public Location(){}

    public Location(String name, LocationRole role,LatLng loc ){

        this.comment =name;
        this.role=role;
        this.loc=loc;
    }



}
