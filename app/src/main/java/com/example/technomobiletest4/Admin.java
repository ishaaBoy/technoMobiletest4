package com.example.technomobiletest4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin extends AppCompatActivity  implements View.OnClickListener{

    private TextView Aregister;
    private EditText AeditTextemail , AeditTextPassword;
    private Button AsignIn;
    private ImageView AImage;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Aregister =(TextView) findViewById(R.id.regID);
        Aregister.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        AsignIn =(Button) findViewById(R.id.SignIn);
        AsignIn.setOnClickListener(this);



        AeditTextemail = (EditText) findViewById(R.id.emailL);
        AeditTextPassword = (EditText) findViewById(R.id.passwordL);

        progressBar = (ProgressBar) findViewById(R.id.progressBarL);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regID:
                startActivity(new Intent(this,AdminRegister.class));
                break;

            case R.id.SignIn:
                userLogin();
                break;

        }
    }

    private void userLogin() {
        String email = AeditTextemail.getText().toString();
        String password = AeditTextPassword.getText().toString();

        if (email.isEmpty()){
            AeditTextemail.setError("Email is requird");
            AeditTextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            AeditTextemail.setError("please enter a valid email");
            AeditTextemail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            AeditTextPassword.setError("Password is reuired");
            AeditTextPassword.requestFocus();
            return;
        }

        if (password.length() <6){
            AeditTextPassword.setError("Min password length is 6 characters!");
            AeditTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    // redirect to user profile

                    startActivity(new Intent(Admin.this,AdminProfile.class));
                }else{
                    Toast.makeText(Admin.this, "faild to login please check your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}