package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addpramotion5366Activity extends AppCompatActivity {
    EditText proname;
    EditText proabout;
    EditText protype;
    Button btninsertOffer;

    DatabaseReference offerDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpramotion5366);

        proname = findViewById(R.id.txtBrand1);
        proabout = findViewById(R.id.txtBrand3);
        protype = findViewById(R.id.txtBrand5);
        btninsertOffer = findViewById(R.id.save_btn2);

        offerDbRef = FirebaseDatabase.getInstance().getReference().child("Promotion");

        btninsertOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertOfferData();
            }
        });

    }

    private void insertOfferData() {
        String name = proname.getText().toString();
        String about = proabout.getText().toString();
        String type = protype.getText().toString();

        if (name.isEmpty()){
            proname.setError("Promotion  Name is required");
            proname.requestFocus();
            return;
        }
        if (about.isEmpty()){
            proabout.setError("Promotion value is required");
            proabout.requestFocus();
            return;
        }
        if (type.isEmpty()){
            protype.setError("Promotion Type is required");
            protype.requestFocus();
            return;
        }

        Promotion promotion = new Promotion(name,about,type);

        offerDbRef.push().setValue(promotion);
        Toast.makeText(Addpramotion5366Activity.this,"Promotion Added",Toast.LENGTH_SHORT).show();
    }
}