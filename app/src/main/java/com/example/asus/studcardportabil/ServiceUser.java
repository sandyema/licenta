package com.example.asus.studcardportabil;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceUser {
    @POST("login")
    @Headers("Content-Type: application/json")
    Call<MyResponse> doLogin(@Body HashMap<String, String> user);
}
