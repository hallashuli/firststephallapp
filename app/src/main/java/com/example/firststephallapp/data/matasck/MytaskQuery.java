package com.example.firststephallapp.data.matasck;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao // واجهة استعلامات على جدول المعطيات
public interface MytaskQuery {
    /***اعادة جميع معطيات الجدول**/
    @Query("SELECT* FROM Mytask")
    List<Mytask> getAllTasks();
    /*** استخراج المهمات حسب المستعمل**/
    @Query("SELECT * From Mytask WHERE userid=:userid_p AND isCompleted=:iscompleted_p "
            + "ORDER BY inportance DESC")
    List<Mytask> getAllTaskOrederBy(long userid_p, boolean iscompleted_p);
    /***ادخال مجموعة من مهمات **/
    @Insert
    void insertTask(Mytask... t); // القاط يمكن ادخال كائن او مجموعة
    /*** تعديل المهمات حسب المفتاح الرئيسي*/
    @Update
    void updateTask(Mytask task);
    /**** ذف مهمة او مهمات حسب المفتاح الرئيسي*/
    @Delete
    void deletTask(Mytask... task);
    @Query("DELETE FROM mytask WHERE koyld=:Kid")
    void deletTask(long Kid);
    @Query("SELECT * FROM Mytask WHERE subjid=:subj_id "+
            "ORDER BY inportance DESC")
    List<Mytask> getTasksBySubjid(long subj_id);

}
