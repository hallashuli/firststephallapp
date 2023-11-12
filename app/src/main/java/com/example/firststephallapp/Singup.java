package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class Singup extends AppCompatActivity
{
    private Button btnSave;
    private TextInputLayout etEmail2;
    private TextInputLayout etPassword;
    private TextInputLayout etRepassword;
    private TextInputLayout etName;
    private TextInputLayout etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        //توثيق صفات
        btnSave=findViewById(R.id.btnSave);
        etEmail2=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etName=findViewById(R.id.etName);
        etRepassword=findViewById(R.id.etRepassword);
        etPhone=findViewById(R.id.etPhone);
    }
    public void onClickSingupToMainactivity (View v)
    {
        //to open new activity from current to next activity
        Intent i= new Intent(Singup.this,  MainActivity.class);
        startActivity(i);
    }
}