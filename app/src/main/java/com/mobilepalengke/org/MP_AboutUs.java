package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MP_AboutUs extends AppCompatActivity {
    ImageSlider imageSliderLogisticsPartner;
    ImageSlider imageSliderPartnershipBrands;

    ImageView ivfacebook, ivinstagram, ivtwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_aboutus);

        TabLayout tlMVG = findViewById(R.id.tlMVG);
        ViewPager vpMVG = findViewById(R.id.vpMVG);

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

        tlMVG.setupWithViewPager(vpMVG, true);

        VPAdapter_About vpAdapter_about = new VPAdapter_About(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter_about.addFragment(new Frag_About1(),"Mission");
        vpAdapter_about.addFragment(new Frag_About2(),"Vision");
        vpAdapter_about.addFragment(new Frag_About3(),"Goals");
        vpMVG.setAdapter(vpAdapter_about);

        imageSliderLogisticsPartnerHolder();
        imageSliderLogisticsPartnershipBrandHolder();

        ImageButton imgBtnNavReturn = findViewById(R.id.nav_return);

        imgBtnNavReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_AboutUs.this, MP_GeneralSettings.class));
            }
        });

    }
    private void imageSliderLogisticsPartnerHolder(){
        imageSliderLogisticsPartner = (ImageSlider) findViewById(R.id.imageSliderLogisticsPartner);
        ArrayList<SlideModel> images = new ArrayList<>();

        images.add(new SlideModel(R.drawable.slider_aboutus1, null));
        images.add(new SlideModel(R.drawable.slider_aboutus2, null));
        images.add(new SlideModel(R.drawable.slider_aboutus3, null));
        images.add(new SlideModel(R.drawable.slider_aboutus4, null));
        images.add(new SlideModel(R.drawable.slider_aboutus5, null));
        images.add(new SlideModel(R.drawable.slider_aboutus6, null));
        images.add(new SlideModel(R.drawable.slider_aboutus7, null));
        images.add(new SlideModel(R.drawable.slider_aboutus8, null));
        images.add(new SlideModel(R.drawable.slider_aboutus9, null));
        images.add(new SlideModel(R.drawable.slider_aboutus10, null));
        images.add(new SlideModel(R.drawable.slider_aboutus11, null));
        images.add(new SlideModel(R.drawable.slider_aboutus12, null));
        images.add(new SlideModel(R.drawable.slider_aboutus13, null));
        imageSliderLogisticsPartner.setImageList(images, ScaleTypes.CENTER_INSIDE);
    }

    private void imageSliderLogisticsPartnershipBrandHolder(){
        imageSliderPartnershipBrands = (ImageSlider) findViewById(R.id.imageSliderPartnershipBrands);
        ArrayList<SlideModel> images = new ArrayList<>();

        images.add(new SlideModel(R.drawable.slider_aboutus14, null));
        images.add(new SlideModel(R.drawable.slider_aboutus15, null));
        images.add(new SlideModel(R.drawable.slider_aboutus16, null));
        images.add(new SlideModel(R.drawable.slider_aboutus17, null));
        images.add(new SlideModel(R.drawable.slider_aboutus18, null));
        images.add(new SlideModel(R.drawable.slider_aboutus19, null));
        images.add(new SlideModel(R.drawable.slider_aboutus20, null));
        images.add(new SlideModel(R.drawable.slider_aboutus21, null));
        imageSliderPartnershipBrands.setImageList(images, ScaleTypes.CENTER_INSIDE);
    }
}