package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class myAccount extends AppCompatActivity
{
    //variables for database
    private TextView nameTextView;
    private DatabaseReference nDatabase;
    private TextView emailTextView;
    private DatabaseReference eDatabase;
    private TextView birthTextView;
    private DatabaseReference bDatabase;

    //Button variables
    Button cs; //continue shopping
    Button lg; //log out button

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_acc);

        nameTextView = (TextView) findViewById(R.id.accName);
        nDatabase = FirebaseDatabase.getInstance().getReference("Name").child("fName");

        nDatabase.child("fName").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String firstName = snapshot.getValue(String.class);
                nameTextView.setText(firstName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });

        emailTextView = (TextView) findViewById(R.id.emailAcc);
        eDatabase = FirebaseDatabase.getInstance().getReference("Email").child("accEmail");

        eDatabase.child("accEmail").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String accountEmail = snapshot.getValue(String.class);
                emailTextView.setText(accountEmail);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        birthTextView = (TextView) findViewById(R.id.dateBirth);
        bDatabase = FirebaseDatabase.getInstance().getReference("Birth").child("accBirth");

        bDatabase.child("accBirth").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String accountBirth = snapshot.getValue(String.class);
                birthTextView.setText(accountBirth);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        cs = findViewById(R.id.button3);
        lg = findViewById(R.id.button2);

        browser();
        loginSelect();

    }

    public void browser()
    {
        cs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(myAccount.this, browser.class);
                startActivity(intent);
            }
        });
    }

    public void loginSelect()
    {
        lg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(myAccount.this, loginSelect.class);
            }
        });
    }


}
