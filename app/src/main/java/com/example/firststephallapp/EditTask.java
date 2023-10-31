package com.example.firststephallapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
public class EditTask extends AppCompatActivity
{
    private Button btnUpdate;
    private Button btn3Cancel;
    private TextView etImportance2;
    private SeekBar skb2;
    private TextInputLayout etShortTitle2;
    private TextInputLayout etText2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittask);
        //
        btnUpdate=findViewById(R.id.btnUpdate);
        btn3Cancel=findViewById(R.id.btn3Cancel);
        etImportance2=findViewById(R.id.etImportance);
        skb2=findViewById(R.id.skb);
        etShortTitle2=findViewById(R.id.etShortTitle2);
        etText2=findViewById(R.id.etText2);

    }
}

