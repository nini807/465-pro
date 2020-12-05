package com.example.shoppingapp;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Item {

    public String id;
    public String name;
    public double price;
    public int stock;


    public Item() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Item(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

}
