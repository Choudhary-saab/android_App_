package com.STc.socialtechnocrats.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.STc.socialtechnocrats.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    Context context;
    ArrayList<GalleryItem> list;

    public GalleryAdapter(Context context, ArrayList<GalleryItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery_card, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        GalleryItem item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.image.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.galleryImage);
            title = itemView.findViewById(R.id.galleryTitle);
        }
    }
}
