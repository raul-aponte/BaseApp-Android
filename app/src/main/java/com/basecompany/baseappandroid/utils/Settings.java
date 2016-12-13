package com.basecompany.baseappandroid.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.basecompany.baseappandroid.AppController;
import com.basecompany.baseappandroid.entities.AccessToken;
import com.google.gson.Gson;

/**
 * Created by Raul Aponte on 07/12/16.
 */
public class Settings {
    private static final String KEY_TOKEN = "key_token";

    public static AccessToken getToken() {
        String json = sharedPreferences().getString(KEY_TOKEN, "");
        if (json.isEmpty())
            return null;
        return new Gson().fromJson(json, AccessToken.class);
    }
    public static void setToken(AccessToken token){
        String json;
        if (token == null)
            json = "";
        else
            json = new Gson().toJson(token);
        saveString(KEY_TOKEN, json);
    }

    @SuppressLint("CommitPrefEdits")
    private static void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    private static SharedPreferences sharedPreferences() {
        Context context = AppController.getContext();
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
