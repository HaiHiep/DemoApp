package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView txtRegister;
    private TextView txtForgotPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        txtForgotPassword = (TextView) findViewById(R.id.txtForgot);
        db = new DatabaseHelper(this);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUserName.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                if (username.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please fill out the form!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean res = db.checkUser(username, password);
                    if (res == true) {
                        Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(homeIntent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Username or Password is incorrect. Try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Feature has not yet been processed.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
