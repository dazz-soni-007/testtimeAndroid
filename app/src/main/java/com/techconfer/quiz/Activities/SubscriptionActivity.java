package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.techconfer.quiz.Adapter.OptionsAdapter;
import com.techconfer.quiz.Adapter.SubsCardAdapter;
import com.techconfer.quiz.Adapter.SubscriptionTextAdapter;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;

public class SubscriptionActivity extends AppCompatActivity {
    ArrayList pricelist = new ArrayList<>(Arrays.asList("$1000","$2000","$5000"));
    ArrayList bglist = new ArrayList<>(Arrays.asList(R.drawable.gradient1,R.drawable.gradient3,R.drawable.gradient2));
    ArrayList pricerangelist = new ArrayList<>(Arrays.asList("1 Month","6 Months","1 Year"));

    ArrayList subjectslist = new ArrayList<>(Arrays.asList("No ads", "Remove Watermark", "Use all premium Templates", "Export 1080 HQ video","Premium Support"));
    RecyclerView text_recview,card_recycler;
    SubscriptionTextAdapter subscriptionTextAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        Toolbar toolbar = findViewById(R.id.toolbar);
        text_recview=findViewById(R.id.textrecycler);
        card_recycler=findViewById(R.id.card_recycler);
        toolbar.setTitle("Subscription");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        SubscriptionTextAdapter adapter = new SubscriptionTextAdapter(getApplicationContext(), subjectslist);
        text_recview.setAdapter(adapter);

        SubsCardAdapter adapter2 = new SubsCardAdapter(getApplicationContext(), pricelist,bglist,pricerangelist);
        card_recycler.setAdapter(adapter2);


    }
}