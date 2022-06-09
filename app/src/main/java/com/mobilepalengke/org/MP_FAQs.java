package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MP_FAQs extends AppCompatActivity {

    Dialog mydialog;
    ImageView ivfacebook, ivinstagram, ivtwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_faqs);
        VideoView videoView = findViewById(R.id.videoview);
        String videopath = "android.resource://" + getPackageName() +  "/" + R.raw.faqsvideo;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        ivfacebook = findViewById(R.id.facebook);
        ivinstagram = findViewById(R.id.instagram);
        ivtwitter = findViewById(R.id.twitter);


        ivfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sApplink = "https://www.facebook.com/MobilePalengke";
                String sPackage = "com.facebook.katana";

                Uri uri = Uri.parse(sApplink);
                Intent fbook = new Intent(Intent.ACTION_VIEW);
                fbook.setData(uri);
                fbook.setPackage(sPackage);
                fbook.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(fbook);
            }
        });

        ivinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sApplink = "https://www.instagram.com/mobilepalengke";
                String sPackage = "com.instagram.android";

                Uri uri = Uri.parse(sApplink);
                Intent ig = new Intent(Intent.ACTION_VIEW);
                ig.setData(uri);
                ig.setPackage(sPackage);
                ig.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(ig);
            }
        });

        ivtwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sApplink = "https://twitter.com/MobilePalengke";
                String sPackage = "com.twitter.android";

                Uri uri = Uri.parse(sApplink);
                Intent twitter = new Intent(Intent.ACTION_VIEW);
                twitter.setData(uri);
                twitter.setPackage(sPackage);
                twitter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(twitter);
            }
        });








        mydialog = new Dialog(this);
    }
    public void ShowPopUp(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_payment1);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopUp2(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_payment2);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopUp3(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_payment3);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopUp4(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_payment4);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopUp5(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_delivery1);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopUp6(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_delivery2);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopUp7(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_delivery3);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopUp8(View v) {
        TextView txtclose;
        mydialog.setContentView(R.layout.mp_delivery4);
        txtclose =(TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }

}