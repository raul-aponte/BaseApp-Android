package com.basecompany.baseappandroid.views.presenters;

import com.basecompany.baseappandroid.views.BaseView;

/**
 * Created by Raul Aponte on 03/01/17.
 */

public class LoginPresenter {
    public LoginPresenter(LoginView view) {
        
    }

    public interface LoginView extends BaseView {
        void userError(String message);
        void passwordError(String message);
        void loginSucceeded();
    }
}
