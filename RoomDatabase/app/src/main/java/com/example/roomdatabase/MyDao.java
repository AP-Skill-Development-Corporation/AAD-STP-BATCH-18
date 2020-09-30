package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    /*Insert Query*/
    @Insert
    public void Insert(Student student);

    /*Read Data*/
    @Query("SELECT * FROM STUDENTINFO")
    LiveData<List<Student>> readData();

    /*Update Query*/
    @Update
    public void Update(Student student);

    /*Delete Query*/
    @Delete
    public void Delete(Student student);

}
