package com.example.firststephallapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class AddTask extends AppCompatActivity {
    private Button btn2Save;
    private Button btn2Cancel;
    private TextView etImportance;
    private SeekBar skb;
    private TextInputLayout etShortTitle;
    private TextInputLayout etText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);
        //
        btn2Cancel=findViewById(R.id.btn2Cancel);
        btn2Save=findViewById(R.id.btn2Save);
        etImportance=findViewById(R.id.etImportance);
        skb=findViewById(R.id.skb);
        etShortTitle=findViewById(R.id.etShortTitle);
        etText=findViewById(R.id.etText);
    }



}
