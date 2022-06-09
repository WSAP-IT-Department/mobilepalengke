package com.mobilepalengke.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobilepalengke.org.Interface.ItemClickListener;
import com.mobilepalengke.org.Model.Category;
import com.mobilepalengke.org.ViewHolder.CategoryViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MP_Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    FirebaseDatabase database;
    DatabaseReference category;

    ScrollView vscrollBody;
    ImageSlider imageSliderBanner;
    RecyclerView recycler_categories;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_home);

        database = FirebaseDatabase.getInstance();
        category = database.getReference("Category");

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

        //Load Menu
        recycler_categories = (RecyclerView)findViewById(R.id.recycler_categories);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recycler_categories.setLayoutManager(layoutManager);

        loadMenu();
    }

    private void loadMenu()
    {
        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(Category.class,R.layout.category_item, CategoryViewHolder.class,category) {
            @Override
            protected void populateViewHolder(CategoryViewHolder menuViewHolder, Category model, int i) {
                Picasso.get().load(model.getImage())
                        .into(menuViewHolder.imageView);
                final Category clickItem = model;
                menuViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent productList = new Intent(MP_Home.this,MP_ProductSelection.class);

                        productList.putExtra("CategoryId",adapter.getRef(position).getKey());
                        startActivity(productList);
                    }
                });

            }
        };
        recycler_categories.setAdapter(adapter);
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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        return false;
    }
}