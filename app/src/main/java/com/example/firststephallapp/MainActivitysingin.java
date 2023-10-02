package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivitysingin extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPass;
    private Button btSignin;
    private Button btSingup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysingin);
    }
}