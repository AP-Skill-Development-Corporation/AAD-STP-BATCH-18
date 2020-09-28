package com.example.sharedprefrencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile,et_nkey,et_mkey;
    TextView tv;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.name);
        et_mobile = findViewById(R.id.mobile);
        et_nkey = findViewById(R.id.namekey);
        et_mkey = findViewById(R.id.mobilenokey);
        tv = findViewById(R.id.result);
        preferences = getPreferences(MODE_PRIVATE);
    }

    public void save(View view) {
        String name = et_name.getText().toString();
        String mobile = et_mobile.getText().toString();
        String nkey = et_nkey.getText().toString();
        String mkey = et_mkey.getText().toString();
        SharedPreferences.Editor editor =
                preferences.edit();
        editor.putString(nkey,name);
        editor.putString(mkey,mobile);
        editor.apply();
        Toast.makeText(this,
                "data is saved", Toast.LENGTH_SHORT).show();
    }

    public void retrive(View view) {
        String nkey = et_nkey.getText().toString();
        String mkey = et_mkey.getText().toString();
        String myname = preferences.getString(nkey,"Data not found");
        String myMobile = preferences.getString(mkey,"Data not found");
        tv.setText(myname+" "+myMobile);
    }
}