package com.basecompany.baseappandroid.views.presenters;

import com.basecompany.baseappandroid.views.BaseView;
import com.basecompany.baseappandroid.views.presenters.base.BasePresenter;

public interface LoginPresenter extends BasePresenter {

    void login(String user, String password);

    public interface LoginView extends BaseView {
        void userError(String message);
        void passwordError(String message);
        void loginSucceeded();
    }
}
