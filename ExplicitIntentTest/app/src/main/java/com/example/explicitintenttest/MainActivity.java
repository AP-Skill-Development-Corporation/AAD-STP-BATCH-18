package com.example.explicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.ediText);

    }

    public void next(View view) {
        String userInput = et.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("Key",userInput);
        startActivity(i);

    }
}