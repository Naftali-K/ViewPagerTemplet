package com.example.viewpagertemplet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpagertemplet.adapter.SwipeViewAdapter;
import com.example.viewpagertemplet.model.ItemCardModel;

import java.util.ArrayList;

public class SwipeViewPager extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager swipe_view_pager;

    private ArrayList<ItemCardModel> modelArrayList;
    private SwipeViewAdapter swipeViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view_pager);

        actionBar = getSupportActionBar();

        swipe_view_pager = findViewById(R.id.swipe_view_pager);

        loadCards();

        swipe_view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // change the title of actionbar
                String title = modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        swipe_view_pager.setPageTransformer(true, new ZoomAnimation());
    }

    private void loadCards(){
        modelArrayList = new ArrayList<>();

        for (int i=0; i < 5; i++){
            modelArrayList.add(new ItemCardModel("Title " + i, "Description " + i, "18/04/2022", R.mipmap.ic_launcher_round));
        }

        swipeViewAdapter = new SwipeViewAdapter(this, modelArrayList);

        swipe_view_pager.setAdapter(swipeViewAdapter);
        swipe_view_pager.setPadding(100, 0, 100, 0);
    }
}