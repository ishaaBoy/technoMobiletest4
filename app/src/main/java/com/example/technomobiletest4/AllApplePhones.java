package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AllApplePhones extends AppCompatActivity {

    private Button GoPayment1;
    private Button GoPayment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_apple_phones);

        GoPayment1 = (Button) findViewById(R.id.GoPayment1);
        GoPayment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent K = new Intent(AllApplePhones.this,payment.class);
                startActivity(K);
            }
        });

        GoPayment2 = (Button) findViewById(R.id.GoPayment2);
        GoPayment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent L = new Intent(AllApplePhones.this,payment.class);
                startActivity(L);
            }
        });
    }
}