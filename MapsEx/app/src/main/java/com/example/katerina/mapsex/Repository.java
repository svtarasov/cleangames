package com.example.katerina.mapsex;

import com.example.katerina.mapsex.datamodels.Game;
import com.example.katerina.mapsex.datamodels.Location;
import com.example.katerina.mapsex.datamodels.LocationRole;
import com.example.katerina.mapsex.datamodels.Team;
import com.example.katerina.mapsex.datamodels.User;
import com.google.android.gms.maps.model.LatLng;
import com.example.katerina.mapsex.datamodels.*;

import java.util.ArrayList;

/**
 * Created by Katerina on 13.07.2015.
 */
public class Repository {
    public static ArrayList<User> getUsers(Team team){
        ArrayList<User> exampleList = new ArrayList<User>();
        exampleList.add(new User("1", "Ivanov Ivan"));
        exampleList.add(new User("2", "Petrov Petr"));
        exampleList.add(new User("3", "Slavnyi Slava"));
        return exampleList;
    }
    public static ArrayList<Team> getTeams(Game game){
        ArrayList<Team> exampleList = new ArrayList<Team>();
        exampleList.add(new Team("1", "Sun"));
        exampleList.add(new Team("2", "Beatles"));
        exampleList.add(new Team("3", "Three in the garbage"));
        return exampleList;
    }
    public static ArrayList<Game> getGames(){
        ArrayList<Game> exampleList = new ArrayList<Game>();
        ArrayList<Location> loc1=new ArrayList<>();
        ArrayList<Location> loc2=new ArrayList<>();
        ArrayList<Location> loc3=new ArrayList<>();
        loc1.add(new Location("Base", LocationRole.BASE ,new LatLng(48.35, 31.16)));
        loc1.add(new Location("Ware1", LocationRole.WAREHOUSE ,new LatLng(49.35, 32.16)));
        loc1.add(new Location("Ware2", LocationRole.WAREHOUSE ,new LatLng(47.35, 30.16)));
      /*  exampleList.add(new Game("1", "Clean Peterhof1", new LatLng(48.35, 31.16)));
        exampleList.add(new Game("2", "Clean Peterhof2",new LatLng(8.35, 15.16)));
        exampleList.add(new Game("3", "Clean Cupchino",new LatLng(20.35, 20.16)));*/
        exampleList.add(new Game("1", "Clean Peterhof1", loc1));

        loc2.add(new Location("Base", LocationRole.BASE ,new LatLng(8.35, 15.16)));
        loc2.add(new Location("Ware1", LocationRole.WAREHOUSE ,new LatLng(10.35, 14.16)));
        loc2.add(new Location("Ware2", LocationRole.WAREHOUSE, new LatLng(11.35, 14.76)));
        exampleList.add(new Game("2", "Clean Peterhof2", loc2));

        loc3.add(new Location("Base", LocationRole.BASE ,new LatLng(20.35, 20.16)));
        loc3.add(new Location("Ware1", LocationRole.WAREHOUSE ,new LatLng(21.35, 19.16)));
        loc3.add(new Location("Ware2", LocationRole.WAREHOUSE, new LatLng(20.05, 21.16)));
        exampleList.add(new Game("3", "Clean Cupchino",loc3));

        return exampleList;

    }
    public static ArrayList<Team> getRating(Game game){
        ArrayList<Team> exampleList = new ArrayList<Team>();
        exampleList.add(new Team("1", "Sun", 39));
        exampleList.add(new Team("2", "Beatles", 28));
        exampleList.add(new Team("3", "Three in the garbage", 1));
        return exampleList;
    }
}
