package com.basecompany.baseappandroid.network;

import com.basecompany.baseappandroid.BuildConfig;
import com.basecompany.baseappandroid.models.AccessToken;
import com.basecompany.baseappandroid.network.request.LoginRequest;
import com.basecompany.baseappandroid.network.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserClient {
    public void login(String email, String password, final EntityCallback<AccessToken> callback){
        UserService service = getService();
        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);
        Call<LoginResponse> call = service.login(request);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().getToken());
                } else {
                    callback.onError(ApiErrorFactory.fromLoginResponse(response));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onError(ApiErrorFactory.fromThrowable(t));
            }
        });
    }

    private UserService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(UserService.class);
    }
}
