package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.techconfer.quiz.Adapter.NotificationAdapter;
import com.techconfer.quiz.Adapter.TestHistoryAdapter;
import com.techconfer.quiz.Model.NotificationModel;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class TestHistory extends AppCompatActivity {
    RecyclerView testhist_recyler;
    TestHistoryAdapter notificationAdapter;
    List<NotificationModel> notificationModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_history);
        testhist_recyler=findViewById(R.id.testhistory_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Test History");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        NotificationModel notificationModel2 = new NotificationModel();
        notificationModel2.setHeading("Mathematics Exam Paper 1");
        notificationModel2.setSubheading("145/200 Marks");
        notificationModelArrayList.add(notificationModel2);

        NotificationModel notificationModel3 = new NotificationModel();
        notificationModel3.setHeading("Physics Exam Paper 1");
        notificationModel3.setSubheading("125/200 Marks");
        notificationModelArrayList.add(notificationModel3);

        NotificationModel notificationModel4 = new NotificationModel();
        notificationModel4.setHeading("Biology Exam Paper 1");
        notificationModel4.setSubheading("165/200 Marks");
        notificationModelArrayList.add(notificationModel4);

        NotificationModel notificationModel5 = new NotificationModel();
        notificationModel5.setHeading("English Exam Paper 1");
        notificationModel5.setSubheading("105/200 Marks");
        notificationModelArrayList.add(notificationModel5);

        NotificationModel notificationModel6 = new NotificationModel();
        notificationModel6.setHeading("Mathematics Exam Paper 1");
        notificationModel6.setSubheading("175/200 Marks");
        notificationModelArrayList.add(notificationModel6);


        notificationAdapter=new TestHistoryAdapter(getApplicationContext(),notificationModelArrayList);
        testhist_recyler.setAdapter(notificationAdapter);
    }
}