package com.example.asus.studcardportabil;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface StudentService {
    @GET("getAll")
    Call<Page> getBallets();

    @POST("addBallet")
    @Headers("Content-Type: application/json")
    Call<MyResponse> addBallet(@Body HashMap<String, String> ballet);
}
