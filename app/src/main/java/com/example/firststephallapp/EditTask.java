package com.example.firststephallapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class EditTask extends AppCompatActivity
{
    private Button btnUpdate;
    private Button btn3Cancel;
    private EditText etImportance2;
    private SeekBar skb2;
    private TextInputLayout etShortTitle2;
    private TextInputLayout etText2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittask);
    }
}

