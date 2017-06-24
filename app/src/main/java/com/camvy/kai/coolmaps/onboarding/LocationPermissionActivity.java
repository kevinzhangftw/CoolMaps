package com.camvy.kai.coolmaps.onboarding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.camvy.kai.coolmaps.R;

public class LocationPermissionActivity extends AppCompatActivity {

    private PermissionManager permissionMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_permission);
        permissionMan = new PermissionManager(this);

        //TODO: set this in onclicklistener
        permissionMan.getLocationPermission();
    }
}
