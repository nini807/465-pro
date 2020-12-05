package com.example.shoppingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class dataAnalysis extends AppCompatActivity
{
    DatabaseReference databaseItems;
    ArrayAdapter<String> adapter;
    BarChart data;
    ListView il;
    ArrayList<String> items;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_analysis);
        items = new ArrayList<>();
        il = findViewById(R.id.itemBrought);
        databaseItems = FirebaseDatabase.getInstance().getReference("items");

        adapter = new ArrayAdapter(dataAnalysis.this, android.R.layout.simple_expandable_list_item_1, android.R.id.text2, items)
        {
            @Override
            public View getView(int position, View ConvertView, ViewGroup parent)
            {
                View view = super.getView(position, ConvertView, parent);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text2.setTextColor(Color.WHITE);
                text2.setTextSize(20);

                return view;
            }
        };

        data = (BarChart)findViewById(R.id.dataGraph);
        data.setDrawBarShadow(false);
        data.setDrawValueAboveBar(true);
        data.setMaxVisibleValueCount(50);
        data.setPinchZoom(false);
        data.setDrawGridBackground(true);

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        databaseItems.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<BarEntry> barEntries = new ArrayList<>();
                int k = 1;
                for(DataSnapshot itemsSnapShot: snapshot.getChildren()){
                    String name = itemsSnapShot.child("name").getValue(String.class);
                    String stock = itemsSnapShot.child("stock").getValue(String.class);

                    if(Integer.parseInt(stock) <= 25){
                        items.add(name);
                        barEntries.add(new BarEntry(k, (int) Float.parseFloat(stock)));
                        k++;

                    }
                }

                il.setAdapter(adapter);

                BarDataSet barDataSet = new BarDataSet(barEntries, "Items Brought");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setBarSpacePercent(50f);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
