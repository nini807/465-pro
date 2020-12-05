package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginSelect extends AppCompatActivity {
    //Variable buttons
    Button cButton; //Customer button
    Button imButton; //Inventory manager button
    Button smButton; //Store manager button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_select);

        cButton = findViewById(R.id.cl);
        imButton = findViewById(R.id.il);
        smButton = findViewById(R.id.sl);

        customerLogin();
        imLogin();
        smLogin();
    }

    public void customerLogin()
    {
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(loginSelect.this, customerLogin.class);
                startActivity(intent);
            }
        });
    }

    public void imLogin()
    {
        imButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(loginSelect.this, imLogin.class);
                startActivity(intent);
            }
        });
    }

    public void smLogin()
    {
        smButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(loginSelect.this, smMenu.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
