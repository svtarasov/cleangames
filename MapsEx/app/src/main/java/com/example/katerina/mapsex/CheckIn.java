package com.example.katerina.mapsex;

import com.google.android.gms.maps.model.LatLng;

public class CheckIn {
    private String name;
    private LatLng position;

    public CheckIn(String name, LatLng position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public LatLng getPosition() {
        return position;
    }
}
