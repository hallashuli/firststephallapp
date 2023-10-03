package com.example.data.matasck;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Mytask
{
    @PrimaryKey(autoGenerate = true)
    /*** رقم المهمة*/
    public long koyld;
    /*** نص المهمة*/
    public String text;
    /*** رجة الاهمية*/
    public int inportance;
    /*** رقم موضوع المهمة*/
    public long subjid;
    /*** رقم المستعمل*/
    public long userid;
    /*** زمن بناء المهمة*/
    public long time;
    /**يفحص اذا انهى المهمة */
    public boolean isCompleted;
// gitter
    public  long getKoyld() {
        return koyld;
    }
    public String getText() {
        return text;
    }
    public int getInportance() {
        return inportance;
    }
    public long getSubjid() {
        return subjid;
    }
    public long getUserid() {
        return userid;
    }
    public long getTime() {
        return time;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // setter
    public void setKoyld(long koyld) {
        this.koyld = koyld;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setInportance(int inportance) {
        this.inportance = inportance;
    }
    public void setSubjid(long subjid) {
        this.subjid = subjid;
    }
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public void setTime(long time) {
        this.time = time;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Mytask{" +
                "koyld=" + koyld +
                ", text='" + text + '\'' +
                ", inportance=" + inportance +
                ", subjid=" + subjid +
                ", userid=" + userid +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
