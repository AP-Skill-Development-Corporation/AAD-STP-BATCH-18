package com.example.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {

    @GET("/books/v1/volumes")
    Call<String> getJsonResponse(@Query("q") String bookname);
}
