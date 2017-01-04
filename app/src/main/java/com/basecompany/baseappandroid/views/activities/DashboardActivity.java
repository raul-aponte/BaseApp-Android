package com.basecompany.baseappandroid.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Raul Aponte on 07/12/16.
 */
public class DashboardActivity extends Activity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }
}
