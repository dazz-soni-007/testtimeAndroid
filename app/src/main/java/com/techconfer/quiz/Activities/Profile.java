package com.techconfer.quiz.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity implements  AdapterView.OnItemSelectedListener, View.OnClickListener{
    Spinner gender,classname,language,school,district;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        gender=findViewById(R.id.gender);
        school=findViewById(R.id.schoolname);
        district=findViewById(R.id.district);
        classname=findViewById(R.id.classname);
        language=findViewById(R.id.language);

        gender.setOnItemSelectedListener(this);
        classname.setOnItemSelectedListener(this);
        language.setOnItemSelectedListener(this);

        school.setOnItemSelectedListener(this);
        district.setOnItemSelectedListener(this);

        List<String> langlist = new ArrayList<String>();
        langlist.add("Language");
        langlist.add("Hindi");
        langlist.add("English");

        List<String> categories = new ArrayList<String>();
        categories.add("Gender");
        categories.add("Male");
        categories.add("Female");
        categories.add("Other");

        List<String> classes = new ArrayList<String>();
        classes.add("Class");
        classes.add("First");
        classes.add("Second");
        classes.add("Third");
        classes.add("Four");
        classes.add("Five");
        classes.add("Six");
        classes.add("Seven");
        classes.add("Eight");
        classes.add("Nine");
        classes.add("Ten");
        classes.add("Eleven");
        classes.add("Twelve");

        List<String> districtlist = new ArrayList<String>();
        districtlist.add("District");
        districtlist.add("Bhiwani");
        districtlist.add("Dadri");
        districtlist.add("Hisar");
        districtlist.add("Faridabad");
        districtlist.add("Jhajjar");
        districtlist.add("Sonipat");
        districtlist.add("Rohtak");
        districtlist.add("Panipat");
        districtlist.add("Karnal");
        districtlist.add("Ambala");


        List<String> schoollist = new ArrayList<String>();
        schoollist.add("School");
        schoollist.add("Dav Public School");
        schoollist.add("St. Stephen School");
        schoollist.add("Doon Public School");
        schoollist.add("Delhi Public School");
        schoollist.add("Bal Bharti School");
        schoollist.add("Hardayal Public School");
        schoollist.add("Vaish Public School");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, classes);
        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, langlist);
        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, districtlist);
        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, schoollist);
        // Drop down layout style - list view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(dataAdapter);
        classname.setAdapter(dataAdapter2);
        language.setAdapter(dataAdapter3);
        district.setAdapter(dataAdapter5);
        school.setAdapter(dataAdapter4);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}