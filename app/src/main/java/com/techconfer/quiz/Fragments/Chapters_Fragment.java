package com.techconfer.quiz.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Adapter.SubjectsListAdapter;
import com.techconfer.quiz.Adapter.TestListAdapter;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Chapters_Fragment extends Fragment {
    RecyclerView topics_recycler;
    ArrayList subjectslist = new ArrayList<>(Arrays.asList("Introduction to Electric Charges and Fields",
            "Electric Charge","Conductors and Insulators","Charging by Induction","Basic Properties of Electric Charge","Coulomb’s Law","Forces between Multiple Charges","Electric Field"," Electric Field Lines","Electric Flux"));
    ArrayList imageslist = new ArrayList<>(Arrays.asList(R.drawable.physics,R.drawable.chemistry,R.drawable.bio,R.drawable.geography,R.drawable.contentpage,R.drawable.english));

    public static Chapters_Fragment newInstance() {
        return new Chapters_Fragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // adding the layout with inflater
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapters, container, false);
        initViews(view);
        return view;
    }

    // initialise the categories
    private void initViews(View view) {
        topics_recycler = view.findViewById(R.id.topics_recyclerview);
        TestListAdapter adapter2 = new TestListAdapter(getContext(),subjectslist);
        topics_recycler.setAdapter(adapter2);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    // pause function call
    @Override
    public void onPause() {
        super.onPause();
    }

    // resume function call
    @Override
    public void onResume() {
        super.onResume();
    }

    // stop when we close
    @Override
    public void onStop() {
        super.onStop();
    }

    // destroy the view
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}