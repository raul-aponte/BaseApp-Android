package com.basecompany.baseappandroid.views.presenters;

import com.basecompany.baseappandroid.views.BaseView;
import com.basecompany.baseappandroid.views.presenters.base.BasePresenter;

/**
 * Created by Raul Aponte on 03/01/17.
 */

public class LoginPresenter implements BasePresenter {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void login(String user, String pass) {
        if (user == null || user.isEmpty()) {
            view.userError("Empty User");
            return;
        }
        if (pass == null || pass.isEmpty()) {
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

    }

    public interface LoginView extends BaseView {
        void userError(String message);
        void passwordError(String message);
        void loginSucceeded();
    }
}
