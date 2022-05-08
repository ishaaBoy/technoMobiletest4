package com.example.technomobiletest4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddPostActivity extends AppCompatActivity {

    EditText brand,pmodel,storage,price,mpurl;
    Button btnPostItem,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        brand = (EditText) findViewById(R.id.txtBrand);
        pmodel = (EditText) findViewById(R.id.txtPmodel);
        storage = (EditText) findViewById(R.id.txtStorage);
        price = (EditText) findViewById(R.id.txtPrice);
        mpurl = (EditText) findViewById(R.id.txtImageURL);

        btnPostItem = (Button) findViewById(R.id.btnPostItem);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnPostItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("brand",brand.getText().toString());
        map.put("pmodel",pmodel.getText().toString());
        map.put("storage",storage.getText().toString());
        map.put("price",price.getText().toString());
        map.put("mpurl",mpurl.getText().toString());

        String txtPrice=price.getText().toString().trim();
        String txtBrand=brand.getText().toString().trim();



        if(txtPrice.isEmpty()){

            price.setError("Price is required!");
            price.requestFocus();
            return;
        }

        if(txtBrand.isEmpty()){

            brand.setError("Brand field couldnt be empty!");
            brand.requestFocus();
            return;
        }



        FirebaseDatabase.getInstance().getReference().child("mobile phones").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddPostActivity.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddPostActivity.this, "Error while Insertion.", Toast.LENGTH_SHORT).show();
                    }
                });

    }




    private void clearAll()
    {
        brand.setText("");
        pmodel.setText("");
        storage.setText("");
        price.setText("");
        mpurl.setText("");
    }
}