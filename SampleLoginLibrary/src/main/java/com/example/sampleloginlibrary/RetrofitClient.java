package com.example.sampleloginlibrary;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pravallika on 24-03-2021.
 * Updated by Pravallika on 24-03-2021.
 * <p>
 * <p>
 * <p>
 * Copyright (c) 2021 MouriTech. All rights reserved.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}