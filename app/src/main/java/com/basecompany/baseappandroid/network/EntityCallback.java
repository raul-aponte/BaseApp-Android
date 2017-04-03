package com.basecompany.baseappandroid.network;

import com.basecompany.baseappandroid.network.response.ApiError;

public interface EntityCallback<T> {
    void onSuccess(T entity);
    void onError(ApiError error);
}
