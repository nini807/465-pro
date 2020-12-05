package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class customerLogin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailLog;
    private EditText password_text;
    Button login;
    private String email;
    private String password;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_login);

        login = findViewById(R.id.log);
        emailLog = findViewById(R.id.email);
        password_text = findViewById(R.id.pass);

        mAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
                // if(username.getText().toString().equals("customer") &&
                            /*password.getText().toString().equals("customer")) {
                        Toast.makeText(getApplicationContext(),
                                "Redirecting...",Toast.LENGTH_SHORT).show();
                        //correct password
                    }else{ //wrong password
                        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                                tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.BLUE);
                        counter--;
                        tx1.setText(Integer.toString(counter));
                    }
                }
            });

            password.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });*/
            }
        });
    }
    public void test(){
        Intent intent = new Intent(this,smMenu.class);
        startActivity(intent);
    }
}