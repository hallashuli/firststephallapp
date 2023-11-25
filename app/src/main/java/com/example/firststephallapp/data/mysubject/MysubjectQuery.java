package com.example.firststephallapp.data.mysubject;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface MysubjectQuery
{
    @Query("SELECT* FROM mysubject")
    List<Mysubject> getAllsubjects();


    /***ادخال مجموعة من مهمات **/
    @Insert
    void insertsubject(Mysubject... s); // القاط يمكن ادخال كائن او مجموعة
    /*** تعديل المهمات حسب المفتاح الرئيسي*/
    @Update
    void updatesubject(Mysubject subject);
    /**** ذف مهمة او مهمات حسب المفتاح الرئيسي*/
    @Delete
    void deletsubject(Mysubject... subject);
    /** */
    @Query("DELETE FROM mysubject WHERE keyid=:Kid")
    void deletsubject(long Kid);
    /***/
    @Query("SELECT * FROM Mysubject WHERE title = :whsubject")
    Mysubject checkSubject(String whsubject);

}
