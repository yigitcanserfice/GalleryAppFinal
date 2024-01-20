package com.example.mygalleyappfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText email, pass;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btnLogin);
        email = findViewById(R.id.edtEmailLogin);
        pass = findViewById(R.id.edtPasswordLogin);

        firebaseAuth = firebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }

    private void loginUser() {
        String userEmail = email.getText().toString();
        String userPassword = pass.getText().toString();

        if (userEmail.isEmpty()) {
            Toast.makeText(this, "You should enter valid Email!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userPassword.isEmpty() || userPassword.length() < 6) {
            Toast.makeText(this, "You should enter a valid Password!", Toast.LENGTH_SHORT).show();
            return;
        }
        
        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }

    public void signupClick(View view) {
        startActivity(new Intent(LoginActivity.this, SignupActivity.class));
    }
}