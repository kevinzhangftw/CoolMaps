package com.camvy.kai.coolmaps;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.camvy.kai.coolmaps.Networking.AuthCallback;
import com.camvy.kai.coolmaps.Networking.Badge;
import com.camvy.kai.coolmaps.Networking.PoxyServer;
import com.camvy.kai.coolmaps.Networking.UserState;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.findViewById(android.R.id.content).setBackgroundColor(Color.BLACK);
        authenticateToken();

    }

    private void authenticateToken() {
        if (!isNetworkConnected()) {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show();
        }

        //DEBUG
//        Badge newbadge = new Badge(1, "ASDASD");
//        UserState.setBadge(newbadge, this);

        Badge userBadge = UserState.getBadge(this);
        if (userBadge == null) {
            //TODO: show welcome message...
            Log.v("user state", "token is null");
            //direct to signup activity
            Intent signinIntent = new Intent(getBaseContext(), SigninActivity.class);
            startActivity(signinIntent);
        }
//        Log.v("user state", userBadge.getSession_token());

        PoxyServer.authenticate(userBadge, new AuthCallback() {
            @Override
            public void completion(boolean bool) {
                if (bool){
                    Intent parklistIntent = new Intent(getBaseContext(), ParkListActivity.class);
                    startActivity(parklistIntent);
                }else {
                    Intent signinIntent = new Intent(getBaseContext(), SigninActivity.class);
                    startActivity(signinIntent);
                }
            }
        });

    }

    private boolean isNetworkConnected() {
//        return false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
