package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updatePrice extends AppCompatActivity
{
    //variable buttons
    Button updateprice;
    TextView pricefield;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateprice);

// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();


        updateprice = findViewById(R.id.updateprice);
        pricefield = findViewById(R.id.pricefield);
        updateprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*Intent intent = new Intent (updatePrice.this, loginSelect.class);
                startActivity(intent);
                finish();

                 */
                sample();
                System.out.println("Entering date into firebase");
            }
        });



    }

public void sample(){
    Item user = new Item("item008", "green top",15.00,35);

    mDatabase.child("items").setValue(user);
    System.out.println("Entering data into app");

}


    }



