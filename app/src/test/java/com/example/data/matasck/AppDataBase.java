package com.example.data.matasck;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public class AppDataBase
{
    @Database(entities = {Myuser.class,mysubject.class, Mytask.class},version = 5)
    public abstract class AppDatabase extends RoomDatabase
    {
        private static AppDatabase db;
        public abstract MyUserQuery getMyUserQuery();
        public abstract Mysub getMySubjectQuery();
        public abstract MyTaskQuery getMyTaskQuery();

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
