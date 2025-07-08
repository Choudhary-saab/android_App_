package com.STc.socialtechnocrats;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {
    public HomeFragment(){

    }

    LinearLayout evnt_btn, team_btn;

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_home_fragment,container,false);

        // Initialize buttons using view.findViewById
        evnt_btn = view.findViewById(R.id.reg_event);
        team_btn = view.findViewById(R.id.join_team);

        // event registration
        evnt_btn.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), Registrationstc.class);
            intent.putExtra("tab_index", 0); // Show EventRegistrationFragment
            startActivity(intent);
        });
        // team registration
        team_btn.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), Registrationstc.class);
            intent.putExtra("tab_index", 1); // Show JoinTeamFragment
            startActivity(intent);
        });

        return view;

    }
}