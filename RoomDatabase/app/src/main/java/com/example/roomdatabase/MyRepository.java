package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {

    LiveData<List<Student>> readData;
    MyDataBase dataBase;

    public MyRepository(Application application) {
        dataBase = MyDataBase.getDataBase(application);
        readData = dataBase.myDao().readData();
    }

    public void Insert(Student student){
        new InsertTask().execute(student);
    }

    public void Delete(Student student){
        new Deletetask().execute(student);
    }

    LiveData<List<Student>> readData(){
        return readData;
    }

    class InsertTask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            dataBase.myDao().Insert(students[0]);
            return null;
        }
    }

    class Deletetask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            dataBase.myDao().Delete(students[0]);
            return null;
        }
    }


}
