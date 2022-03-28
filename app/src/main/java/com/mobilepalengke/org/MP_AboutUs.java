package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MP_AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_aboutus);

        TabLayout tlMVG = findViewById(R.id.tlMVG);
        ViewPager vpMVG = findViewById(R.id.vpMVG);

        tlMVG.setupWithViewPager(vpMVG, true);

        VPAdapter_About vpAdapter_about = new VPAdapter_About(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter_about.addFragment(new Frag_About1(),"Mission");
        vpAdapter_about.addFragment(new Frag_About2(),"Vision");
        vpAdapter_about.addFragment(new Frag_About3(),"Goals");
        vpMVG.setAdapter(vpAdapter_about);

    }
}