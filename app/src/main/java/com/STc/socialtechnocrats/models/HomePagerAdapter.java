package com.STc.socialtechnocrats.models;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.STc.socialtechnocrats.EventFragment;
import com.STc.socialtechnocrats.GalleryFragment;
import com.STc.socialtechnocrats.HomeFragment;
import com.STc.socialtechnocrats.NewsFragment;
import com.STc.socialtechnocrats.TeamFragment;

public class HomePagerAdapter extends FragmentStateAdapter {

    public HomePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new HomeFragment();   // simple fragment
            case 1: return new EventFragment(); // this will contain inner ViewPager2
            case 2: return new TeamFragment();
            case 3: return new GalleryFragment();
            case 4: return new NewsFragment();
            default: return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
