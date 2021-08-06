package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.R;

import java.util.ArrayList;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.MyViewHolder> {
    ArrayList personNames;
    ArrayList personImages;
    Context context;

    public TestListAdapter(Context context, ArrayList personNames) {
        this.context = context;
        this.personNames = personNames;
    }

    @Override
    public TestListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_test_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        TestListAdapter.MyViewHolder vh = new TestListAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(TestListAdapter.MyViewHolder holder, int position) {
        // set the data in items
        holder.name.setText((CharSequence) personNames.get(position));
      //  holder.image.setImageResource((Integer) personImages.get(position));
        // implement setOnClickListener event on item view.


    }


    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;
        ConstraintLayout mainlay;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.testname);
            image = (ImageView) itemView.findViewById(R.id.testimg);
        }
    }
}