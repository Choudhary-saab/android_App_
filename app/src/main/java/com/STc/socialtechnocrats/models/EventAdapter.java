package com.STc.socialtechnocrats.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.STc.socialtechnocrats.R;

import java.util.ArrayList;
import java.util.Arrays;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    Context context;
    ArrayList<EventItem> list;


    public EventAdapter(Context context, ArrayList<EventItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event_card, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.EventViewHolder holder, int position) {
        EventItem item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.image.setImageResource(item.getImageResId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public EventViewHolder(@NonNull View itemView){
            super(itemView);
            image=itemView.findViewById(R.id.EventImage);
            title=itemView.findViewById(R.id.EventTitle);
    }

    }

}
