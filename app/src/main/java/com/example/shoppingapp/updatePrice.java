package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class updatePrice extends AppCompatActivity {
    //variable buttons
    Button updateprice;
    TextView pricefield;
    private DatabaseReference mDatabase;
    String[] mobileArray = {"item001", "item002", "item003", "item004",
            "item005", "item006", "item007", "item008"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateprice);

// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();


        updateprice = findViewById(R.id.updateprice);
        pricefield = findViewById(R.id.pricefield);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.priceList);
        listView.setAdapter(adapter);
        readitems();
        updateprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent (updatePrice.this, loginSelect.class);
                startActivity(intent);
                finish();

                 */
                sample();
                System.out.println("Entering date into firebase");
            }
        });


    }

    public void sample() {
        Item item = new Item("item016", "green top", 15.00, 35);
        HashMap<String, Object> items = new HashMap<String, Object>();
        items.put("item016", item);
        mDatabase.child("items").updateChildren(items);
        System.out.println("Entering data into app");


    }

    public void readitems() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    System.out.println(dataSnapshot.getValue());
                    System.out.println( messageSnapshot.child("item001").getValue());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}





