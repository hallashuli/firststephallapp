package com.example.firststephallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Singin extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etPass;
    private Button btSignin;
    private Button btSingup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        //
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btSignin = findViewById(R.id.btSignin);
        btSingup = findViewById(R.id.btnSingup);
    }

    public void onClickSinginToSingup(View v) {
        //to open new activity from current to next activity
        Intent i = new Intent(Singin.this, Singup.class);
        startActivity(i);
    }

    public void onClickSinginToMainactivity(View v) {
        ckeckEmailPassw();

    }

    private void ckeckEmailPassw() {
        boolean isAllok = true; // يحوي نتيجة فحص الحقول ان كانت  السليمة
        String email = etEmail.getText().toString();
        //استخراج النص كلمة المرور
        String password=etPass.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي على @ فهو خطأ
        if (email.length()<6 || email.contains("@")==false) {
            // تعديل المتغير و يدل على انه فحص و يعطي نتيجة خاطئة
            isAllok = false;
            //عرض النتيجة خطأ في حقل الايميل
            etEmail.setError("worng email");
        }
        if (password.length()<8 || password.contains(" ")==true){
            isAllok=false;
            etPass.setError("worng password");
        }
        if (isAllok){
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
        }

    }

}