package com.basecompany.baseappandroid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Raul Aponte on 07/12/16.
 */
public class LoginActivity extends Activity {
    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
