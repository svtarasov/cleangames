package com.example.katerina.mapsex;

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
        exampleList.add(new Game("1", "Clean Peterhof1"));
        exampleList.add(new Game("2", "Clean Peterhof2"));
        exampleList.add(new Game("3", "Clean Cupchino"));
        return exampleList;

    }
    public static void getRating(Game game){

    }
}
