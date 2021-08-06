package com.techconfer.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.techconfer.quiz.Adapter.FavSubAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class FavSubjectBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener{
    ArrayList personNames = new ArrayList<>(Arrays.asList("Mathematics","Biology","English","Physics","Economics","Geography","Sociology","Chemistry","Biology","Computer"));
    Button save;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fav_lay_bottomsheet,
                container, false);

        save=v.findViewById(R.id.save);
        save.setOnClickListener(this);


        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        // set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        FavSubAdapter customAdapter = new FavSubAdapter(getContext(), personNames);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.save:
                dismiss();

        }
    }
}
