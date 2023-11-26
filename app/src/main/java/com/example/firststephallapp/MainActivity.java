package com.example.firststephallapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.firststephallapp.data.AppDatabase;
import com.example.firststephallapp.data.matasck.Mytask;
import com.example.firststephallapp.data.matasck.MytaskQuery;
import com.example.firststephallapp.data.mysubject.Mysubject;
import com.example.firststephallapp.data.mysubject.MysubjectQuery;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    //spnr1 تعريف صفه للكائن المرئي
    private Spinner spnrSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spnr2 وضع مؤشر الصفه على الكائن المرئي الموجود بواجهه المستعمل
        spnrSubject = findViewById(R.id.spnrSubject);
        //spnr3 بناء الوسيط وتحديد واجهه تنسيق لمعطى واحد
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data sourceمصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String[] ar = {"Math", "CS", "Phs", "Arb", "Eng"};
        //spnr5تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr6ربط الكائن المرئي بالوسيط
        spnrSubject.setAdapter(adapter);
        Log.d("HL", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        //ناء قاعدة بيانات و ارجاع مؤشر عليها
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        //مؤشر للجدول
        MysubjectQuery mysubjectQuery = db.getMySubjectQuery();
        //بناء كائن من نوع الجدول و تحديد قيم الصفات
        Mysubject s1 = new Mysubject();
        s1.setTitle("Math");
        Mysubject s2 = new Mysubject();
        s2.title = "computer";
        //اضافة كائن للجدول
        mysubjectQuery.insertsubject(s1);
        mysubjectQuery.insertsubject(s2);
        //قحص هل تم حفظ ما سبق
        // استخراج و طباعة جميع معطيات الجدول المواضيع
        List<Mysubject> allsubjects = mysubjectQuery.getAllsubjects();
        for (Mysubject s : allsubjects) {
            Log.d("halla", s.title);
            Toast.makeText(this, s.title, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("HL", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HL", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HL", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HL", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HL", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    /**
     *عملية تجهيز السبينير في المواضيع
     */
    private void initSubjectSpnr()
    {
        AppDatabase dp=AppDatabase.getDB(getApplicationContext());//قاعدة بناء
        MysubjectQuery mysubjectQuery=dp.getMySubjectQuery();//عمليات جدول المواضيع
        List<Mysubject> allSubject=mysubjectQuery.getAllsubjects();//استخراج المواضيع
        //تجهيز الوسيط
        ArrayAdapter<String> subjectAddapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);//
        subjectAddapter.add("All");//ستظهر اولًا بالسبنر تعني عرض جميع المهمات
        for (Mysubject mysubject:allSubject){
            subjectAddapter.add(mysubject.title);
        }
        spnrSubject.setAdapter(subjectAddapter);//ربط السبينر في الوسيط
    }
    /** */
    private void initAllListView()
    {
        AppDatabase dp=AppDatabase.getDB(getApplicationContext());
        MytaskQuery mytaskQuery=dp.getMyTaskQuery();
        List<Mytask> allTasks=mytaskQuery.getAllTasks();
        ArrayAdapter<Mytask> mytaskArrayAdapter=new ArrayAdapter<Mytask>(this,android.R.layout.simple_dropdown_item_1line);


    }
}
