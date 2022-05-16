package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class view_cus_phone extends AppCompatActivity {

    private Button GoPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cus_phone);

        GoPayment = (Button) findViewById(R.id.GoPayment);
        GoPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent H = new Intent(view_cus_phone.this,payment.class);
                startActivity(H);
            }
        });
    }
}