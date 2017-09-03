package com.camvy.kai.coolmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent splashIntent = new Intent(this, SplashActivity.class);
//        startActivity(splashIntent);

        //DEBUG
        Intent splashActivity = new Intent(getBaseContext(), SplashActivity.class);
        startActivity(splashActivity);
    }
}
