package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {


    private ImageView imgView;
    private Button newshopnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        imgView = (ImageView) findViewById(R.id.navigationS);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent G = new Intent(HomeActivity.this,NavigationActivity.class);
                startActivity(G);
            }
        });

        newshopnow = (Button) findViewById(R.id.newshopnow);
        newshopnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent Z = new Intent(HomeActivity.this,NavigationActivity.class);
                startActivity(Z);
=======
                Intent H = new Intent(HomeActivity.this,view_phones.class);
                startActivity(H);
>>>>>>> parent of 3ac2952 (Merge pull request #7 from ishaaBoy/iZZa119)
            }
        });


            

    }
}