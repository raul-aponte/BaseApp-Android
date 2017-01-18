package com.basecompany.baseappandroid.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basecompany.baseappandroid.R;
import com.basecompany.baseappandroid.views.dialogs.LoadDialog;
import com.basecompany.baseappandroid.views.presenters.LoginPresenter;

/**
 * Created by Raul Aponte on 07/12/16.
 */
public class LoginActivity extends Activity implements View.OnClickListener, LoginPresenter.LoginView {

    // Controls
    private EditText txtUser;
    private EditText txtPass;
    private Button btnLogin;

    private LoadDialog loadDialog;

    private LoginPresenter presenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadDialog = new LoadDialog(this);

        linkControls();
        linkActions();

        presenter = new LoginPresenter(this);
    }

    private void linkControls() {
        txtUser = (EditText) findViewById(R.id.ali_txt_user);
        txtPass = (EditText) findViewById(R.id.ali_txt_pass);
        btnLogin = (Button) findViewById(R.id.ali_btn_login);
    }

    private void linkActions() {
        btnLogin.setOnClickListener(this);
    }

    private void attemptToLogin() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ali_btn_login:
                attemptToLogin();
                break;
        }
    }

    @Override
    public void userError(String message) {

    }

    @Override
    public void passwordError(String message) {

    }

    @Override
    public void loginSucceeded() {

    }

    @Override
    public void showProgress() {
        loadDialog.show();
    }

    @Override
    public void hideProgress() {
        loadDialog.dismiss();
    }

    @Override
    public void showError(String message) {

    }
}
