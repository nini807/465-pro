package com.example.shoppingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class updatePrice extends AppCompatActivity {
    //variable buttons
    Button updateprice;
    TextView pricefield;
    private DatabaseReference mDatabase;
    String[] mobileArray = {"item001"};
List<String> itemsarray = new ArrayList<String>();
    List<String> specificitemsarray = new ArrayList<String>();
ListView listView;
ArrayAdapter adapter2;
String selectitem ;

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

        listView = (ListView) findViewById(R.id.priceList);
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                readoneitem(position);
            }


        };
        listView.setOnItemClickListener(listener);

        listView.setItemsCanFocus(true);
        readitems();
        String[] strArray = itemsarray.toArray(new String[itemsarray.size()]);


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
        String p = pricefield.getText().toString();
        double t = Double.parseDouble(p);
        Item item = new Item(selectitem,"green top",t,35);
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
                adapter2 = new ArrayAdapter<String>(updatePrice.this,
                        R.layout.activity_listview, itemsarray);
                adapter2.notifyDataSetChanged();
                listView.setAdapter(adapter2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
    public void readoneitem(final int a) {

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    Iterable<DataSnapshot> iter = messageSnapshot.getChildren();
                    while (iter.iterator().hasNext()) {
                        specificitemsarray.add(iter.iterator().next().getKey());
                        //System.out.println(iter.iterator().next().getValue());
                    }


                    System.out.println(messageSnapshot.child(specificitemsarray.get(a)).getKey());
                    try {
                        selectitem = messageSnapshot.child(specificitemsarray.get(a)).getKey();
                      //  System.out.println(selectitem.get("price"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

    }

    public static Map getMap(String obj) throws Exception {
        Gson gson = new Gson();


        Map result = gson.fromJson(obj.trim(), Map.class);
        return result;
    }
}





