package com.basecompany.baseappandroid.network;

import android.content.Context;

import com.basecompany.baseappandroid.AppController;
import com.basecompany.baseappandroid.R;
import com.basecompany.baseappandroid.network.response.ApiError;
import com.basecompany.baseappandroid.network.response.LoginResponse;

import retrofit2.Response;

public final class ApiErrorFactory {
    public static ApiError fromResponse(Response<?> response) {
        return fromResponse(response, ApiErrorType.NONE);
    }

    public static ApiError fromLoginResponse(Response<LoginResponse> response) {
        return fromResponse(response, ApiErrorType.LOGIN);
    }

    private static ApiError fromResponse(Response<?> response, ApiErrorType type) {
        int code = response.code();
        String message = null;

        switch (type) {
            case LOGIN:
                message = getLoginMessage(code);
                break;
            case SIGN_UP:
                message = getNewUserMessage(code);
                break;
        }

        if (message == null) {
            message = getConnectionMessage();
        }

        ApiError error = new ApiError();
        error.setResponseCode(code);
        error.setMessage(response.message());
        error.setLocalizedMessage(message);
        return error;
    }

    public static ApiError fromThrowable(Throwable t) {
        ApiError apiError = new ApiError();
        apiError.setMessage(t.getMessage());
        apiError.setLocalizedMessage(getConnectionMessage());
        return apiError;
    }

    private static String getLoginMessage(int code) {
        Context context = AppController.getContext();
        if (code == 401) {
            return context.getString(R.string.error_login_wrong_data);
        }
        if (code == 422) {
            return context.getString(R.string.error_login_wrong_data);
        }
        return null;
    }

    private static String getNewUserMessage(int code) {
        Context context = AppController.getContext();
        if (code == 422) {
            return context.getString(R.string.error_signin_repeatedc_mail);
        }
        return null;
    }

    private static String getConnectionMessage() {
        Context context = AppController.getContext();
        return context.getString(R.string.error_internet_connection);
    }

    private enum ApiErrorType {
        NONE, LOGIN, SIGN_UP
    }
}
