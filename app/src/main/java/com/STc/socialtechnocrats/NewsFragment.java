package com.STc.socialtechnocrats;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.STc.socialtechnocrats.models.NewsAdapter;
import com.STc.socialtechnocrats.models.NewsItem;

import java.util.Arrays;
import java.util.List;

public class NewsFragment extends Fragment {

    RecyclerView recyclerView;
    NewsAdapter adapter;
    List<NewsItem> newsList;

    TextView tabAll, tabAnnouncements, tabEvents, tabUrgent;
    public NewsFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_news_fragment, container, false);

        tabAll=view.findViewById(R.id.all_tab);
        tabAnnouncements=view.findViewById(R.id.tab_announce);
        tabEvents=view.findViewById(R.id.tab_Event);
        tabUrgent=view.findViewById(R.id.tab_Urgent);

        recyclerView = view.findViewById(R.id.newsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        selectTab(tabAll, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
        newsList = Arrays.asList(
                new NewsItem("Hackathon 2025", "Events", "STC Hackathon is back!", "9 July 2025"),
                new NewsItem("Meeting at 4PM", "Announcement", "All members must attend.", "7 July 2025"),
                new NewsItem("Exam Delayed", "Urgent", "All exams shifted by 2 days", "5 July 2025")
        );

        adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

        adapter.filterBy("All"); // default filter
        selectTab(tabAll, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));

        tabAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.filterBy("All");
                selectTab(tabAll, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
            }
        });

        tabAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.filterBy("Announcements");
                selectTab(tabAnnouncements, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
            }
        });

        tabEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.filterBy("Events");
                selectTab(tabEvents, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
            }
        });

        tabUrgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.filterBy("Urgent");
                selectTab(tabUrgent, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
            }
        });

        return view;

    }

    private void selectTab(TextView selected, List<TextView> others){
        selected.setBackgroundResource(R.drawable.rounded_blue_bg);
        selected.setTextColor(Color.WHITE);

        for(TextView tv : others){
            tv.setBackgroundColor(Color.TRANSPARENT);
            tv.setTextColor(Color.parseColor("#333333"));
        }
    }

}