package com.STc.socialtechnocrats;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

public class NewsFragment extends Fragment {

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

        selectTab(tabAll, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
        loadFragment(new)

        tabAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(tabAll, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
            }
        });

        tabAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(tabAnnouncements, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
            }
        });

        tabEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(tabEvents, Arrays.asList(tabAnnouncements, tabEvents, tabUrgent));
            }
        });

        tabUrgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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