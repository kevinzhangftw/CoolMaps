package com.camvy.kai.coolmaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    private CameraPosition destinationCameraPosition;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setMapFragment();

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setMapFace(R.string.style_label_retro);
        setMapUiSettings();

        // TODO set this to current location
        LatLng origin = getCurrentLocation();
        mMap.addMarker(new MarkerOptions().position(origin).title("OG Marker"));

        //TODO customize destination, need to pull from mock object
        LatLng destination = new LatLng(49.277668,	-122.91434);
        mMap.addMarker(new MarkerOptions().position(destination).title("First Marker"));

        //set camera position
        destinationCameraPosition = new CameraPosition(destination, 15, 90, -50);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(destinationCameraPosition));


    }

    private void setMapFragment() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private void setMapUiSettings() {
        mMap.getUiSettings().setTiltGesturesEnabled(false);
        mMap.getUiSettings().setCompassEnabled(false);
//        mMap.getUiSettings().setScrollGesturesEnabled(false);
    }

    private void setMapFace(int mSelectedStyleId) {
        MapStyleOptions style;
        if (mSelectedStyleId == R.string.style_label_retro) {
            style = MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle_retro);
        }else{
            style = MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle_night);

        }
        mMap.setMapStyle(style);
    }


    public LatLng getCurrentLocation() {

//        LatLng currentLatLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        LatLng currentLatLng = new LatLng(49.278,	-122.915);
        return currentLatLng;
    }
}
