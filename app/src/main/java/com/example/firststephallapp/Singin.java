package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Singin extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPass;
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