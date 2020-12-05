package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class updatePrice extends AppCompatActivity
{
    //variable buttons
    Button updateprice;
    TextView pricefield;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateprice);

        updateprice = findViewById(R.id.updateprice);
        pricefield = findViewById(R.id.pricefield);
        updateprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (updatePrice.this, loginSelect.class);
                startActivity(intent);
                finish();
            }
        });



    }




    }



