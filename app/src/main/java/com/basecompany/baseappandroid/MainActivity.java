package com.basecompany.baseappandroid;

import android.app.Activity;
import android.os.Bundle;

import com.basecompany.baseappandroid.activities.SplashActivity;


/**
 * Created by Raul Aponte on 06/12/16.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashActivity.start(this);
    }
}
