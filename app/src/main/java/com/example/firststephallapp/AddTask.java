package com.example.firststephallapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class AddTask extends AppCompatActivity {
    private Button btn2Save;
    private Button btn2Cancel;
    private EditText etImportance;
    private SeekBar skb;
    private TextInputLayout etShortTitle;
    private TextInputLayout etText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);
    }
}
