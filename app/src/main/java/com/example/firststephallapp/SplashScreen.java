package com.example.firststephallapp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class SplashScreen  extends AppCompatActivity
{

    private TextView etWelcome;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splashscreen);
            //توثيق صفات
            etWelcome=findViewById(R.id.etWelcome);
            //
            Handler h = new Handler();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    //to open new activity from current to next
                    Intent i = new Intent(SplashScreen.this, Singin.class);
                    startActivity(i);
                    //to close current activity
                    finish();
                }
            };
            h.postDelayed(r, 3000);
        }
}


