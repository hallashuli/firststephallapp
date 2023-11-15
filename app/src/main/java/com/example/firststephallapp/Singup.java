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

public class Singup extends AppCompatActivity
{
    private Button btnSave;
    private TextInputEditText etEmail2;
    private TextInputEditText etPassword;
    private TextInputEditText etRepassword;
    private TextInputEditText etName;
    private TextInputEditText etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        //توثيق صفات
        btnSave=findViewById(R.id.btnSave);
        etEmail2=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etName=findViewById(R.id.etName);
        etRepassword=findViewById(R.id.etRepassword);
        etPhone=findViewById(R.id.etPhone);
    }
    public void onClickSingupToMainactivity (View v)
    {
        //to open new activity from current to next activity
        Intent i= new Intent(Singup.this,  MainActivity.class);
        startActivity(i);
    }
    private void CkeckDetials () {
        boolean isAllok = true; // يحوي نتيجة فحص الحقول ان كانت  السليمة
        String email = etEmail2.getText().toString();
        //استخراج النص كلمة المرور
        String password=etPassword.getText().toString();
        //
        String name = etName.getText().toString();
        //
        String rePaswword=etRepassword.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي على @ فهو خطأ
        if (email.length()<6 || email.contains("@")==false) {
            // تعديل المتغير و يدل على انه فحص و يعطي نتيجة خاطئة
            isAllok = false;
            //عرض النتيجة خطأ في حقل الايميل
            etEmail2.setError("worng email");
        }
        //
        if (password.length()<8 || password.contains(" ")==true){
            //
            isAllok=false;
            //
            etPassword.setError("worng password");
        }

        if (isAllok)
        {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
        }


    }
}