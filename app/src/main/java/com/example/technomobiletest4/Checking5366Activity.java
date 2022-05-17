package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Checking5366Activity extends AppCompatActivity {

    EditText etBrand;
    EditText etModel;
    EditText etPrice;
    EditText etPromotionType;
    EditText etDiscountPrice;
    EditText etDescription;
    Button btnsaveDetails;

    DatabaseReference promotionDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking5366);

        etBrand = findViewById(R.id.brand_et);
        etModel = findViewById(R.id.model_et);
        etPrice = findViewById(R.id.price_et);
        etPromotionType = findViewById(R.id.promotion_type_et);
        etDiscountPrice = findViewById(R.id.discount_et);
        etDescription = findViewById(R.id.description_et);
        btnsaveDetails = findViewById(R.id.save_details);

        promotionDbRef = FirebaseDatabase.getInstance().getReference().child("Promotion");

        btnsaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPromotionData();
            }
        });

    }

    private void insertPromotionData(){
        String brand = etBrand.getText().toString();
        String model = etModel.getText().toString();
        String price = etPrice.getText().toString();
        String promotionType = etPromotionType.getText().toString();
        String dicountPrice = etDiscountPrice.getText().toString();
        String description = etDescription.getText().toString();

        ChekingD Promotion = new ChekingD(brand,model,price,promotionType,dicountPrice,description);

        promotionDbRef.push().setValue(Promotion);
        Toast.makeText(Checking5366Activity.this,"Promotion Added",Toast.LENGTH_SHORT).show();

    }

}