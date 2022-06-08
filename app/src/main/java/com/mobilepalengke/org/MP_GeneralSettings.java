package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MP_GeneralSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_generalsettings);

        ImageButton imgBtnNavReturn = findViewById(R.id.nav_return);

        Spinner spCurrency = findViewById(R.id.spCurrency);
        Spinner spLanguage = findViewById(R.id.spLanguage);

        TextView tvAbout = findViewById(R.id.tvAbout);
        TextView tvNotifications = findViewById(R.id.tvNotifications);

        imgBtnNavReturn.setOnClickListener(v -> startActivity(new Intent(MP_GeneralSettings.this, MP_Profile.class)));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.CurrencyArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurrency.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.LanguageArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLanguage.setAdapter(adapter1);

        tvAbout.setOnClickListener(view -> startActivity(new Intent(MP_GeneralSettings.this, MP_AboutUs.class)));
        tvNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_GeneralSettings.this, MP_NotificationSettings.class));
            }
        });
    }
}