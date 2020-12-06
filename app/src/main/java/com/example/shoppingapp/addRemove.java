package com.example.shoppingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class addRemove extends AppCompatActivity
{
    Button add;
    EditText id;
    EditText name;
    EditText quanity;
    EditText cost;
    private DatabaseReference mDatabase;
    String[] mobileArray = {"item001"};
    ArrayAdapter adapter2;
    List<String> itemsarray = new ArrayList<String>();
    ListView listView;

    String selectitem ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_remove);

// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();

        add = findViewById(R.id.ai);
        id = findViewById(R.id.editTextNumber);
        name = findViewById(R.id.itemName);
        quanity= findViewById(R.id.quanityfield);
        cost = findViewById(R.id.costfield);



        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        listView = (ListView) findViewById(R.id.arList);
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }


        };
        listView.setOnItemClickListener(listener);

        listView.setItemsCanFocus(true);
        readitems();



        add.setOnClickListener(new View.OnClickListener() {
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
        String p = cost.getText().toString();
        double t = Double.parseDouble(p);
        selectitem = id.getText().toString();
        String itemname = name.getText().toString();
        String quanitiy = quanity.getText().toString();
        int q = Integer.valueOf(quanitiy);
        Item item = new Item(selectitem,itemname,t,q);
        HashMap<String, Object> items = new HashMap<String, Object>();
        items.put(selectitem, item);
        mDatabase.child("items").updateChildren(items);
        System.out.println("Entering data into app");


    }

    public void readitems() {

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    Iterable<DataSnapshot> iter = messageSnapshot.getChildren();
                    while(iter.iterator().hasNext()){
                        itemsarray.add(iter.iterator().next().getKey());
                    }



                }
                adapter2 = new ArrayAdapter<String>(addRemove.this,
                        R.layout.activity_listview, itemsarray);
                adapter2.notifyDataSetChanged();
                listView.setAdapter(adapter2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }



}





