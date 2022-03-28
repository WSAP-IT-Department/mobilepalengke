package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MP_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_profile);

        TextView tvAccountDetails = (TextView) findViewById(R.id.tvAccountDetails);

        tvAccountDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Profile.this, MP_AccountDetails.class));
            }
        });

//        TextView tvAddresses = (TextView) findViewById(R.id.tvAddresses);
//
//        tvAccountDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MP_Profile.this, MP_GeneralSettings.class));
//            }
//        });

        TextView tvSettings = (TextView) findViewById(R.id.tvSettings);

        tvAccountDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Profile.this, MP_GeneralSettings.class));
            }
        });

        Button signOut  = (Button) findViewById(R.id.btnSignout);

        tvAccountDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Profile.this, MP_SignIn.class));
            }
        });
    }
}