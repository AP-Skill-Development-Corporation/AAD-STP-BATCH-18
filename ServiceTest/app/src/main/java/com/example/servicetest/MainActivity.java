package com.example.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
        Intent i = new Intent(this,MyService.class);
        startService(i);
        Log.i("MASTAN","play button is clicked");
    }

    public void stop(View view) {
        Intent i = new Intent(this,MyService.class);
        stopService(i);
    }
}