package com.basecompany.baseappandroid.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.basecompany.baseappandroid.views.BaseView;
import com.basecompany.baseappandroid.views.dialogs.LoadDialog;
import com.basecompany.baseappandroid.views.dialogs.WarningDialog;

public abstract class BaseActivity extends Activity implements BaseView {
    private LoadDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new LoadDialog(this);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void showError(String message) {
        WarningDialog.showAlert(this, message);
    }
}
