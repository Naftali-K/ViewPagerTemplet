package com.example.viewpagertemplet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.viewpagertemplet.R;
import com.example.viewpagertemplet.model.ItemCardModel;

import java.util.ArrayList;

public class SwipeViewAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<ItemCardModel> modelArrayList;

    public SwipeViewAdapter(Context context, ArrayList<ItemCardModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }


    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_card, container, false);

        //init views
        ImageView bannerIv = view.findViewById(R.id.bannerIv);
        TextView title_tv = view.findViewById(R.id.title_tv);
        TextView description_tv = view.findViewById(R.id.description_tv);
        TextView date_tv = view.findViewById(R.id.date_tv);

        //get data from model
        ItemCardModel model = modelArrayList.get(position);
            String title = model.getTitle();
            String description = model.getDescription();
            String date = model.getDate();
            int image = model.getImage();

        //set data to card
        title_tv.setText(title);
        description_tv.setText(description);
        date_tv.setText(date);
        bannerIv.setImageResource(image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, title + "\n" + description + "\n" + date, Toast.LENGTH_SHORT).show();
            }
        });

        //add view to container
        container.addView(view, position);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
