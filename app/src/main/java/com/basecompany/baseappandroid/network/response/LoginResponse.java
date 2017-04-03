package com.basecompany.baseappandroid.network.response;

import com.basecompany.baseappandroid.models.AccessToken;

public class LoginResponse {
    private AccessToken token;

    public AccessToken getToken() {
        return token;
    }

    public void setToken(AccessToken token) {
        this.token = token;
    }
}
