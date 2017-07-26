package com.basecompany.baseappandroid.views.presenters.impl;

import com.basecompany.baseappandroid.network.ApiErrorFactory;
import com.basecompany.baseappandroid.network.UserClient;
import com.basecompany.baseappandroid.network.response.ApiError;
import com.basecompany.baseappandroid.network.response.LoginResponse;
import com.basecompany.baseappandroid.views.presenters.LoginPresenter;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public final class LoginPresenterImpl implements LoginPresenter, Observer<LoginResponse> {
    private LoginPresenter.LoginView view;
    private UserClient client;
    private Disposable disposable;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        client = new UserClient();
    }

    public void login(String user, String password) {
        // TODO: Implement real login
        dummyLogin(user, password);
        if (true) return;
        ////////////////
        //client.login(user, password, this);
    }

    private void dummyLogin(String user, String password) {
        if (user == null || user.isEmpty()) {
            view.userError("Empty User");
            return;
        }
        if (password == null || password.isEmpty()) {
            view.passwordError("Empty Password");
            return;
        }

        view.loginSucceeded();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        if (disposable != null)
            disposable.dispose();
    }

    @Override
    public void onError(String message) {
        view.showError(message);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(@NonNull LoginResponse loginResponse) {
        view.loginSucceeded();
    }

    @Override
    public void onError(@NonNull Throwable e) {
        ApiError error = ApiErrorFactory.fromThrowable(e);
        view.showError(error.getLocalizedMessage());
    }

    @Override
    public void onComplete() {

    }
}
