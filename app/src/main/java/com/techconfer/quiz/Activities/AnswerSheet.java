package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.techconfer.quiz.Adapter.AnswerSheet_Adapter;
import com.techconfer.quiz.Adapter.NotificationAdapter;
import com.techconfer.quiz.Model.AnswersheetModel;
import com.techconfer.quiz.Model.NotificationModel;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class AnswerSheet extends AppCompatActivity {
    RecyclerView notifi_recyler;
    AnswerSheet_Adapter notificationAdapter;
    List<AnswersheetModel> notificationModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet);
        notifi_recyler = findViewById(R.id.notification_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Answer Sheet");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        AnswersheetModel notificationModel = new AnswersheetModel();
        notificationModel.setQuestion("Which of the following economic activities belong to secondary sector?");
        notificationModelArrayList.add(notificationModel);

        AnswersheetModel nm = new AnswersheetModel();
        nm.setQuestion("Which of the following economic activities belong to secondary sector?");
        notificationModelArrayList.add(nm);

        AnswersheetModel nm1 = new AnswersheetModel();
        nm1.setQuestion("Which of the following economic activities belong to secondary sector?");
        notificationModelArrayList.add(nm1);

        AnswersheetModel nm2 = new AnswersheetModel();
        nm2.setQuestion("Which of the following economic activities belong to secondary sector?");
        notificationModelArrayList.add(nm2);

        notificationAdapter=new AnswerSheet_Adapter(getApplicationContext(),notificationModelArrayList);
        notifi_recyler.setAdapter(notificationAdapter);

    }
}