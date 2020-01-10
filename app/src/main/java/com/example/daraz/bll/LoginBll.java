package com.example.daraz.bll;

import com.example.daraz.ServerResponse.SignupResponse;
import com.example.daraz.Url.Url;
import com.example.daraz.api.UserApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<SignupResponse> usersCall = usersAPI.checkUser(username, password);

        try {
            Response<SignupResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful()) {

                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
