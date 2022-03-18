package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MP_WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_welcome);

        Button btnSignin = (Button) findViewById(R.id.btnSignin);
        Button btnSignup = (Button) findViewById(R.id.btnSignup);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_WelcomeScreen.this, MP_SignIn.class));
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_WelcomeScreen.this, MP_SignUp.class));
            }
        });

    }
}