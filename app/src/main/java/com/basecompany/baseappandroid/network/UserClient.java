package com.basecompany.baseappandroid.network;

import com.basecompany.baseappandroid.network.request.LoginRequest;
import com.basecompany.baseappandroid.network.response.LoginResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserClient extends BaseClient {
    private UserService getService() {
        return getRetrofit().create(UserService.class);
    }

    public void login(String email, String password, Observer<LoginResponse> observer) {
        UserService service = getService();
        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);
        service.login(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
