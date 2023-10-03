package com.example.data;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.data.matasck.Mytask;
import com.example.data.matasck.Mytasknew;
import com.example.data.myuser.MyUserQuery;
import com.example.data.myuser.Myuser;
import com.example.data.mysubject.Mysubjectqquery;

public class AppDataBase
{
    @Database(entities = {Myuser.class, my.class, Mytask.class},version = 5)
    public abstract class AppDatabase extends RoomDatabase
    {
        private static AppDatabase db;
        public abstract MyUserQuery getMyUserQuery();
        public abstract Mysubjectqquery getMySubjectQuery();
        public abstract Mytasknew getMyTaskQuery();

        public static AppDatabase getDB(Context context)
        {
            if(db==null)
            {
                db = Room.databaseBuilder(context,
                                AppDatabase.class, "database-name")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }


        }
