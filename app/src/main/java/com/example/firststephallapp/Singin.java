package com.example.firststephallapp;

import androidx.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
    private void ckeckEmailPassw()
    {
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
        }//checkEmailPassw
        if (isAllok)
        {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
            //بناء قاعدة بيانات و ارجاع المؤشر عليها
            AppDatabase db=AppDatabase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات الجدول
            MyUserQuery userQuery= db.getMyUserQuery();
            //ان لم يكن موجود null استدعاء العملية التي تنفذ استعلام الذي يفحص البريد و كلمة المرور و يعيد كائنًاان كان موجود
            Myuser myuser=userQuery.checkEmailPassw(email,password);
            if (myuser==null)//هل لا يوجد كائن حسب الايميل و الباسورود
                Toast.makeText(this, "worng email or worng password", Toast.LENGTH_SHORT).show();
            else {//أن كان هنالك حساب حساب ايميل او باسورود ننتقل الى الشاشة الرئيسية
                Intent i=new Intent(Singin.this,MainActivity.class);
                startActivity(i);
                finish();
            }

        }//if(isAllok)

    }
    public void onClickSinginToSingupFireBace(View v) {
        //to open new activity from current to next activity
        Intent i = new Intent(Singin.this, Singup.class);
        startActivity(i);
    }
    public void onClickSinginToMainactivityFireBace(View v) {

        checkEmailPassw_FB();
    }
    //FireBace
    private void checkEmailPassw_FB()
    {
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
        }//checkEmailPassw_FB
        if (isAllok)
        {
            //كائن لعملية التسجيل עצם לביצוע רישום
            FirebaseAuth auth=FirebaseAuth.getInstance();
            //כניסה לחשבון בעזרת מיל ו סיסמא
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override //התגובה שמתקבל מהענן מנסיון הכניסה בענן
                public void onComplete(@NonNull Task<AuthResult> task) {//הפרמטר מכיל מידע מהרשת על תוצאת הבקשה לרישום
                   if (task.isSuccessful()){//אם הפעולה הצליחה
                       Toast.makeText(Singin.this, "Singin in Scceeded", Toast.LENGTH_SHORT).show();
                       //מעבר למסך הראשי
                       Intent i=new Intent(Singin.this,MainActivity.class);
                       startActivity(i);
                   }
                   else {
                       Toast.makeText(Singin.this, "Singin in is Failied", Toast.LENGTH_SHORT).show();
                       etEmail.setError(task.getException().getMessage());//הצגת הודעת השגיאה שהקבלה מהענן
                   }
                }
            });

        }//if(isAllok)

    }

}