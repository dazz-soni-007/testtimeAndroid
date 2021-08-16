package com.techconfer.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


import com.techconfer.quiz.Adapter.NotificationAdapter;
import com.techconfer.quiz.Model.NotificationModel;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView notifi_recyler;
    NotificationAdapter notificationAdapter;
    List<NotificationModel> notificationModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notifi_recyler = findViewById(R.id.notification_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Notification");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        NotificationModel notificationModel = new NotificationModel();
        notificationModel.setHeading("George");
        notificationModel.setSubheading("your test score is 80.find out more about your test.");
        notificationModelArrayList.add(notificationModel);

        NotificationModel notificationModel1 = new NotificationModel();
        notificationModel1.setHeading("George");
        notificationModel1.setSubheading("your test score is 40.Keep it up.");
        notificationModelArrayList.add(notificationModel1);

        NotificationModel notificationModel2 = new NotificationModel();
        notificationModel2.setHeading("George");
        notificationModel2.setSubheading("your test score is 70.Good job.Check your answer sheet");
        notificationModelArrayList.add(notificationModel2);


        notificationAdapter=new NotificationAdapter(getApplicationContext(),notificationModelArrayList);
        notifi_recyler.setAdapter(notificationAdapter);

    }

}