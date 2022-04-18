package com.example.viewpagertemplet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewpagertemplet.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class ImpPagerWithCircle extends AppCompatActivity {

    private List<String> titlesList = new ArrayList<>();
    private List<String> descList = new ArrayList<>();
    private List<Integer> imagesList = new ArrayList<>();

    private ViewPagerAdapter viewPagerAdapter;

    private ViewPager2 view_pager2;
    private CircleIndicator3 indicator;

    private Button next_btn, back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_pager_with_circle);

        postToList();

        view_pager2 = findViewById(R.id.view_pager2);
        indicator = findViewById(R.id.indicator);
        next_btn = findViewById(R.id.next_btn);
        back_btn = findViewById(R.id.back_btn);

        viewPagerAdapter = new ViewPagerAdapter(titlesList, descList, imagesList);
        view_pager2.setAdapter(viewPagerAdapter);
        view_pager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        indicator.setViewPager(view_pager2);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                view_pager2.beginFakeDrag();
//                view_pager2.fakeDragBy(-10f);
//                view_pager2.endFakeDrag();
                view_pager2.setCurrentItem(view_pager2.getCurrentItem()+1, true);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_pager2.setCurrentItem(view_pager2.getCurrentItem()-1, true);
            }
        });

    }

    private void addToList(String title, String description, int image){
        titlesList.add(title);
        descList.add(description);
        imagesList.add(image);
    }

    private void postToList(){
        for (int i=0; i<=5; i++){
            addToList("Title " + i, "Description " + i, R.mipmap.ic_launcher_round);
        }
    }
}