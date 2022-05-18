package com.example.technomobiletest4;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddReview extends AppCompatActivity {

    Button button;
    EditText review,rating;
    DatabaseReference Dbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        button =findViewById(R.id.SubmitBid);
        review =findViewById(R.id.enterreview);


       Dbref = FirebaseDatabase.getInstance().getReference().child("Reviews");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(review.getText().toString())){
                    review.setError("Review is Compulsory");
                    return;
                }

                sendReview();


            }
        });




    }

    private void sendReview(){

        String str_topic=review.getText().toString();
//        String str_Description=aDescription.getText().toString();

        Review review= new Review(str_topic);



        FirebaseDatabase.getInstance().getReference().child("Reviews").setValue(review)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {


                        Toast.makeText(AddReview.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddReview.this, UpdateReview.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(AddReview.this, "Added Failed", Toast.LENGTH_SHORT).show();


                    }
                });



    }

}