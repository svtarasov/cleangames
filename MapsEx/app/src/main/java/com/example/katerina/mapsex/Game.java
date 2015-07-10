package com.example.katerina.mapsex;

import android.text.format.Time;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Katerina on 06.07.2015.
 */
public class Game {
    public int ID;
    public String name;
    public Date date;
    public Time start_time;
    public Time end_time;
    public String description;
    public ArrayList<Location> base_loc;
    public ArrayList<Param> parameters;
}
