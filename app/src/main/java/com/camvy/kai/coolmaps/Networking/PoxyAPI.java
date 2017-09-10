package com.camvy.kai.coolmaps.Networking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by kai on 2017-07-21.
 */

public interface PoxyAPI {

    //This is the call for when we already have a token and need to match it with the server
    @Headers("Accept: application/json")
    @POST("/authenticate")
    Call<Badge> authenticate(@Body Badge userBadge);

    //This is the call for Registration
    @Headers("Accept: application/json")
    @POST("/users")
    Call<Cred> register(@Body Cred userCred);

    //This is the call for Login
    @Headers("Accept: application/json")
    @POST("/login")
    Call<LoginCred> login(@Body LoginCred userLoginCred);


}
