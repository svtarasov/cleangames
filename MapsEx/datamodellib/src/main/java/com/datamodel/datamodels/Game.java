package com.datamodel.datamodels;

import android.text.format.Time;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Katerina on 06.07.2015.
 */
public class Game {


    private int ID;
    private String name;
    private Date date;
    private Time start_time;
    private Time end_time;
    private String description;
    private LatLng start_point;
    private ArrayList<Location> base_loc;
    private ArrayList<Param> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
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

    public Game(int ID, String name, Date date, Time start_time, Time end_time, String description, ArrayList<Location> base_loc, LatLng start_point, ArrayList<Param> parameters) {
        this.ID = ID;
        this.name = name;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
        this.base_loc = base_loc;
        this.start_point = start_point;
        this.parameters = parameters;
    }


    public Game(int ID, String name, LatLng start_point){
        this(ID,name);
        this.start_point=start_point;
    }

   public Game(int ID,String name, ArrayList<Location> locations){
        this(ID,name);
        this.base_loc=locations;

    }

    public Game(){}


    Game(int ID,String name){
        this.ID=ID;
        this.name=name;
    }

}
