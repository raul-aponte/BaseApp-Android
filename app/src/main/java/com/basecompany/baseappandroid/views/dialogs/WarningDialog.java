package com.basecompany.baseappandroid.views.dialogs;

import android.app.AlertDialog;
import android.content.Context;

public final class WarningDialog {
    public static void showAlert(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder
                .setMessage(message)
                .create();
        dialog.show();
    }
}
