package com.example.daraz.api;

import com.example.daraz.ServerResponse.SignupResponse;
import com.example.daraz.model.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {
    @POST("signup")
    Call<SignupResponse> registerUser(@Body user users);

    @FormUrlEncoded
    @POST("user/login")
    Call<SignupResponse> checkUser(@Field("phoneNo") String phoneNo, @Field("password") String password);
}

