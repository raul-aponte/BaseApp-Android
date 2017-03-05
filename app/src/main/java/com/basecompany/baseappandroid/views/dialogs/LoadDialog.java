package com.basecompany.baseappandroid.views.dialogs;

import android.app.ProgressDialog;
import android.content.Context;

import com.basecompany.baseappandroid.R;

public class LoadDialog extends ProgressDialog {
    public LoadDialog(Context context) {
        super(context);
        setIndeterminate(true);
        setCancelable(false);
        setTitle(R.string.loading);
    }
}