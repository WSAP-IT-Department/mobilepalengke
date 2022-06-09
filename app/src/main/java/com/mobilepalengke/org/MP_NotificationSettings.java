package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MP_NotificationSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_notification_settings);

        ImageButton backButton = findViewById(R.id.nav_return);

        TextView tvPushNotification = findViewById(R.id.tvPushNotification);
        TextView tvEmailNotification = findViewById(R.id.tvEmailNotification);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_NotificationSettings.this, MP_GeneralSettings.class));
            }
        });

        tvPushNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_NotificationSettings.this, MP_PushNotification.class));
            }
        });

        tvEmailNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_NotificationSettings.this, MP_EmailNotification.class));
            }
        });


    }
}