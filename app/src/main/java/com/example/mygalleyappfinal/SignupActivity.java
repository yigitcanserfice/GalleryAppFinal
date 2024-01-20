package com.example.mygalleyappfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mygalleyappfinal.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    Button signup;
    EditText fname, lname, email, pass;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = findViewById(R.id.btnSignUp);
        fname = findViewById(R.id.edtFirstName);
        lname = findViewById(R.id.edtLastName);
        email = findViewById(R.id.edtEmail);
        pass = findViewById(R.id.edtPassword);
        firebaseAuth = firebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupUser();
            }
        });

    }

    private void signupUser() {
        String userFirstName = fname.getText().toString();
        String userLastName = lname.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = pass.getText().toString();

        if (userFirstName.isEmpty()){
            Toast.makeText(this, "You should enter a First Name!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userLastName.isEmpty()) {
            Toast.makeText(this, "You should enter a Last Name!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userEmail.isEmpty()) {
            Toast.makeText(this, "You should enter an Email!", Toast.LENGTH_SHORT).show();
            return;
        } else if (userPassword.isEmpty() || userPassword.length() < 6) {
            Toast.makeText(this, "You should enter at least a six-digits Password!", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    String uid = task.getResult().getUser().getUid();
                    Toast.makeText(SignupActivity.this, "Sign up Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                    //firebas'e veri ekleme
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    CollectionReference ref = db.collection("UserModel");
                    UserModel user = new UserModel(userFirstName, userLastName, userEmail, uid );
                    ref.add(user);
                }else {
                    Toast.makeText(SignupActivity.this, "Sign up Failed!", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

    }

    public void loginClick(View view) {
        startActivity(new Intent(SignupActivity.this, LoginActivity.class));
    }
}