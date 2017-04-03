package com.basecompany.baseappandroid.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basecompany.baseappandroid.R;
import com.basecompany.baseappandroid.views.dialogs.LoadDialog;
import com.basecompany.baseappandroid.views.dialogs.WarningDialog;
import com.basecompany.baseappandroid.views.presenters.LoginPresenter;
import com.basecompany.baseappandroid.views.presenters.impl.LoginPresenterImpl;

public class LoginActivity extends Activity implements View.OnClickListener, LoginPresenter.LoginView {

    // Controls
    private TextInputLayout textInputUser;
    private TextInputLayout textInputPass;
    private Button buttonLogin;

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

        presenter = new LoginPresenterImpl(this);
    }

    private void linkControls() {
        textInputUser = (TextInputLayout) findViewById(R.id.ali_til_user);
        textInputPass = (TextInputLayout) findViewById(R.id.ali_til_pass);
        buttonLogin = (Button) findViewById(R.id.ali_btn_login);
    }

    private void linkActions() {
        buttonLogin.setOnClickListener(this);
    }

    private void attemptToLogin() {
        EditText txtUser = textInputUser.getEditText();
        EditText txtPass = textInputPass.getEditText();

        if (txtUser == null || txtPass == null) return;

        presenter.login(txtUser.getText().toString(), txtPass.getText().toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ali_btn_login:
                attemptToLogin();
                break;
        }
    }

    @Override
    public void userError(String message) {
        textInputUser.setError(message);
    }

    @Override
    public void passwordError(String message) {
        textInputPass.setError(message);
    }

    @Override
    public void loginSucceeded() {
        Intent intent = DashboardActivity.newIntent(this);
        startActivity(intent);
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
        WarningDialog.showAlert(this, message);
    }
}