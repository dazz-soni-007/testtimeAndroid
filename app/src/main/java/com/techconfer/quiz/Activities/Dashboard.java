package com.techconfer.quiz.Activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fxn.BubbleTabBar;
import com.techconfer.quiz.Adapter.HomeSliderAdapter;
import com.techconfer.quiz.Adapter.SubjectsListAdapter;
import com.techconfer.quiz.Adapter.TestListAdapter;
import com.techconfer.quiz.FavSubjectBottomSheet;
import com.techconfer.quiz.Model.Item;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    ViewPager viewPager;
    RecyclerView subjects_recycler,test_recycler;
    ArrayList subjectslist = new ArrayList<>(Arrays.asList("Physics","Chemistry","Biology","Geography","Mathematics","English"));
    ArrayList imageslist = new ArrayList<>(Arrays.asList(R.drawable.physics,R.drawable.chemistry,R.drawable.bio,R.drawable.geography,R.drawable.contentpage,R.drawable.english));
    ArrayList testlist = new ArrayList<>(Arrays.asList("English Test","Math Test","Physics Test","Biology Test","Geography Test","Chemistry Test","Math Test","Physics Test","Biology Test","Geography Test","Chemistry Test"));
    private DrawerLayout drawerLayout;
    ImageView menuicon;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuicon=findViewById(R.id.menuicon);
        listView=findViewById(R.id.navLV);
        subjects_recycler=findViewById(R.id.subjects_recycler);
        test_recycler=findViewById(R.id.test_recycler);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        HomeSliderAdapter viewPagerAdapter = new HomeSliderAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        SubjectsListAdapter adapter = new SubjectsListAdapter(getApplicationContext(),subjectslist,imageslist);
        subjects_recycler.setAdapter(adapter);

        test_recycler.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));
        TestListAdapter adapter2 = new TestListAdapter(getApplicationContext(),testlist);
        test_recycler.setAdapter(adapter2);

        menuicon.setOnClickListener(v -> {

            drawerLayout.openDrawer(GravityCompat.START);
        });

        final List<Item> items = new ArrayList<>();
        items.add(new Item("Home", R.drawable.home));
        items.add(new Item("Profile", R.drawable.profile));
        items.add(new Item("LeaderBoard", R.drawable.leaderboard));
        items.add(new Item("Test History", R.drawable.testhistory));
        items.add(new Item("Subscription", R.drawable.subscription));
        items.add(new Item("Notification", R.drawable.notification));
        items.add(new Item("About Us", R.drawable.aboutus));
        items.add(new Item("Content Page", R.drawable.contentpage));
        items.add(new Item("Logout", R.drawable.logout));
        CustomAdapter customAdapter = new CustomAdapter(this, items);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getApplicationContext(), items.get(position).getName() + " Clicked", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 1:
                        startActivity(new Intent(Dashboard.this,Profile.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*FavSubjectBottomSheet bottomSheet = new FavSubjectBottomSheet();
        bottomSheet.show(getSupportFragmentManager(),
                "ModalBottomSheet");*/
    }

    class CustomAdapter extends BaseAdapter {

        Context context;
        List<Item> items;

        public CustomAdapter(Context context, List<Item> items) {
            this.context = context;
            this.items = items;
        }


        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = LayoutInflater.from(context).inflate(R.layout.drawer_row_layout, null);
            ImageView icon = v.findViewById(R.id.icon);
            TextView text = v.findViewById(R.id.text);

            icon.setImageResource(items.get(i).getImage());
            text.setText(items.get(i).getName());
            //event handling code can be done here
            return v;
        }
    }

}