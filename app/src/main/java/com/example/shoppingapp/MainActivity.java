package com.example.shoppingapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    //variable buttons
    Button loginButton;
    Button guestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        loginButton = findViewById(R.id.Login);
        guestButton = findViewById(R.id.Guest);

        loginSelect();
        browser();

    }

    public void loginSelect()
    {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (MainActivity.this, loginSelect.class);
                startActivity(intent);
            }
        });
    }

    public void browser()
    {
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (MainActivity.this, browser.class);
                startActivity(intent);
            }
        });
    }

}
