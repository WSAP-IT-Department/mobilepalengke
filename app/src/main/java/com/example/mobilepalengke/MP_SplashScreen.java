package com.example.mobilepalengke;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class MP_SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_splashscreen);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                startActivity(new Intent(MP_SplashScreen.this, MP_WelcomeScreen.class));
                finish();
            }
        }, 2000); //2 seconds delay
    }
}