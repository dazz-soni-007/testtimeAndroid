package com.techconfer.quiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.dhruv.timerbutton.TimerButton;
import com.techconfer.quiz.Adapter.NextQuesAdapter;
import com.techconfer.quiz.Adapter.OptionsAdapter;
import com.techconfer.quiz.Adapter.SubjectsListAdapter;
import com.techconfer.quiz.Model.OnSelected;
import com.techconfer.quiz.Model.TestModel;
import com.techconfer.quiz.OnCLickListener;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    ArrayList subjectslist = new ArrayList<>(Arrays.asList("Banking", "Industries", "Fishing", "Cattle Rearing"));
    RecyclerView options_recview, nextque_recyview;
    ArrayList<Integer> counting = new ArrayList<Integer>(30);
    ArrayList<TestModel> testModelArrayList = new ArrayList<>();
    Button nextbtn;
    TextView question, timer,question_count;
    ArrayList<TestModel> onSelectedArrayList;
    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?"
    };
    String answers[] = {"main method", "<=", "this", "interface", "public", "import pkg.*", "None of the mentioned", "java", "equals()", "int"};
    String opt[] = {
            "finalize method", "main method", "static method", "private method",
            "&", "&=", "|=", "<=",
            "import", "this", "catch", "abstract",
            "Interface", "interface", "intf", "Intf",
            "public", "protected", "private", "All of the mentioned",
            "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
            "int", "float", "void", "None of the mentioned",
            "lang", "java", "util", "java.packages",
            "equals()", "Equals()", "isequal()", "Isequal()",
            "int", "long", "byte", "float"
    };

    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("finalize method", "main method", "static method", "private method",
            "&", "&=", "|=", "<=",
            "import", "this", "catch", "abstract",
            "Interface", "interface", "intf", "Intf",
            "public", "protected", "private", "All of the mentioned",
            "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
            "int", "float", "void", "None of the mentioned",
            "lang", "java", "util", "java.packages",
            "equals()", "Equals()", "isequal()", "Isequal()",
            "int", "long", "byte", "float"));


    ArrayList<String> ques = new ArrayList<>(Arrays.asList("Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        nextbtn = findViewById(R.id.nextbtn);
        timer = findViewById(R.id.timer);
        options_recview = findViewById(R.id.options_recyclerview);
        nextque_recyview = findViewById(R.id.next_ques_recylerview);
        question = findViewById(R.id.tvque);
        question_count=findViewById(R.id.question_count);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Computer Test");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        question_count.setText("Question 1/"+ques.size());

        new CountDownTimer(1800000, 1000) {

            public void onTick(long millisUntilFinished) {
                long remainedSecs = millisUntilFinished / 1000;
                timer.setText((remainedSecs / 3600) + ":" + (remainedSecs / 60) + ":" + (remainedSecs % 60));
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                timer.setText("Time Up!");
            }

        }.start();

        nextbtn.setOnClickListener(v -> {
            startActivity(new Intent(this, ResultScreen.class));
        });

        TestModel testModel = new TestModel();
        testModel.setQuestion(String.valueOf(ques));
        testModelArrayList.add(testModel);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(8, LinearLayoutManager.VERTICAL);
        nextque_recyview.setLayoutManager(staggeredGridLayoutManager);
        NextQuesAdapter adapter1 = new NextQuesAdapter(getApplicationContext(), getListData(), new OnCLickListener() {
            @Override
            public void onClick(int positionOfItem) {


                question.setText(testModelArrayList.get(positionOfItem).getQuestion());

                question_count.setText("Question "+testModelArrayList.get(positionOfItem).getCount()+"/"+ques.size());

            }
        });
        nextque_recyview.setAdapter(adapter1);
        OptionsAdapter adapter = new OptionsAdapter(getApplicationContext(), testModelArrayList);
        options_recview.setAdapter(adapter);
    }

  /*  private List<OnSelected> getListData() {
        onSelectedArrayList = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            onSelectedArrayList.add(new OnSelected(String.valueOf(i)));
        }
        return onSelectedArrayList;
    }*/

    private ArrayList<TestModel> getListData() {
        testModelArrayList = new ArrayList<>();

      //  testModel.setQuestion(String.valueOf(ques));
        for (int i = 1; i <= ques.size(); i++) {
            TestModel testModel = new TestModel();
            testModel.setOptions(arrayList);
            testModel.setCount(String.valueOf(i));
            testModelArrayList.add(testModel);
        }
        return testModelArrayList;
    }


}