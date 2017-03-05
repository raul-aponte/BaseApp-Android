package com.basecompany.baseappandroid.views.presenters.impl;

import com.basecompany.baseappandroid.views.presenters.LoginPresenter;

public final class LoginPresenterImpl implements LoginPresenter {
    private LoginPresenter.LoginView view;

    public LoginPresenterImpl(LoginPresenter.LoginView view) {
        this.view = view;
    }

    public void login(String user, String password) {
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
