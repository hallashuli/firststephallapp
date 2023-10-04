package com.example.data.mysubject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Mysubject
{
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    public String title;
    public long getKeyid()
    {
        return keyid;
    }
    public void setKeyid(long keyid)
    {
        this.keyid = keyid;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    @Override
    public String toString()
    {
        return "mysubject{" +
                "keyid=" + keyid +
                ", title='" + title + '\'' +
                '}';
    }

}
