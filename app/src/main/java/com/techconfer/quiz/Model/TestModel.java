package com.techconfer.quiz.Model;

import java.util.ArrayList;

public class TestModel {

    String question,answer;
    String que_number;
    ArrayList<String> options;
    public boolean isSelected= false;
    public String count;

    public TestModel(){

    }

    public TestModel(String question) {
        this.question = question;
    }

    public TestModel(String question, String answer, ArrayList<String> options) {
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQue_number() {
        return que_number;
    }

    public void setQue_number(String que_number) {
        this.que_number = que_number;
    }
}
