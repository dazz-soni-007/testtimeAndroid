package com.techconfer.quiz.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.techconfer.quiz.Adapter.NextQuesAdapter;
import com.techconfer.quiz.Adapter.OptionsAdapter;
import com.techconfer.quiz.Adapter.SubjectsListAdapter;
import com.techconfer.quiz.Model.OnSelected;
import com.techconfer.quiz.OnCLickListener;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    ArrayList subjectslist = new ArrayList<>(Arrays.asList("Banking", "Industries", "Fishing", "Cattle Rearing"));
    RecyclerView options_recview, nextque_recyview;
    //ArrayList counting=new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"));
    ArrayList<Integer> counting = new ArrayList<Integer>(30);

    List<OnSelected> onSelectedArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        options_recview = findViewById(R.id.options_recyclerview);
        nextque_recyview = findViewById(R.id.next_ques_recylerview);

       /* onSelectedArrayList.clear();
        OnSelected onSelected=new OnSelected();
        for (int i = 1; i <= 30; i++) {
            onSelected.setCount(i);
            onSelectedArrayList.add(onSelected);
        }*/
     //   onSelectedArrayList.add(onSelected);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(8, LinearLayoutManager.VERTICAL);
        nextque_recyview.setLayoutManager(staggeredGridLayoutManager);
        NextQuesAdapter adapter1 = new NextQuesAdapter(getApplicationContext(), getListData(), new OnCLickListener() {
            @Override
            public void onClick(int positionOfItem) {

                if(onSelectedArrayList.get(positionOfItem).isSelected==true){

                    onSelectedArrayList.get(positionOfItem).isSelected();


                }else{
                    Object o=new Object();
                    onSelectedArrayList.remove(o);

                }

            }
        });
        nextque_recyview.setAdapter(adapter1);

        OptionsAdapter adapter = new OptionsAdapter(getApplicationContext(), subjectslist);
        options_recview.setAdapter(adapter);
    }

    private List<OnSelected> getListData() {
        onSelectedArrayList = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            onSelectedArrayList.add(new OnSelected(String.valueOf(i)));
        }
        return onSelectedArrayList;
    }
}