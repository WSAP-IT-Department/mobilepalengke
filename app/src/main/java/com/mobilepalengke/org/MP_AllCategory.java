package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MP_AllCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_all_category);

        ImageButton BackButton = findViewById(R.id.allcat_nav_return);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_AllCategory.this, MP_Home.class));
                finish();
            }
        });

    }
}