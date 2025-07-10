package com.STc.socialtechnocrats;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.STc.socialtechnocrats.models.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Registrationstc extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stc_registration);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        pagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Event Registration");
                    tab.setIcon(R.drawable.ic_event);
                    break;
                case 1:
                    tab.setText("Join Team");
                    tab.setIcon(R.drawable.ic_team);
                    break;
            }
        }).attach();

        // ✅ Move this INSIDE onCreate
        int selectedTab = getIntent().getIntExtra("tab_index", 0);
        viewPager2.setCurrentItem(selectedTab, false); // false disables scroll animation
    }
}
