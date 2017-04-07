package com.basecompany.baseappandroid.views.presenters.impl;

import com.basecompany.baseappandroid.models.AccessToken;
import com.basecompany.baseappandroid.network.EntityCallback;
import com.basecompany.baseappandroid.network.UserClient;
import com.basecompany.baseappandroid.network.response.ApiError;
import com.basecompany.baseappandroid.views.presenters.LoginPresenter;

public final class LoginPresenterImpl implements LoginPresenter {
    private LoginPresenter.LoginView view;
    private UserClient client;

    public LoginPresenterImpl(LoginView view, UserClient client) {
        this.view = view;
        this.client = client;
    }

    public void login(String user, String password) {
        // TODO: Implement real login
        dummyLogin(user, password);
        if(true) return;
        ////////////////

        client.login(user, password, new EntityCallback<AccessToken>() {
            @Override
            public void onSuccess(AccessToken entity) {
                view.loginSucceeded();
            }

            @Override
            public void onError(ApiError error) {
                view.showError(error.getLocalizedMessage());
            }
        });
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

    }

    @Override
    public void onError(String message) {
        view.showError(message);
    }
}
