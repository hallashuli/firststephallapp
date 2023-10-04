package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.firststephallapp.data.AppDataBase;
import com.example.firststephallapp.data.AppDatabase;
import com.example.firststephallapp.data.mysubject.Mysubject;
import com.example.firststephallapp.data.mysubject.MysubjectQuery;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HL","onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        //ناء قاعدة بيانات و ارجاع مؤشر عليها
        AppDatabase db=AppDatabase.getDB(getApplicationContext();
        //مؤشر للجدول
        MysubjectQuery mysubjectQuery=db.getMySubjectQuery();
        Mysubject s1=new Mysubject();
        s1.setTitle("Math");
        Mysubject s2=new Mysubject();
        s2.title="computer";
        mysubjectQuery.insertsubject(s1);
        mysubjectQuery.insertsubject(s2);
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("HL","onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("HL","onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("HL","onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("HL","onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("HL","onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
}
