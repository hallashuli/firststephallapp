package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.firststephallapp.data.AppDatabase;
import com.example.firststephallapp.data.mysubject.Mysubject;
import com.example.firststephallapp.data.mysubject.MysubjectQuery;

import java.util.List;

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
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        //مؤشر للجدول
        MysubjectQuery mysubjectQuery=db.getMySubjectQuery();
        //بناء كائن من نوع الجدول و تحديد قيم الصفات
        Mysubject s1=new Mysubject();
        s1.setTitle("Math");
        Mysubject s2=new Mysubject();
        s2.title="computer";
        //اضافة كائن للجدول
        mysubjectQuery.insertsubject(s1);
        mysubjectQuery.insertsubject(s2);
        //قحص هل تم حفظ ما سبق
        // استخراج و طباعة جميع معطيات الجدول المواضيع
        List<Mysubject> allsubjects = mysubjectQuery.getAllsubjects();
        for (Mysubject s:allsubjects)
             {
                 Log.d("halla",s.title);
                 Toast.makeText(this, s.title, Toast.LENGTH_SHORT).show();
        }

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
