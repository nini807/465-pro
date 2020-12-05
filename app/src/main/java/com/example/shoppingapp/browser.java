package com.example.shoppingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


import java.util.ArrayList;

public class browser extends  AppCompatActivity
{
    //Variable buttons
    Button accButton; //Account button
    Button wlButton; //Wish List button
    Button cartButton; //cart Button

    //variable list
    ListView bl; //browser list
    public static ArrayList<String> bListName;
    public static ArrayList<String> bListPrice;
    public static ArrayAdapter<String> adapter;

    //variable search
    SearchView broSearch; // Search the browser


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        accButton = findViewById(R.id.acc);
        wlButton = findViewById(R.id.wl);
        cartButton = findViewById(R.id.cart);
        bl = findViewById(R.id.browserList);
        broSearch = findViewById(R.id.broSearch);

        //List functions
        bListName = new ArrayList<>();
        bListPrice = new ArrayList<>();


        myAccount();
        wishList();
        viewCart();


    }

    public void myAccount()
    {
        accButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(browser.this, myAccount.class);
                startActivity(intent);
            }
        });
    }

    public void wishList()
    {
        wlButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(browser.this, wishList.class);
                startActivity(intent);
            }
        });
    }

    public void viewCart()
    {
        cartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(browser.this, viewCart.class);
            }
        });
    }




}
