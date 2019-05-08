package com.example.asus.studcardportabil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    static String BASE_URL = "http://192.168.13.83:8080/LicentaServer/";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ServiceUser getUserService() {
        return retrofit.create(ServiceUser.class);
    }

    public static StudentService getCarService() { return retrofit.create(StudentService.class);}

}