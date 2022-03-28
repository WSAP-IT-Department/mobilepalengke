package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MP_Home extends AppCompatActivity {
    ScrollView vscrollBody;
    ImageSlider imageSliderBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_home);

        vscrollBody = (ScrollView) findViewById(R.id.vscrollBody);
        OverScrollDecoratorHelper.setUpOverScroll(vscrollBody);

        imageSliderBanner();
    }

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