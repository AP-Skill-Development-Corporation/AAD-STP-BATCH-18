package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openUrl(View view) {
        //https://www.google.com
        Uri u = Uri.parse("https://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void makeaCall(View view) {
        //1234567890
        Uri u = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);
    }

    public void openLocation(View view) {
        //geo:latitude,longitude
        //Uri u = Uri.parse("geo:15.8284,80.1944?z=21&q=<15.8284>,<80.1944>");
        //
        Uri u = Uri.parse("geo:15.8284,80.1944?q=hospitals");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}