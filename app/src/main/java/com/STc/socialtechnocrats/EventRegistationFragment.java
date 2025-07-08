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

public class EventRegistationFragment extends Fragment {

    Spinner spinnerEvent,spinnerDepartment, spinnerYear;
    public EventRegistationFragment(){

        super(R.layout.fragment_event_registration);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_registration, container, false);

        spinnerEvent = view.findViewById(R.id.spinner_event);
        spinnerDepartment=view.findViewById(R.id.spinner_department);
        spinnerYear=view.findViewById(R.id.spinner_year);


        // Add items to spinner
        List<String> eventList = new ArrayList<>();
        eventList.add("Choose an event...");
        eventList.add("Hackathon");
        eventList.add("Code Wars");
        eventList.add("Gaming Tournament");
        eventList.add("AI Workshop");
        eventList.add("Drone Show");
        eventList.add("Photography Contest");
        eventList.add("Startup Pitching");
        eventList.add("Tech Quiz");
        eventList.add("Cultural Night");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                eventList
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEvent.setAdapter(adapter);

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

        //Year Spinner
        List<String> yearList=new ArrayList<>();
        yearList.add("Choose a year");
        yearList.add("First");
        yearList.add("Second");
        yearList.add("Third");
        yearList.add("Forth");
        yearList.add("Fifth");

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                yearList
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);


        return view;
    }
}
