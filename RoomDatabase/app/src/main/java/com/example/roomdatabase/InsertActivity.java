package com.example.roomdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class InsertActivity extends AppCompatActivity {

    TextInputEditText name, mailid, rollnumber, phonenumber, dateofbirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = findViewById(R.id.studentname);
        mailid = findViewById(R.id.mailid);
        rollnumber = findViewById(R.id.rollnumber);
        phonenumber = findViewById(R.id.phonenumber);
        dateofbirth = findViewById(R.id.dob);

    }

    public void save(View view) {
        String names = name.getText().toString();
        String mail = mailid.getText().toString();
        String roll = rollnumber.getText().toString();
        String phone = phonenumber.getText().toString();
        String dob = dateofbirth.getText().toString();

        Student student = new Student();
        student.setName(names);
        student.setRollNumber(roll);
        student.setPhoneNumber(phone);
        student.setDOB(dob);
        student.setMailID(mail);

        //MainActivity.dataBase.myDao().Insert(student);

        MainActivity.viewModel.Insert(student);

        finish();

    }
}