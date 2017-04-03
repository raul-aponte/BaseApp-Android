package com.basecompany.baseappandroid.network;

import com.basecompany.baseappandroid.network.request.LoginRequest;
import com.basecompany.baseappandroid.network.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    // TODO: Check endpoint
    @POST("users")
    Call<LoginResponse> login(@Body LoginRequest login);
}
