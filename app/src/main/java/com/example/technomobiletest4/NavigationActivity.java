package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigationActivity extends AppCompatActivity {


    private Button GoProfile,GoContactUs,GoAboutUs;


    private Button GoCategory;
    //private Button GoReview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        GoProfile =(Button) findViewById(R.id.GoProfile);
        GoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent P = new Intent(NavigationActivity.this,ProfileActivity.class);
                startActivity(P);
            }
        });

        GoCategory = (Button) findViewById(R.id.GoCategory);
        GoCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Q = new Intent(NavigationActivity.this,AllPhoneCategory.class);
                startActivity(Q);
            }
        });





    }
}