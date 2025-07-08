package com.STc.socialtechnocrats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class JoinTeamFragment extends Fragment {
    Spinner spinnerDepartment;
    public JoinTeamFragment() {
        super(R.layout.fragment_join_team);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_join_team, container, false);

        spinnerDepartment = view.findViewById(R.id.spinner_department);


        // Department spinner
        List<String> departmentList=new ArrayList<>();
        departmentList.add("Choose a Department....");
        departmentList.add("CSE");
        departmentList.add("CCS");
        departmentList.add("Civil");
        departmentList.add("Mechancial");
        departmentList.add("CSE(AI/ML)");
        departmentList.add("BBA");
        departmentList.add("B.com");
        departmentList.add("MBA");

        ArrayAdapter<String> departmentAdapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                departmentList
        );
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDepartment.setAdapter(departmentAdapter);

        return view;
    }
}
