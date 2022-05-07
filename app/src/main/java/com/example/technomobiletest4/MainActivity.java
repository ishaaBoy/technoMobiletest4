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

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView register,forgotPassword;
    private EditText editTextemail , editTextPassword;
    private Button signIn;
    private ImageView Image;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register =(TextView) findViewById(R.id.regID);
        register.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        signIn =(Button) findViewById(R.id.SignIn);
        signIn.setOnClickListener(this);

        Image =(ImageView) findViewById(R.id.AddminLogingg) ;
        Image.setOnClickListener(this);

        forgotPassword = (TextView) findViewById(R.id.forgotPwID);
        forgotPassword.setOnClickListener(this);

        editTextemail = (EditText) findViewById(R.id.emailL);
        editTextPassword = (EditText) findViewById(R.id.passwordL);

        progressBar = (ProgressBar) findViewById(R.id.progressBarL);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regID:
                startActivity(new Intent(this,RegisterUser.class));
                break;

            case R.id.SignIn:
                userLogin();
                break;

            case R.id.AddminLogingg:
                startActivity(new Intent(this,Admin.class));
                break;

            case R.id.forgotPwID:
                startActivity(new Intent(this,ForgotPassword.class));
                break;


        }
    }

    private void userLogin() {
        String email = editTextemail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (email.isEmpty()){
            editTextemail.setError("Email is requird");
            editTextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("please enter a valid email");
            editTextemail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password is reuired");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() <6){
            editTextPassword.setError("Min password length is 6 characters!");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    // redirect to user profile
                    // redirect to home

                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }else{
                    Toast.makeText(MainActivity.this, "faild to login please check your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}