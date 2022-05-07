package com.example.technomobiletest4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class AdminRegister extends AppCompatActivity implements View.OnClickListener{

    private TextView Abanner,AregisterUser;
    private EditText AeditTextName ,AeditTextAge, AeditTextEmail,AeditTextPassword;
    private ProgressBar AprogressBar;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);


        mAuth = FirebaseAuth.getInstance();


        Abanner =(TextView) findViewById(R.id.banner);
        Abanner.setOnClickListener(this);

        AregisterUser =(Button) findViewById(R.id.registerUser);
        AregisterUser.setOnClickListener(this);

        AeditTextName =(EditText) findViewById(R.id.name);
        AeditTextAge =(EditText) findViewById(R.id.age);
        AeditTextEmail =(EditText) findViewById(R.id.email);
        AeditTextPassword =(EditText) findViewById(R.id.password);

        AprogressBar = (ProgressBar) findViewById(R.id.progressBarR);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.banner:
                startActivity(new Intent(this,MainActivity.class));
                break;

            case R.id.registerUser:
                registerAdminUser();
                break;


        }

    }



    private void registerAdminUser() {

        String email=AeditTextEmail.getText().toString().trim();
        String password=AeditTextPassword.getText().toString().trim();
        String name=AeditTextName.getText().toString().trim();
        String age=AeditTextAge.getText().toString().trim();

        if(age.isEmpty()){

            AeditTextAge.setError("Age is required!");
            AeditTextAge.requestFocus();
            return;
        }
        if(email.isEmpty()){

            AeditTextEmail.setError("Email is required!");
            AeditTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){

            AeditTextPassword.setError("Password is required!");
            AeditTextPassword.requestFocus();
            return;
        }

        if(name.isEmpty()){

            AeditTextName.setError("Name is required!");
            AeditTextName.requestFocus();
            return;
        }

        if(password.length()<6){
            AeditTextPassword.setError("Min password length should be six characters!");
            AeditTextPassword.requestFocus();
            return;
        }

        AprogressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(name,age,email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){

                                        Toast.makeText(AdminRegister.this, "Admin has been registerd successfully", Toast.LENGTH_SHORT).show();
                                        AprogressBar.setVisibility(View.GONE);

                                        //redirecting to login layout !
                                    }else {
                                        Toast.makeText(AdminRegister.this, "Faild to register try again", Toast.LENGTH_SHORT).show();
                                        AprogressBar.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }else {
                            Toast.makeText(AdminRegister.this, "Faild to register", Toast.LENGTH_SHORT).show();
                            AprogressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}