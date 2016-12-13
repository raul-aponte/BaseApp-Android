package com.basecompany.baseappandroid;

import android.app.Application;
import android.content.Context;

/**
 * Created by Raul Aponte on 07/12/16.
 */
public class AppController extends Application {
    private static AppController instance;

    public AppController() {
        instance = this;
    }

    /**
     * Never use this method for UI Context
     */
    public static Context getContext() {
        return instance;
    }
}
