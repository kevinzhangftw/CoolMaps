package com.camvy.kai.coolmaps.Networking;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.*;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by kai on 2017-07-21.
 */

public class PoxyServer {
    //testing on grok
    private static final String SERVER_URL = "http://4cd5f260.ngrok.io/";

    //private static final String SERVER_URL = "https://poxy.localtunnel.me/";

    private static Retrofit getRetrofitConnection(){
        return (new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build());
    }

    public static void authenticate(Badge userbadge, final AuthCallback authCallBack){
        PoxyAPI poxyAPI = getRetrofitConnection().create(PoxyAPI.class);
        Call<Badge> call = poxyAPI.authenticate(userbadge);

        call.enqueue(new Callback<Badge>() {
            @Override
            public void onResponse(Call<Badge> call, Response<Badge> response) {
                if (response.isSuccessful()){
                    authCallBack.completion(true);
                    Log.d("Response Success", new Gson().toJson(response.body()));
                }else {
                    authCallBack.completion(false);
                    Log.d("Response Err Code",new Gson().toJson(response));
                }
            }
            @Override
            public void onFailure(Call<Badge> call, Throwable t) {
                authCallBack.completion(false);
                Log.d("Response Err Code", "Cannot Reach Server");
            }
        });
    }

    /**
     * This is for registering users.  Ex: "PoxyServer.register".
     * @param userCred      A example of a Cred.
     * @param authCallback
     */
    public static void register(Cred userCred, final AuthCallback authCallback){
        PoxyAPI poxyAPI = getRetrofitConnection().create(PoxyAPI.class);
        Call<Cred> call = poxyAPI.register(userCred);
        call.enqueue(new Callback<Cred>() {
            @Override
            public void onResponse(Call<Cred> call, Response<Cred> response) {
                if (response.isSuccessful()){
                    //TODO Save userid and session token
                    authCallback.completion(true);
                    Log.d("Response Success", new Gson().toJson(response.body()));
                }else{
                    authCallback.completion(false);
                    Log.d("Response Err Code",new Gson().toJson(response));
                }
            }

            @Override
            public void onFailure(Call<Cred> call, Throwable t) {
                authCallback.completion(false);
                Log.d("Response Err Code", "Cannot Reach Server");
            }
        });
    }

    public static void login(LoginCred userLoginCred, final AuthCallback authCallback){
        PoxyAPI poxyAPI = getRetrofitConnection().create(PoxyAPI.class);
        Call<LoginCred> call = poxyAPI.login(userLoginCred);
        call.enqueue(new Callback<LoginCred>() {
            @Override
            public void onResponse(Call<LoginCred> call, Response<LoginCred> response) {
                if (response.isSuccessful()){
                    //TODO Save userid and session token
                    authCallback.completion(true);
                    Log.d("Response Success", new Gson().toJson(response.body()));
                }else{
                    authCallback.completion(false);
                    Log.d("Response Err Code",new Gson().toJson(response));
                }
            }

            @Override
            public void onFailure(Call<LoginCred> call, Throwable t) {
                authCallback.completion(false);
                Log.d("Response Err Code", "Cannot Reach Server");
            }
        });
    }

}
