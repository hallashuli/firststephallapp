package com.example.firststephallapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firststephallapp.data.AppDatabase;
import com.example.firststephallapp.data.matasck.Mytask;
import com.example.firststephallapp.data.mysubject.Mysubject;
import com.example.firststephallapp.data.mysubject.MysubjectQuery;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class AddTask extends AppCompatActivity
{
    private Button btn2Save;
    private Button btn2Cancel;
    private TextView etImportance;
    private SeekBar skb;
    private EditText etShortTitle;
    private EditText etText;
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
    /**
     *استخراج اسماء المواضيع من جدول المواضيع وعرضه بالحقل من نوع
     *AutoCompleteTextView
     *طريقة التعامل مع شبيه "السبينير"
     */
    private void initautoEtsubj()
    {
        //مؤشر لقاعدة البيانات
        AppDatabase dp=AppDatabase.getDB(getApplicationContext());
        //مؤشر لواجهة استعمالات جدول المواضيع
        MysubjectQuery mysubjectQuery=dp.getMySubjectQuery();
        //مصدر المعطيات:استخراج جميع المعطيات \المواضيع من الجدول
        List<Mysubject>allSubjects=mysubjectQuery.getAllsubjects();
        //تجهيز الوسيط
        ArrayAdapter<Mysubject>adapter =new ArrayAdapter<Mysubject>(this, android.R.layout.simple_dropdown_item_1line);
        adapter.addAll(allSubjects);//اضافة المعلومات للوسيط
        autoEtsubj.setAdapter(adapter);//ربط الحقل بالوسيط
        //معالجة الحدث لعرض المواضيع عند الضغط على المواضيع
        autoEtsubj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoEtsubj.showDropDown();
            }
        });
    }
    public void onClicksaveTask (View v)
    {
        checkShortTitleAndText();
        //to open new activity from current to next activity
        Intent i= new Intent(AddTask.this,   MainActivity.class);
        startActivity(i);
    }
    public void onClickcanceladdtask (View v) {
        finish();
    }
    private void checkShortTitleAndText()
    {
        boolean isAllOk=true; // يحوي نتيجة فحص الحقول ان كانت سليمة
        String shortTitle=etShortTitle.getText().toString();
        String text=etText.getText().toString();
        String whichsubj=autoEtsubj.getText().toString();
        int importancee=skb.getProgress();
        if (shortTitle.length()<1)
        {
            isAllOk=false;
            etShortTitle.setError("short title is empty");
        }
        if (text.length()<1)
        {
            isAllOk=false;
            etText.setError("text is empty");
        }
        if (whichsubj.length()<1)
        {
            isAllOk=false;
            autoEtsubj.setError("you didn't chose the subject");
        }
        if (isAllOk) {
            AppDatabase dp = AppDatabase.getDB(getApplicationContext());
            MysubjectQuery mysubjectQuery = dp.getMySubjectQuery();
            if (mysubjectQuery.checkSubject(whichsubj) == null) // فحص هل الموضوع من قبل بالجدول
            {//
                //بناء موضوع جديد واضافته
                Mysubject subject = new Mysubject();
                subject.title = whichsubj;
                mysubjectQuery.insertsubject(subject);
            }
            //استخراج id الموضوع لأننا بحاجة لرقمه التسلسلي

            Mysubject subject = mysubjectQuery.checkSubject(whichsubj);
            Mytask task = new Mytask();
            task.inportance = importancee;
            task.text = text;
            task.subjid = subject.getKeyid();//تحديد رقم الموضوع للمهة
            dp.getMyTaskQuery().insertTask(task);//اضافة المهمة للجدول
            finish();
        }
}





    }
