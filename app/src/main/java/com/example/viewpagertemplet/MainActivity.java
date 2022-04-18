package com.example.viewpagertemplet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewpagertemplet.fragments.PageFragment1;
import com.example.viewpagertemplet.fragments.PageFragment2;
import com.example.viewpagertemplet.fragments.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button animation_slider_btn, imp_slider_btn, swipe_view_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setReferences();

        animation_slider_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AnimationPager.class);
                startActivity(intent);
            }
        });

        imp_slider_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ImpPagerWithCircle.class);
                startActivity(intent);
            }
        });

        swipe_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SwipeViewPager.class);
                startActivity(intent);
            }
        });
    }

    private void setReferences(){
        animation_slider_btn = findViewById(R.id.animation_slider_btn);
        imp_slider_btn = findViewById(R.id.imp_slider_btn);
        swipe_view_btn = findViewById(R.id.swipe_view_btn);
    }
}