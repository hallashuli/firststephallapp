package com.example.firststephallapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class SplashScreen  extends AppCompatActivity
{
    private Button btnGo;
    private TextView etWelcome;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splashscreen);


        }
}

