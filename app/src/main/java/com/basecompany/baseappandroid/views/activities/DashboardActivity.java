package com.basecompany.baseappandroid.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.basecompany.baseappandroid.R;
import com.basecompany.baseappandroid.views.presenters.DashboardPresenter;

public class DashboardActivity extends Activity implements DashboardPresenter.DashboardView {

    private DashboardPresenter presenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        linkControls();
        linkActions();

        presenter = new DashboardPresenter(this);
    }

    private void linkControls() {

    }

    private void linkActions() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}