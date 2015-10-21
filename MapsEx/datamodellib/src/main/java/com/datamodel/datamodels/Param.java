package com.datamodel.datamodels;

/**
 * Created by Katerina on 10.07.2015.
 */
public class Param {



    private int ID;
    private String name;
    private int amount;
    private Game project;
    private int price;

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public Param(int ID, String name, int amount, Game project, int price) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.project = project;
        this.price = price;
    }


}
