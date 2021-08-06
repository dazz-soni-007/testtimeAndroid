package com.techconfer.quiz.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fxn.BubbleTabBar;
import com.techconfer.quiz.Adapter.HomeSliderAdapter;
import com.techconfer.quiz.Adapter.SubjectsListAdapter;
import com.techconfer.quiz.Adapter.TestListAdapter;
import com.techconfer.quiz.FavSubjectBottomSheet;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeFragment extends Fragment {
    RecyclerView subjects_recycler,test_recycler;
    ArrayList subjectslist = new ArrayList<>(Arrays.asList("Physics","Chemistry","Biology","Geography","Mathematics","English"));
    ArrayList imageslist = new ArrayList<>(Arrays.asList(R.drawable.physics,R.drawable.chemistry,R.drawable.bio,R.drawable.geography,R.drawable.math,R.drawable.english));
    ArrayList testlist = new ArrayList<>(Arrays.asList("Test1","Test2","Test3","Test4","Test5","Test6"));
    ViewPager viewpager;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        subjects_recycler=v.findViewById(R.id.subjects_recycler);
        test_recycler=v.findViewById(R.id.test_recycler);
        viewpager=v.findViewById(R.id.viewpager);
        HomeSliderAdapter viewPagerAdapter = new HomeSliderAdapter(getContext());
        viewpager.setAdapter(viewPagerAdapter);

        SubjectsListAdapter adapter = new SubjectsListAdapter(getContext(),subjectslist,imageslist);
        subjects_recycler.setAdapter(adapter);

        test_recycler.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        TestListAdapter adapter2 = new TestListAdapter(getContext(),testlist);
        test_recycler.setAdapter(adapter2);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
       /* FavSubjectBottomSheet bottomSheet = new FavSubjectBottomSheet();
        bottomSheet.show(getChildFragmentManager(),
                "ModalBottomSheet");*/
    }
}