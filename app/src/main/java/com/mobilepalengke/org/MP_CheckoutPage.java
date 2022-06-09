package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MP_CheckoutPage extends AppCompatActivity {

    TextView viewOrderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_checkoutpage);

        viewOrderSummary = (TextView)findViewById(R.id.viewOrderSummary);
        viewOrderSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDialog();
            }
        });

    }

    private void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_mp_fragment_order_summary);
        dialog.show();
    }
}