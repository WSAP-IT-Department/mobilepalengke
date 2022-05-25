package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MP_SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_signin);

        ProgressBar progressBarTop = (ProgressBar) findViewById(R.id.ProgressBar1);
        ProgressBar progressBarBottom = (ProgressBar) findViewById(R.id.ProgressBar2);

        Button btnSignin = (Button) findViewById(R.id.btnSignin);
        TextView txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_SignIn.this, MP_Home.class));
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_SignIn.this, MP_ForgotPassword1.class));
            }
        });
    }
}