package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main2singup2Activity extends AppCompatActivity
{
    private Button btnSave;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etRepassword;
    private EditText etName;
    private EditText etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2singup2);
    }
}