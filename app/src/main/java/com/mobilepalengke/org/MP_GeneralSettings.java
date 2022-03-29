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

        ImageButton imgBtnNavReturn = (ImageButton) findViewById(R.id.nav_return);

        Spinner spCurrency = (Spinner) findViewById(R.id.spCurrency);
        Spinner spLanguage = (Spinner) findViewById(R.id.spLanguage);

        TextView tvAbout = (TextView) findViewById(R.id.tvAbout);

        imgBtnNavReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_GeneralSettings.this, MP_Profile.class));
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.CurrencyArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurrency.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.LanguageArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLanguage.setAdapter(adapter1);

        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_GeneralSettings.this, MP_AboutUs.class));
            }
        });


    }
}