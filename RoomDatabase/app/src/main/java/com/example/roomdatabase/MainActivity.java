package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static MyDataBase dataBase;
    RecyclerView rv;
    List<Student> students;

    static MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);

        findViewById(R.id.adduser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
            }
        });

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        /*dataBase = Room.databaseBuilder(this,MyDataBase.class,"MyDB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();*/

        //students = dataBase.myDao().readData();

        viewModel.readData().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(new MyDataAdapter(MainActivity.this, students));
            }
        });

    }
}