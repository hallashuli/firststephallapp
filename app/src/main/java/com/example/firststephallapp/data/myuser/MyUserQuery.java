package com.example.firststephallapp.data.myuser;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * الواجهة تحتوي استعلامات على قاعدة البيانات
 */

@Dao
public interface MyUserQuery
    {
                @Query("SELECT * FROM MyUser")
                List<Myuser> getAll();

                @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
                List<Myuser> loadAllByIds(int[] userIds);

                @Query("SELECT * FROM MyUser WHERE email = :myEmail AND " +
                        "passw = :myPassw LIMIT 1")
                Myuser checkEmailPassw(String myEmail, String myPassw);

                @Insert
                void insertAll(Myuser... users);

                @Delete
                void delete(Myuser user);

                @Query("Delete From Myuser WHERE keyid=:id ")
                void delete(int id);

                @Insert
                void insert(Myuser myUser);
                @Update
                void update(Myuser...values);
            }
