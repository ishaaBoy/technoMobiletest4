package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminProfile extends AppCompatActivity {


    private Button createPost;
    private Button CREATEOFFERS;
    private Button QUICK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);



        createPost = (Button) findViewById(R.id.createPost);
        createPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent A = new Intent(AdminProfile.this,AddPhones.class);
                startActivity(A);
            }
        });

        CREATEOFFERS =(Button) findViewById(R.id.BBB);
        CREATEOFFERS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Z = new Intent(AdminProfile.this,thela.class);
                startActivity(Z);
            }
        });

        QUICK =(Button) findViewById(R.id.DD);
        QUICK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent X = new Intent(AdminProfile.this,MoreActivity.class);
                startActivity(X);
            }
        });









    }
}