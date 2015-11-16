package com.example.usuario.uvgmovil;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity {


    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        setUpMapIfNeeded(14.604049, -90.492778, "Parqueo 1",BitmapDescriptorFactory.HUE_RED);
        setUpMapIfNeeded(14.604976, -90.488008, "Puerta 8",BitmapDescriptorFactory.HUE_GREEN);
        setUpMapIfNeeded(14.605321, -90.487757, "Parqueo 9",BitmapDescriptorFactory.HUE_RED);
        CameraUpdate mCamera = CameraUpdateFactory.newLatLngZoom(new LatLng(14.606461, -90.490743), 16);
        mMap.animateCamera(mCamera);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap(double lng, double lat, String marker, float color)} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded(double lat, double lng, String marker, float color) {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
                setUpMap(lat, lng, marker,color);
                System.out.println(lat);
                System.out.println(lng);
                System.out.println(marker);
            }
        }
        // Check if we were successful in obtaining the map.
        if (mMap != null) {
            mMap.setMyLocationEnabled(true);
            setUpMap(lat, lng, marker,color);
            System.out.println(lat);
            System.out.println(lng);
            System.out.println(marker);
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap(double lat, double lng, String tittle, float color) {
        MarkerOptions marker= new MarkerOptions()
                .title(tittle)
                .position(new LatLng(lat,lng))
                .icon(BitmapDescriptorFactory.defaultMarker(color));
        mMap.addMarker(marker);
    }
}
