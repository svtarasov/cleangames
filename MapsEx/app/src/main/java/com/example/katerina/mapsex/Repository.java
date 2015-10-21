package com.example.katerina.mapsex;

import android.content.Context;
import android.widget.Toast;

import com.datamodel.datamodels.Game;
import com.datamodel.datamodels.Location;
import com.datamodel.datamodels.LocationRole;
import com.datamodel.datamodels.Team;
import com.datamodel.datamodels.User;
import com.google.android.gms.maps.model.LatLng;
import com.datamodel.datamodels.CheckIn;
import com.datamodel.datamodels.Param;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Katerina on 13.07.2015.
 */
public class Repository {

    public static ArrayList<CheckIn> getCheckins(){

        ArrayList<CheckIn> checkIns = new ArrayList<>();
        checkIns.add(new CheckIn("Я мусор",new ArrayList<Param>() ,new LatLng(20.35, 20.16)));
        checkIns.add(new CheckIn("Я мусор2",new ArrayList<Param>(), new LatLng(20.45, 20.15)));
        checkIns.add(new CheckIn("Я мусор3",new ArrayList<Param>(), new LatLng(20.45, 21.15)));
        return checkIns;
    }


    public static ArrayList<User> getUsers(Team team){
        ArrayList<User> exampleList = new ArrayList<User>();
        exampleList.add(new User("1", "Иванов Иван"));
        exampleList.add(new User("2", "Петров Петр"));
        exampleList.add(new User("3", "Андреев Андрей"));
        return exampleList;
    }

    public static ArrayList<Team> getTeams(Game game){
        ArrayList<Team> exampleList = new ArrayList<Team>();
        exampleList.add(new Team("1", "Солнечный город"));
        exampleList.add(new Team("2", "Майские жуки"));
        exampleList.add(new Team("3", "Трое в мусоре"));
        return exampleList;
    }

    public static ArrayList<Game> getGames(){
        ArrayList<Game> exampleList = new ArrayList<Game>();
        ArrayList<Location> loc1=new ArrayList<>();
        ArrayList<Location> loc2=new ArrayList<>();
        ArrayList<Location> loc3=new ArrayList<>();
        loc1.add(new Location("База", LocationRole.BASE ,new LatLng(48.35, 31.16)));
        loc1.add(new Location("Склад1", LocationRole.WAREHOUSE ,new LatLng(49.35, 32.16)));
        loc1.add(new Location("Склад2", LocationRole.WAREHOUSE ,new LatLng(47.35, 30.16)));
      /*
        exampleList.add(new Game("1", "Clean Peterhof1", new LatLng(48.35, 31.16)));
        exampleList.add(new Game("2", "Clean Peterhof2",new LatLng(8.35, 15.16)));
        exampleList.add(new Game("3", "Clean Cupchino",new LatLng(20.35, 20.16)));
        */
        exampleList.add(new Game("1", "Чистый Петергоф", loc1));

        loc2.add(new Location("База", LocationRole.BASE ,new LatLng(8.35, 15.16)));
        loc2.add(new Location("Склад1", LocationRole.WAREHOUSE ,new LatLng(10.35, 14.16)));
        loc2.add(new Location("Склад2", LocationRole.WAREHOUSE, new LatLng(11.35, 14.76)));
        exampleList.add(new Game("2", "Чистый Петергоф 2", loc2));

        loc3.add(new Location("База", LocationRole.BASE ,new LatLng(20.35, 20.16)));
        loc3.add(new Location("Склад1", LocationRole.WAREHOUSE ,new LatLng(21.35, 19.16)));
        loc3.add(new Location("Склад2", LocationRole.WAREHOUSE, new LatLng(20.05, 21.16)));
        exampleList.add(new Game("3", "Чистое Купчино",loc3));

        return exampleList;

    }

    public static ArrayList<Team> getRating(Game game){
        ArrayList<Team> exampleList = new ArrayList<Team>();
        exampleList.add(new Team("1", "Солнечный город", 39));
        exampleList.add(new Team("2", "Майские жуки", 28));
        exampleList.add(new Team("3", "Трое в мусоре", 1));
        return exampleList;
    }

    public static String createNewTeam(String teamName, final Context context, int userID) {
        Toast.makeText(context, teamName, Toast.LENGTH_SHORT).show();
        final String targetURL = "http://api.cleangames.ru/ServletTest/Servlet";
        final String urlParameters = "ActionType=CreateTeam&TeamName=" + teamName + "&UserID=" + userID;
        //  String urlParameters = "ActionType=CreateTeam&TeamName=" + teamName ;
        final String[] line = {"null"};
        //System.out.println(urlParameters);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                URL url;
                HttpURLConnection connection = null;
                try {
                    //Create connection
                    url = new URL(targetURL);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");

                    connection.setRequestProperty("Content-Length", "" +
                            Integer.toString(urlParameters.getBytes().length));
                    connection.setRequestProperty("Content-Language", "en-US");

                    connection.setUseCaches(false);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);


                    //Send request
                    OutputStream wr = connection.getOutputStream();
                    wr.write(urlParameters.getBytes("UTF-8"));
                    wr.flush();
                    wr.close();

                    //Get Response
                    //TextInputControl.Content is = connection.getContent();
                    //String is = response.getEntity;
                    //System.out.println(is);
                    InputStream is = connection.getInputStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                    while ((line[0] = rd.readLine()) != null) {
                        Toast.makeText(context, line[0], Toast.LENGTH_SHORT).show();
                        System.out.println(line[0]);
                    }
                    rd.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return line[0];
    }
}
