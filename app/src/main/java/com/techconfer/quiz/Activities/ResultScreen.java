package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.techconfer.quiz.R;

import java.util.ArrayList;

public class ResultScreen extends AppCompatActivity implements View.OnClickListener {
    private PieChart chart;
    RadioButton answersheet,backhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        answersheet=findViewById(R.id.radia_id1);
        backhome=findViewById(R.id.radia_id2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Science Test");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        answersheet.setOnClickListener(this);
        backhome.setOnClickListener(this);

        chart = findViewById(R.id.chart1);
        chart.setBackgroundColor(getResources().getColor(R.color.navyblue));

        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(true);
        chart.setDrawHoleEnabled(false);

        chart.setRotationEnabled(false);
        chart.setHighlightPerTapEnabled(true);


        chart.setMaxAngle(180f); // HALF CHART
        chart.setRotationAngle(180f);

        setData(3, 100);

        chart.animateY(1400, Easing.EaseInCirc);

        // entry label styling
        chart.setEntryLabelColor(Color.WHITE);
        chart.setEntryLabelTextSize(12f);

    }

    private void setData(int count, float range) {

        ArrayList<PieEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            values.add(new PieEntry((float) ((Math.random() * range) + range / 5)));
        }

        PieDataSet dataSet = new PieDataSet(values, "Performance Chart");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setValueTextColor(Color.WHITE);

        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        chart.setData(data);

        chart.invalidate();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

          case R.id.radia_id1:
              startActivity(new Intent(this,AnswerSheet.class));
              break;

            case R.id.radia_id2:
                startActivity(new Intent(this,Dashboard.class));
                break;


        }
    }
}