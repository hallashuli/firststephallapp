package com.example.firststephallapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firststephallapp.data.AppDatabase;
import com.example.firststephallapp.data.mysubject.Mysubject;
import com.example.firststephallapp.data.mysubject.MysubjectQuery;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class AddTask extends AppCompatActivity {
    private Button btn2Save;
    private Button btn2Cancel;
    private TextView etImportance;
    private SeekBar skb;
    private TextInputLayout etShortTitle;
    private TextInputLayout etText;
    private AutoCompleteTextView autoEtsubj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);
        //
        autoEtsubj=findViewById(R.id.autoEtsubj);
        initautoEtsubj();
        btn2Cancel=findViewById(R.id.btn2Cancel);
        btn2Save=findViewById(R.id.btn2Save);
        etImportance=findViewById(R.id.etImportance);
        skb=findViewById(R.id.skb);
        etShortTitle=findViewById(R.id.etShortTitle);
        etText=findViewById(R.id.etText);
    }
    private void initautoEtsubj()
    {
        //
        AppDatabase dp=AppDatabase.getDB(getApplicationContext());
        //
        MysubjectQuery mysubjectQuery=dp.getMySubjectQuery();
        //
        List<Mysubject>allSubjects=mysubjectQuery.getAllsubjects();
        //
        Arrays
    }



}
