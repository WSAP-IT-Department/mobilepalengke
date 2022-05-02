package com.mobilepalengke.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MP_Home extends AppCompatActivity {
    ScrollView vscrollBody;
    ImageSlider imageSliderBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_home);

        ImageView ivCategory1 = (ImageView) findViewById(R.id.ivCategory1);
        ImageView ivCategory2 = (ImageView) findViewById(R.id.ivCategory2);
        ImageView ivCategory3 = (ImageView) findViewById(R.id.ivCategory3);
        ImageView ivCategory4 = (ImageView) findViewById(R.id.ivCategory4);
        ImageView ivCategory5 = (ImageView) findViewById(R.id.ivCategory5);
        ImageView ivCategory6 = (ImageView) findViewById(R.id.ivCategory6);
        ImageView ivCategory7 = (ImageView) findViewById(R.id.ivCategory7);
        ImageView ivCategory8 = (ImageView) findViewById(R.id.ivCategory8);
        ImageView ivCategory9 = (ImageView) findViewById(R.id.ivCategory9);
        ImageView ivCategory10 = (ImageView) findViewById(R.id.ivCategory10);

        ImageView ivFacebook = (ImageView) findViewById(R.id.ivFacebook);
        ImageView ivInstagram = (ImageView) findViewById(R.id.ivInstagram);
        ImageView ivTwitter = (ImageView) findViewById(R.id.ivTwitter);

        vscrollBody = (ScrollView) findViewById(R.id.vscrollBody);
        OverScrollDecoratorHelper.setUpOverScroll(vscrollBody);

        imageSliderBanner();

        //Nav Bar - START
        BottomNavigationView bottomNavBar = (BottomNavigationView) findViewById(R.id.navbar);

        bottomNavBar.setSelectedItemId(R.id.nav_home);

        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext()
                            ,MP_Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
        //Nav Bar - END

    private void imageSliderBanner(){
        imageSliderBanner = (ImageSlider) findViewById(R.id.imageSliderBanner);
        ArrayList<SlideModel> images = new ArrayList<>();

        images.add(new SlideModel(R.drawable.slider_banner1, null));
        images.add(new SlideModel(R.drawable.slider_banner2, null));
        images.add(new SlideModel(R.drawable.logo_text, null));
        images.add(new SlideModel(R.drawable.logo_default, null));
        imageSliderBanner.setImageList(images, ScaleTypes.CENTER_CROP);
    }


}