package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class imMenu extends AppCompatActivity
{
    //Variable buttons
    Button aR;
    Button uStock;

    @Override
    protected void onCreate(Bundle savedInstanceStance)
    {
        super.onCreate(savedInstanceStance);
        setContentView(R.layout.im_menu);

        aR = findViewById(R.id.arIM);
        uStock = findViewById(R.id.usIM);

        updateStock();
        addRemove();
    }

    public void updateStock()
    {
        uStock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(imMenu.this, updateStock.class);
                startActivity(intent);
            }
        });
    }

    public void addRemove()
    {
        aR.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(imMenu.this, addRemove.class);
                startActivity(intent);
            }
        });
    }
}
