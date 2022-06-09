package com.mobilepalengke.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobilepalengke.org.Model.User;

public class MP_SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_signup);

        EditText etCompleteName = (EditText) findViewById(R.id.etCompleteName);
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnSignup = (Button) findViewById(R.id.btnSignup);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table_user = database.getReference("User");

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(etCompleteName.getText().toString().isEmpty())
                        {
                            etCompleteName.setError("Must not leave blank.");
                            Toast.makeText(MP_SignUp.this, "Please fill up incomplete form.", Toast.LENGTH_SHORT).show();

                        }
                        else if(etEmail.getText().toString().isEmpty())
                        {
                            etEmail.setError("Must not leave blank.");
                            Toast.makeText(MP_SignUp.this, "Please fill up incomplete form.", Toast.LENGTH_SHORT).show();

                        }
                        else if(etPassword.getText().toString().isEmpty())
                        {
                            etPassword.setError("Must not leave blank.");
                            Toast.makeText(MP_SignUp.this, "Please fill up incomplete form.", Toast.LENGTH_SHORT).show();

                        }
                        else if(snapshot.child(etCompleteName.getText().toString()).exists())
                        {
                            Toast.makeText(MP_SignUp.this, "Account already exists.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            User user = new User(etEmail.getText().toString(),etPassword.getText().toString());
                            table_user.child(etCompleteName.getText().toString()).setValue(user);
                            Toast.makeText(MP_SignUp.this, "Account Created successfully!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}