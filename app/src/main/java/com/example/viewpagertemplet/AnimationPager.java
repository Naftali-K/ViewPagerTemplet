package com.example.viewpagertemplet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpagertemplet.adapter.SlidePagerAdapter;
import com.example.viewpagertemplet.fragments.PageFragment1;
import com.example.viewpagertemplet.fragments.PageFragment2;
import com.example.viewpagertemplet.fragments.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class AnimationPager extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_pager);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PageFragment1());
        fragmentList.add(new PageFragment2());
        fragmentList.add(new PageFragment3());

        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setPageTransformer(true, new ZoomAnimation()); //add animation

        viewPager.setAdapter(pagerAdapter);
    }
}