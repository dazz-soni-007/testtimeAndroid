package com.techconfer.quiz.Model;

public class OnSelected {
    public boolean isSelected= false;
    public String count;

    public OnSelected(String count) {
        this.count=count;
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
}
