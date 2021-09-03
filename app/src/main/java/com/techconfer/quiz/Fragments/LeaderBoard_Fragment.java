package com.techconfer.quiz.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Adapter.LeadercardAdapter;
import com.techconfer.quiz.Adapter.TestListAdapter;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;

public class LeaderBoard_Fragment extends Fragment {
    RecyclerView topics_recycler;
    ArrayList subjectslist = new ArrayList<>(Arrays.asList("Sona","Mamta","Koasr","Shakib","George","Sam","Ram"));
    ArrayList points = new ArrayList<>(Arrays.asList("400pt","345pt","300pt","275pt","225pt","200pt","185pt"));
    ArrayList ranklist = new ArrayList<>(Arrays.asList("01","02","03","04","05","06","07"));

    public static LeaderBoard_Fragment newInstance() {
        return new LeaderBoard_Fragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // adding the layout with inflater
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leaderboard_screen, container, false);
        initViews(view);
        return view;
    }

    // initialise the categories
    private void initViews(View view) {
        topics_recycler = view.findViewById(R.id.topics_recyclerview);
        LeadercardAdapter adapter2 = new LeadercardAdapter(getContext(),subjectslist,points,ranklist);
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
