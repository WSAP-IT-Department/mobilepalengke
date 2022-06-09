package com.mobilepalengke.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MP_ContactUs extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    ImageView ivfacebook, ivinstagram, ivtwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_contact_us);

        ivfacebook = findViewById(R.id.facebook);
        ivinstagram = findViewById(R.id.instagram);
        ivtwitter = findViewById(R.id.twitter);


        ivfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sApplink = "https://www.facebook.com/MobilePalengke";
                String sPackage = "com.facebook.katana";

                Uri uri = Uri.parse(sApplink);
                Intent fbook = new Intent(Intent.ACTION_VIEW);
                fbook.setData(uri);
                fbook.setPackage(sPackage);
                fbook.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(fbook);
            }
        });

        ivinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sApplink = "https://www.instagram.com/mobilepalengke";
                String sPackage = "com.instagram.android";

                Uri uri = Uri.parse(sApplink);
                Intent ig = new Intent(Intent.ACTION_VIEW);
                ig.setData(uri);
                ig.setPackage(sPackage);
                ig.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(ig);
            }
        });

        ivtwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sApplink = "https://twitter.com/MobilePalengke";
                String sPackage = "com.twitter.android";

                Uri uri = Uri.parse(sApplink);
                Intent twitter = new Intent(Intent.ACTION_VIEW);
                twitter.setData(uri);
                twitter.setPackage(sPackage);
                twitter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(twitter);
            }
        });

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