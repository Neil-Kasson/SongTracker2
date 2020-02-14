package com.example.songtracker;

public class Item {
    private String name;
    private String date;

    public Item(String n, String d){
        name = n;
        date = d;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }
}
