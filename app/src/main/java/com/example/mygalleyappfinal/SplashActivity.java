package com.example.mygalleyappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    Thread wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firebaseAuth = firebaseAuth.getInstance();
        SplashThread();
        //firebaseAuth.signOut();
        
        if (firebaseAuth.getCurrentUser() !=null){
            Toast.makeText(this, "You are already login. Redirect to main page.", Toast.LENGTH_SHORT).show();
            wait.start();
        } else {
            Toast.makeText(this, "Login or Sign up please!", Toast.LENGTH_SHORT).show();
        }
    }

    public void signupClick(View view) {
        startActivity(new Intent(SplashActivity.this, SignupActivity.class));
    }
    public void loginClick(View view) {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
    }

    public void SplashThread(){
        wait = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(2000);
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }
}