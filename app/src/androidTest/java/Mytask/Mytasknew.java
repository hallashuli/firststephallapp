package Mytask;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao // واجهة استعلامات على جدول المعطيات
public interface Mytasknew
{
    @Query("SELECT* FROM Mytask")
    List<Mytask> getAllTasks();
    @Insert
    void insertTask(Mytask...t); // القاط يمكن ادخال كائن او مجموعة

}
