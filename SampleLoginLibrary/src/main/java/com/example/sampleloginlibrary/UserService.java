package com.example.sampleloginlibrary;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
/**
 * Created by Pravallika on 24-03-2021.
 * Updated by Pravallika on 24-03-2021.
 * <p>
 * <p>
 * <p>
 * Copyright (c) 2021 MouriTech. All rights reserved.
 */


public interface UserService {
    @GET("login/{username}/{password}")
    Call<ResObj> login(@Path("username") String username, @Path("password") String password);
}