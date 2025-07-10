package com.STc.socialtechnocrats.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.STc.socialtechnocrats.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsItem> fullList;
    private List<NewsItem> filteredList;

    public NewsAdapter(List<NewsItem> list) {
        this.fullList = list;
        this.filteredList = new ArrayList<>(list);
    }

    public void filterBy(String category) {
        if (category.equals("All")) {
            filteredList = new ArrayList<>(fullList);
        } else {
            filteredList = new ArrayList<>();
            for (NewsItem item : fullList) {
                if (item.getCategory().equalsIgnoreCase(category)) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_card, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem item = filteredList.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.date.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, date;

        public NewsViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
        }
    }
}
