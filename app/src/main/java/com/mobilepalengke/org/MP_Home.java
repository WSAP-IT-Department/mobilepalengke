package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_home);

        ImageView ivCategory1 = findViewById(R.id.ivCategory1);
        ImageView ivCategory2 = findViewById(R.id.ivCategory2);
        ImageView ivCategory3 = findViewById(R.id.ivCategory3);
        ImageView ivCategory4 = findViewById(R.id.ivCategory4);
        ImageView ivCategory5 = findViewById(R.id.ivCategory5);
        ImageView ivCategory6 = findViewById(R.id.ivCategory6);
        ImageView ivCategory7 = findViewById(R.id.ivCategory7);
        ImageView ivCategory8 = findViewById(R.id.ivCategory8);
        ImageView ivCategory9 = findViewById(R.id.ivCategory9);
        ImageView ivCategory10 = findViewById(R.id.ivCategory10);

        ImageView ivMeal1 = findViewById(R.id.ivMeal1);
        ImageView ivMeal2 = findViewById(R.id.ivMeal2);
        ImageView ivMeal3 = findViewById(R.id.ivMeal3);
        ImageView ivMeal4 = findViewById(R.id.ivMeal4);
        ImageView ivMeal5 = findViewById(R.id.ivMeal5);
        ImageView ivMeal6 = findViewById(R.id.ivMeal6);

        Button AllCategoryBut = findViewById(R.id.tvSeeAllCategoryButton);



        vscrollBody = findViewById(R.id.vscrollBody);
        OverScrollDecoratorHelper.setUpOverScroll(vscrollBody);

        imageSliderBanner();

        //Category Navigation - START

        AllCategoryBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Home.this, MP_AllCategory.class));
                finish();
            }
        });

        ivCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });

        ivCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MP_Home.this, MP_ProductSelection.class));
                finish();
            }
        });


        ivMeal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Home.this, MP_MealPlan1.class));
            }
        });

        ivMeal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Home.this, MP_MealPlan2.class));
            }
        });

        ivMeal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Home.this, MP_MealPlan3.class));
            }
        });

        ivMeal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Home.this, MP_MealPlan4.class));
            }
        });

        ivMeal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Home.this, MP_MealPlan5.class));
            }
        });

        ivMeal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MP_Home.this, MP_MealPlan6.class));
            }
        });


        //Nav Bar - START
        BottomNavigationView bottomNavBar = findViewById(R.id.navbar);

        bottomNavBar.setSelectedItemId(R.id.nav_home);

        bottomNavBar.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id){
                case R.id.nav_home:
                    return true;
                case R.id.nav_cart:
                    startActivity(new Intent(getApplicationContext()
                            ,MP_CartPage.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_profile:
                    startActivity(new Intent(getApplicationContext()
                        ,MP_Profile.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
        //Nav Bar - END

        //Social Media Links - START

        ImageView ivFacebook = findViewById(R.id.ivFacebook);
        ImageView ivInstagram = findViewById(R.id.ivInstagram);
        ImageView ivTwitter = findViewById(R.id.ivTwitter);

        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/MobilePalengke")));
            }
        });

        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://instagram.com/mobilepalengke")));
            }
        });

        ivTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/mobilepalengke")));
            }
        });

        //Social Media Links - END
    }

    private void imageSliderBanner(){
        imageSliderBanner = findViewById(R.id.imageSliderBanner);
        ArrayList<SlideModel> images = new ArrayList<>();

        images.add(new SlideModel(R.drawable.slider_banner1, null));
        images.add(new SlideModel(R.drawable.slider_banner2, null));
        images.add(new SlideModel(R.drawable.logo_text, null));
        images.add(new SlideModel(R.drawable.logo_default, null));
        imageSliderBanner.setImageList(images, ScaleTypes.CENTER_CROP);
    }


}