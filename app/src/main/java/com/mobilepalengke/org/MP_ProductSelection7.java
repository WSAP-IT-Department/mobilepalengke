package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MP_ProductSelection7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_productselection7);

        ImageButton ibReturn = findViewById(R.id.nav_return);
        RelativeLayout rlProduct = findViewById(R.id.rlProduct1);

        ibReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rlProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_ProductSelection7.this, MP_ProductPage.class));
            }
        });
    }
}