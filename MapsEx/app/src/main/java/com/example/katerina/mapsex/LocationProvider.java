package com.example.katerina.mapsex;

import com.example.katerina.mapsex.datamodels.CheckIn;
import com.example.katerina.mapsex.datamodels.Game;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by 1 on 16.07.2015.
 */
public class LocationProvider {
    private static LatLng location;
    private static CheckIn checkIn;
    private static LocationProvider instance;
    private LocationProvider(LatLng location){
        this.location=location;

    }
    public static  LocationProvider Initialize(LatLng location, boolean change){
        if (!change){  return instance;}
            else { instance = new LocationProvider(location);return instance;}
    }
    public static  LocationProvider Initialize(){
        return instance;
    }

    public void setCheckin(CheckIn checkIn){
        this.checkIn=checkIn;
    }

    public CheckIn getCheckin(){
        return this.checkIn;
    }


    public LatLng getLocataion(){
        return this.location;
    }
}
