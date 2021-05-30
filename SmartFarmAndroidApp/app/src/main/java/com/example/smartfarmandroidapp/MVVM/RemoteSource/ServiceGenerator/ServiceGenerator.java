package com.example.smartfarmandroidapp.MVVM.RemoteSource.ServiceGenerator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder;

    public static Retrofit.Builder getInstance(){
        if(retrofitBuilder == null)
        {
            retrofitBuilder = new Retrofit.Builder()
                    .baseUrl("https://20.67.215.100")
                    .addConverterFactory(GsonConverterFactory.create());
        }
        return retrofitBuilder;
    }
    //https://sep4api.azurewebsites.net/
}
