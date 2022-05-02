package com.mobilepalengke.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MP_ContactUs extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_contact_us);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        map = googleMap;

        LatLng Bacoor = new LatLng(14.424717, 120.953235);
        map.addMarker(new MarkerOptions().position(Bacoor).title("DAO St., Corner Nara, Bacoor, 4102 Cavite"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Bacoor));

    }
}