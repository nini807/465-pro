package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class smMenu extends AppCompatActivity

{
    Button addremove;
    Button updatestock;
    Button dataanl;
    Button updateprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sm_menu);
        addremove = findViewById(R.id.ar);
        updatestock = findViewById(R.id.usSM);
        dataanl = findViewById(R.id.da);
        updateprice = findViewById(R.id.upSM);


        addremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changepage();
            }
        });
        updatestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changepage1();
            }
        });
        dataanl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changepage2();
            }
        });
        updateprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changepage3();
            }
        });
    }


    public void changepage (){
        Intent intent = new Intent(this,addRemove.class);
        startActivity(intent);
}
    public void changepage1 (){
        Intent intent = new Intent(this,updateStock.class);
        startActivity(intent);
    }
    public void changepage2 (){
        Intent intent = new Intent(this,dataAnalysis.class);
        startActivity(intent);
    }
    public void changepage3 (){
        Intent intent = new Intent(this,updatePrice.class);
        startActivity(intent);
        finish();
    }
}
