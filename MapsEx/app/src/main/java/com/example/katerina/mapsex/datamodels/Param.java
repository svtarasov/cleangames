package com.example.katerina.mapsex.datamodels;

import com.example.katerina.mapsex.datamodels.Game;

/**
 * Created by Katerina on 10.07.2015.
 */
public class Param {
    public int ID;
    public String name;
    public int amount;
    public Game project;
    public int price;
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Game getProject() {
        return project;
    }

    public void setProject(Game project) {
        this.project = project;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Param(String name,int amount){
        this.amount=amount;
        this.name=name;
    }



}
