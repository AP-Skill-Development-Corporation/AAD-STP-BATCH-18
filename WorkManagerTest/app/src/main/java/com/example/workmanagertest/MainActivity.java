package com.example.workmanagertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    OneTimeWorkRequest firstWork;
    OneTimeWorkRequest secondWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstWork = new OneTimeWorkRequest.Builder(FirstWork.class).build();
        secondWork = new OneTimeWorkRequest.Builder(SecondWork.class).build();
    }

    public void doWork(View view) {
        WorkManager.getInstance(this)
                .beginWith(secondWork).then(firstWork).enqueue();


    }
}