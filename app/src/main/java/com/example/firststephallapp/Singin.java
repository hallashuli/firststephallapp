package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class Singin extends AppCompatActivity {
    private TextInputLayout etEmail;
    private TextInputLayout etPass;
    private Button btSignin;
    private Button btSingup;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        //
        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPass);
        btSignin=findViewById(R.id.btSignin);
        btSingup=findViewById(R.id.btnSingup);
    }
}