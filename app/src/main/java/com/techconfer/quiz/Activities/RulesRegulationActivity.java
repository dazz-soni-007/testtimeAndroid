package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.techconfer.quiz.Adapter.AnswerSheet_Adapter;
import com.techconfer.quiz.Adapter.RulesListAdapter;
import com.techconfer.quiz.Model.AnswersheetModel;
import com.techconfer.quiz.Model.RulesListModel;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class RulesRegulationActivity extends AppCompatActivity {
    RecyclerView notifi_recyler;
    RulesListAdapter notificationAdapter;
    List<RulesListModel> notificationModelArrayList = new ArrayList<>();
    Button agree;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_regulation);
        notifi_recyler = findViewById(R.id.ruleslist);
       // backbtn=findViewById(R.id.backbtn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Rules & Regulation");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        agree=findViewById(R.id.agree);
        agree.setOnClickListener(v -> {

            startActivity(new Intent(RulesRegulationActivity.this,TestActivity.class));
        });

     /*   backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/
        RulesListModel notificationModel = new RulesListModel();
        notificationModel.setRuledescription("\u25CF The examination will comprise of Objective type Multiple Choice Questions (MCQs)");
        notificationModelArrayList.add(notificationModel);

        RulesListModel obj1 = new RulesListModel();
        obj1.setRuledescription("\u25CF All questions are compulsory and each carries One mark.");
        notificationModelArrayList.add(obj1);

        RulesListModel obj2 = new RulesListModel();
        obj2.setRuledescription("\u25CF The total number of questions, duration of examination, will be different based on \n" +
                "the course, the detail is available on your screen.");
        notificationModelArrayList.add(obj2);

        RulesListModel obj3 = new RulesListModel();
        obj3.setRuledescription("\u25CF The Subjects or topics covered in the exam will be as per the Syllabus.");
        notificationModelArrayList.add(obj3);

        RulesListModel obj4 = new RulesListModel();
        obj4.setRuledescription("\u25CF There will be NO NEGATIVE MARKING for the wrong answers.");
        notificationModelArrayList.add(obj4);


        notificationAdapter=new RulesListAdapter(getApplicationContext(),notificationModelArrayList);
        notifi_recyler.setAdapter(notificationAdapter);
    }
}