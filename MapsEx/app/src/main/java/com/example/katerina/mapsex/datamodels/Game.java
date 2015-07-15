package com.example.katerina.mapsex.datamodels;

import android.text.format.Time;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Katerina on 06.07.2015.
 */
public class Game {
    public String ID;
    public String name;
    public Date date;
    public Time start_time;
    public Time end_time;
    public String description;
    public LatLng start_point;
    public ArrayList<Location> base_loc;
    public ArrayList<Param> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Location> getBase_loc() {
        return base_loc;
    }

    public void setBase_loc(ArrayList<Location> base_loc) {
        this.base_loc = base_loc;
    }

    public ArrayList<Param> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Param> parameters) {
        this.parameters = parameters;
    }




    public Game(String ID, String name, LatLng start_point){
        this(ID,name);
        this.start_point=start_point;
    }
    public Game(String ID,String name, ArrayList<Location> locations){
        this(ID,name);
        this.base_loc=locations;

    }

    public Game(){}


    Game(String ID,String name){
        this.ID=ID;
        this.name=name;
    }

}
