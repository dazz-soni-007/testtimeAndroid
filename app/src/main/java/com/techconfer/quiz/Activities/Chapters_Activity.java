package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.techconfer.quiz.Adapter.Chapters_FragAdapter;
import com.techconfer.quiz.Fragments.Chapters_Fragment;
import com.techconfer.quiz.R;

public class Chapters_Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout mTabLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Chapters");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initViews();
    }

    private void initViews() {

        // initialise the layout
        viewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tabs);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("Physics");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
     //   collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.navyblue));

        // setOffscreenPageLimit means number
        // of tabs to be shown in one page
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

    // show all the tab using DynamicFragmnetAdapter
    private void setDynamicFragmentToTabLayout() {
        // here we have given 10 as the tab number
        // you can give any number here
        for (int i = 1; i < 10; i++) {
            // set the tab name as "Page: " + i
            mTabLayout.addTab(mTabLayout.newTab().setText("Chapter  " + i));
        }
        Chapters_FragAdapter chapters_fragment = new Chapters_FragAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        // set the adapter
        viewPager.setAdapter(chapters_fragment);

        // set the current item as 0 (when app opens for first time)
        viewPager.setCurrentItem(0);
    }
}