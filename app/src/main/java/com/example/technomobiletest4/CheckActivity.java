package com.example.technomobiletest4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CheckActivity extends AppCompatActivity {


    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView NameTextView = (TextView) findViewById(R.id.nameCheck);
        final TextView emailTextView = (TextView) findViewById(R.id.emailCheck);
        final TextView ageTextView = (TextView) findViewById(R.id.ageCheck);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);


                if (userProfile != null){

                    String Name = userProfile.name;
                    String email = userProfile.email;
                    String age = userProfile.age;

                    NameTextView.setText(Name);
                    emailTextView.setText(email);
                    ageTextView.setText(age);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {


                Toast.makeText(CheckActivity.this,"Somthing wrong happend!",Toast.LENGTH_LONG);
            }



            });
}
}