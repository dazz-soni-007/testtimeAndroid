package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.fxn.BubbleTabBar;
import com.fxn.OnBubbleClickListener;
import com.techconfer.quiz.Fragments.HistoryFragment;
import com.techconfer.quiz.Fragments.HomeFragment;
import com.techconfer.quiz.Fragments.ProfileFragment;
import com.techconfer.quiz.Fragments.SubscriptionFragment;
import com.techconfer.quiz.R;

public class HomeActivity extends AppCompatActivity {
    BubbleTabBar bubbleTabBar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bubbleTabBar = findViewById(R.id.bubbleTabBar);
        viewPager = findViewById(R.id.viewpager);


        bubbleTabBar.addBubbleListener(i -> {

            switch (i) {
                case R.id.home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.history:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.subscription:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.profile:
                    viewPager.setCurrentItem(3);

            }

        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                try {
                    bubbleTabBar.setSelected(position, false);
                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(HomeActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return new HomeFragment();
                case 1:
                    return new HistoryFragment();
                case 2:
                    return new SubscriptionFragment();
                case 3:
                    return new ProfileFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


}


