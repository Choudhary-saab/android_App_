package com.STc.socialtechnocrats;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.STc.socialtechnocrats.models.HomePagerAdapter;
import com.STc.socialtechnocrats.models.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class stc_home extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter adapter;

    int[] tabIcons={
            R.drawable.ic_home,
            R.drawable.ic_events,
            R.drawable.ic_team,
            R.drawable.ic_gallery,
            R.drawable.ic_news,

    };

    String[] tabTitles={
            "Home", "Events", "Team" , "Gallery", "News"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stc_home);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        HomePagerAdapter adapter1=new HomePagerAdapter(this);
        viewPager.setAdapter(adapter1);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(tabTitles[position]);
                        tab.setIcon(tabIcons[position]);
                    }
                }).attach();

    }
}