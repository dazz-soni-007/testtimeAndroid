package com.techconfer.quiz.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment implements  AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner gender,classname,language,district;
    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        gender=v.findViewById(R.id.gender);
        classname=v.findViewById(R.id.classname);
        language=v.findViewById(R.id.language);

        gender.setOnItemSelectedListener(this);
        classname.setOnItemSelectedListener(this);
        language.setOnItemSelectedListener(this);

        List<String> langlist = new ArrayList<String>();
        langlist.add("Language");
        langlist.add("Hindi");
        langlist.add("English");

        List<String> categories = new ArrayList<String>();
        categories.add("Gender");
        categories.add("Male");
        categories.add("Female");
        categories.add("Other");

        List<String> classes = new ArrayList<String>();
        classes.add("Class");
        classes.add("First");
        classes.add("Second");
        classes.add("Third");
        classes.add("Four");
        classes.add("Five");
        classes.add("Six");
        classes.add("Seven");
        classes.add("Eight");
        classes.add("Nine");
        classes.add("Ten");
        classes.add("Eleven");
        classes.add("Twelve");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, classes);
        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, langlist);
        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gender.setAdapter(dataAdapter);
        classname.setAdapter(dataAdapter2);
        language.setAdapter(dataAdapter3);
        return v;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}