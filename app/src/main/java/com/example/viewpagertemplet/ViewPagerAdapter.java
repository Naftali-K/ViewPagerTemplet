package com.example.viewpagertemplet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.PagerV2ViewHolder> {

    private List<String> titles;
    private List<String> details;
    private List<Integer> images;

    public ViewPagerAdapter(List<String> titles, List<String> details, List<Integer> images) {
        this.titles = titles;
        this.details = details;
        this.images = images;
    }


    @NonNull
    @Override
    public ViewPagerAdapter.PagerV2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new PagerV2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.PagerV2ViewHolder holder, int position) {
        holder.itemTitle.setText(titles.get(position));
        holder.itemDetails.setText(details.get(position));
        holder.image.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class PagerV2ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle;
        private TextView itemDetails;
        private ImageView image;

        public PagerV2ViewHolder(@NonNull View itemView) {
            super(itemView);

            setReferences(itemView);
        }

        private void setReferences(View view){
            itemTitle = view.findViewById(R.id.tvTitle);
            itemDetails = view.findViewById(R.id.tvAbout);
            image = view.findViewById(R.id.ivImage);

        }
    }
}
