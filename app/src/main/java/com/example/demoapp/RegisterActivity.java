package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtUserName;
    private EditText txtPassword;
    private EditText txtConfirmPassword;
    private Button btnRegister;
    private Button btnCancel;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUserName = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        db = new DatabaseHelper(this);

        btnCancel.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel:
                Intent cancelIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(cancelIntent);
                break;
            case R.id.btnRegister:
                String username = txtUserName.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmpass = txtConfirmPassword.getText().toString().trim();
                if (username.equals("") || password.equals("") || confirmpass.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please fill out the form!", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirmpass)) {
                        Boolean user = db.checkUser(username, password);
                        if (user) {
                            Toast.makeText(RegisterActivity.this, "User existed! Please register with another account!", Toast.LENGTH_SHORT).show();
                        } else {
                            Long res = db.addUser(username, password);
                            if (res > 0) {
                                Toast.makeText(RegisterActivity.this, "Register Success!", Toast.LENGTH_SHORT).show();
                                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(loginIntent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Register Error! Try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password not matching. Try again!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                break;
        }
    }
}
