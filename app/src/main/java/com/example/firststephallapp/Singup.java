package com.example.firststephallapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firststephallapp.data.AppDatabase;
import com.example.firststephallapp.data.myuser.MyUserQuery;
import com.example.firststephallapp.data.myuser.Myuser;
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
        CkeckDetials();
        Intent i=new Intent(Singup.this,MainActivity.class);
        startActivity(i);
        finish();
    }
    public void onClickCancelADD(View v){
        Intent i=new Intent(Singup.this,Singin.class);
        startActivity(i);
        finish();
    }
    private void CkeckDetials () {
        boolean isAllok = true; // يحوي نتيجة فحص الحقول ان كانت  السليمة
        String email = etEmail2.getText().toString();
        //استخراج النص كلمة المرور
        String password=etPassword.getText().toString();
        //استخراج نص الذي يحوي على الاسم
        String name = etName.getText().toString();
        // استخراج النص الذي يحوي على كلمة المرور الجديدة
        String rePaswword=etRepassword.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي على @ فهو خطأ
        if (email.length()<6 || email.contains("@")==false) {
            // تعديل المتغير و يدل على انه فحص و يعطي نتيجة خاطئة
            isAllok = false;
            //عرض النتيجة خطأ في حقل الايميل
            etEmail2.setError("worng email");
        }
        //فحص كلمة المرور اذا كانت اقل من 8 او تحتوي على فراغ
        if (password.length()<8 || password.contains(" ")==true){
            //تعديل المتغير على ان يعطي نتيجة خاطئة
            isAllok=false;
            //عرض نتيجة خطأ في حقل كلمة المرور
            etPassword.setError("worng password");
        }
        //فحص الاسم يجب ان لا يحتوي على اقل من 3 حروف
        if (name.length()<3){
            //تعديل المتغير على ان يعطي نتيجة خاطئة
            isAllok=false;
            //عرض نتيجة اسم خاطئ في حقل الاسم
            etName.setError("worng name");
        }
        //فحص اذا كانت كلمة المرور الجديدة نفس الكلمة القديمة(لتأكيد كبمة المرور)
        if (rePaswword.equals(password)== false) {
            //تعديل المتغير على ان يعطي نتيجة خاطئة
            isAllok=false;
            //عرض نتيجة خطأ في الحقل
            etRepassword.setError("worng password");
        }

        if (isAllok)
        {
            AppDatabase dp=AppDatabase.getDB(getApplicationContext());
            MyUserQuery MyUserQuery=dp.getMyUserQuery();
            //فحص هل البريد الالكتروني موجود من قبل
            if (MyUserQuery.checkEmail(email)!=null)
            {
                etEmail2.setError("found Email");
            }
            else //ان لم يكن البريد موجودًا نقوم ببناء كائن للمستعمل وادخاله في الجدولMyuser المستعملين
            {
                //بناء كائن
                Myuser myuser=new Myuser ();
                //تحديد القيم الصفات بالقيم التي استخرجناها
                myuser.email=email;
                myuser.fullName=name;
                myuser.passw=password;
                //اضافة كائن الجديد في الجدول
                MyUserQuery.insert(myuser);
                //اغلاق الشاشة الحالية
                finish();
            }
        }
    }
}