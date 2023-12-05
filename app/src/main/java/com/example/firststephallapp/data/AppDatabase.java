package com.example.firststephallapp.data;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.firststephallapp.data.matasck.Mytask;
import com.example.firststephallapp.data.matasck.MytaskQuery;
import com.example.firststephallapp.data.mysubject.Mysubject;
import com.example.firststephallapp.data.myuser.MyUserQuery;
import com.example.firststephallapp.data.myuser.Myuser;
import com.example.firststephallapp.data.mysubject.MysubjectQuery;


    /*** تعريف الجداول و رقم النسخة version عند تغيير اي شيء يخص جدول او جداول علينا تغيير رقم الاصدار ليتم بناء قاعدة البيانات من جديد */
    @Database(entities = {Myuser.class, Mysubject.class, Mytask.class}, version =2)
    /*** الفئة المسؤلة عن بناء قاعدة بيانات و توفر لناكائن للتعامل مع قاعدة البيانات*/
    public  abstract  class AppDatabase extends RoomDatabase {
        /*** كائن للتعامل مع قاعدة البيانات*/
        private static AppDatabase db;
        /***يعيد كائن جدول المستعملبن*/
        public abstract MyUserQuery getMyUserQuery();
        /*** يعيد كائن لعمليات جدول المواضيع*/
        public abstract MysubjectQuery getMySubjectQuery();
        /***بناء قاعدة البيانات و اعادة كائن يؤشر عليها*/
        public abstract MytaskQuery getMyTaskQuery();
        public static AppDatabase getDB(Context context)
        {
            if (db == null)
            {
                db = Room.databaseBuilder(context,
                                AppDatabase.class, "database-name")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return db;
        }
    }
