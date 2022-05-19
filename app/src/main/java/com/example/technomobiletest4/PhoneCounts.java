package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneCounts extends AppCompatActivity {

     private EditText samsung;
     private EditText xiomi;
     private EditText nokia;
     private EditText apple;

      private Button add;
      private TextView all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_counts);


        samsung=findViewById(R.id.c1);
        xiomi =findViewById(R.id.c2);
        nokia =findViewById(R.id.c3);
        apple =findViewById(R.id.c4);

        add = findViewById(R.id.BC);
        all = findViewById(R.id.BV);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int p1 = Integer.parseInt(samsung.getText().toString());
                int p2 = Integer.parseInt(xiomi.getText().toString());
                int p3 = Integer.parseInt(nokia.getText().toString());
                int p4 = Integer.parseInt(apple.getText().toString());


                int sum = p1+p2+p3+p4;

                all.setText("Stock :" + String.valueOf(sum) );










            }
        });





    }
}