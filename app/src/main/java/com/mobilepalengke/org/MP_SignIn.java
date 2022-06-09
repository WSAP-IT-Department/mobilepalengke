package com.mobilepalengke.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobilepalengke.org.Model.User;

public class MP_SignIn extends AppCompatActivity {

    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_signin);

        ProgressBar progressBarTop = (ProgressBar) findViewById(R.id.ProgressBar1);
        ProgressBar progressBarBottom = (ProgressBar) findViewById(R.id.ProgressBar2);

        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnSignin = (Button) findViewById(R.id.btnSignin);
        TextView txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table_user = database.getReference("User");

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Check if User Doesnt Exist
                        if(snapshot.child(etEmail.getText().toString()).exists())
                        {
                            //Get User Info
                            User user = snapshot.child(etEmail.getText().toString()).getValue(User.class);
                            if(user.getPassword().equals(etPassword.getText().toString()))
                            {
                                startActivity(new Intent(MP_SignIn.this, MP_Home.class));
                            }
                            else
                            {
                                Toast.makeText(MP_SignIn.this, "The password you entered is incorrect. Please try again.",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MP_SignIn.this, "That email account doesn't exist. Enter a different account or create a new one.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

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