package com.example.technomobiletest4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculation extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button add;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation);


        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        add =(Button) findViewById(R.id.calbtn);
        result=(TextView) findViewById(R.id.viewbtn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(num1.getText().toString());
                int number2 = Integer.parseInt(num2.getText().toString());
                int sum = number1+number2;
                result.setText("Total Sales " + String.valueOf(sum));
            }
        });

    }
}