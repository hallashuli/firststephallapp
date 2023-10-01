package Msubject;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import Mytask.Mytask;
@Dao
public interface Mysubjectqquery
{
    @Query("SELECT* FROM mysubject")
    List<mysubject> getAllsubjects();


    /***ادخال مجموعة من مهمات **/
    @Insert
    void insertsubject(mysubject... s); // القاط يمكن ادخال كائن او مجموعة
    /*** تعديل المهمات حسب المفتاح الرئيسي*/
    @Update
    void updatesubject(mysubject subject);
    /**** ذف مهمة او مهمات حسب المفتاح الرئيسي*/
    @Delete
    void deletsubject(mysubject... subject);
    /** */
    @Query("DELETE FROM mysubject WHERE keyid")
    void deletsubject(long Kid);
}
