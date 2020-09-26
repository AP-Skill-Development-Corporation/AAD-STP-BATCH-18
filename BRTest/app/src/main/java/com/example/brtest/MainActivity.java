package com.example.brtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String MY_CUSTOM_BR = "com.example.brtest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyReceiver receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(MY_CUSTOM_BR);
        registerReceiver(receiver,filter);

    }

    public void sendCustomBr(View view) {
        Intent i = new Intent(MY_CUSTOM_BR);
        sendBroadcast(i);

    }
}