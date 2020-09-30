package com.example.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    LiveData<List<Student>> readData;
    MyRepository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        readData = repository.readData();
    }

    public void Insert(Student student){
        repository.Insert(student);
    }

    public void Delete(Student student){
        repository.Delete(student);
    }

    LiveData<List<Student>> readData(){
        return readData;
    }
}
