package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText et_bookame;
    TextView tv;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_bookame = findViewById(R.id.bookname);
        tv = findViewById(R.id.textview);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


    }

    public void search(View view) {
        String bookname = et_bookame.getText().toString();
        BookService service = retrofit.create(BookService.class);
        Call<String> response = service.getJsonResponse(bookname);
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data = response.body();
                Toast.makeText(MainActivity.this,
                        data, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    JSONArray itemsArray = jsonObject.getJSONArray("items");
                    JSONObject indexobjcet = itemsArray.getJSONObject(0);
                    JSONObject volumeInfoObect = indexobjcet.getJSONObject("volumeInfo");
                    String title = volumeInfoObect.getString("title");
                    String authors = volumeInfoObect.getString("authors");
                    tv.setText("Title: "+title+"\n"+"Authors: "+authors);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}