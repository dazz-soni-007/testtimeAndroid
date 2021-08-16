package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.techconfer.quiz.Adapter.Chapters_FragAdapter;
import com.techconfer.quiz.Adapter.LeaderBoardFrag_Adapter;
import com.techconfer.quiz.R;

public class LeaderBoard extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("LeaderBoard");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tabs);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // setCurrentItem as the tab position
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setDynamicFragmentToTabLayout();
    }

    private void setDynamicFragmentToTabLayout() {
        // here we have given 10 as the tab number
        // you can give any number here
       // for (int i = 1; i < 5; i++) {
            // set the tab name as "Page: " + i

            mTabLayout.addTab(mTabLayout.newTab().setText("Physics"),0);
            mTabLayout.addTab(mTabLayout.newTab().setText("Biology"),1);
            mTabLayout.addTab(mTabLayout.newTab().setText("Chemistry"),2);
            mTabLayout.addTab(mTabLayout.newTab().setText("Mathematics"),3);
            mTabLayout.addTab(mTabLayout.newTab().setText("Computer Science"),4);
        //}
        LeaderBoardFrag_Adapter chapters_fragment = new LeaderBoardFrag_Adapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        // set the adapter
        viewPager.setAdapter(chapters_fragment);

        // set the current item as 0 (when app opens for first time)
        viewPager.setCurrentItem(0);
    }
}