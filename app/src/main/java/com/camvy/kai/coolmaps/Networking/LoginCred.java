package com.camvy.kai.coolmaps.Networking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kai on 20 17-07-30.
 *
 * This is for logging users into the server.
 */

public class LoginCred {
    @SerializedName("email") private String email;
    @SerializedName("password") private String password;

    public LoginCred(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
