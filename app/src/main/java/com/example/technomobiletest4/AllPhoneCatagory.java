package com.example.technomobiletest4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApi;


public class AllPhoneCatagory extends Activity {

    private Button GoApplePhone;
    private Button GoSamsungPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_phone_catagory);


        GoApplePhone = (Button) findViewById(R.id.GoApplePhone);
        GoApplePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent J = new Intent(AllPhoneCatagory.this, AllApplePhones.class);
                startActivity(J);
            }
        });

        GoSamsungPhone = (Button) findViewById(R.id.GoSamsungPhone);
        GoSamsungPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent H = new Intent(AllPhoneCatagory.this, AllSamsungPhones.class);
                startActivity(H);
            }
        });

    }
}
