package com.STc.socialtechnocrats.models;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.STc.socialtechnocrats.EventRegistationFragment;
import com.STc.socialtechnocrats.JoinTeamFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? new EventRegistationFragment() : new JoinTeamFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
