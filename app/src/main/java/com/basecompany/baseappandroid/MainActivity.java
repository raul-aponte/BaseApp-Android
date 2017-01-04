package com.basecompany.baseappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.basecompany.baseappandroid.views.activities.SplashActivity;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = SplashActivity.newIntent(this);
        startActivity(intent);
    }
}
