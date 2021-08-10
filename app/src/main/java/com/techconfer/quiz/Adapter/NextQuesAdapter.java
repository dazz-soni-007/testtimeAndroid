package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Model.OnSelected;
import com.techconfer.quiz.OnCLickListener;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class NextQuesAdapter extends RecyclerView.Adapter<NextQuesAdapter.MyViewHolder> {
    ArrayList<Integer> personNames = new ArrayList<Integer>();
    Context context;
    List<OnSelected> mModellist = new ArrayList<>();
    OnCLickListener onCLickListener;

    public NextQuesAdapter(Context context, List<OnSelected> mModellist,OnCLickListener onCLickListener) {
        this.context = context;
        this.mModellist = mModellist;
        this.onCLickListener=onCLickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nextquestion_rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final OnSelected model = mModellist.get(position);
        // set the data in items
        holder.name.setText(model.getCount());
        holder.ques_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                reselectAll();

                notifyDataSetChanged();
                onCLickListener.onClick(position);


                mModellist.get(position).setSelected(true);
                notifyDataSetChanged();

            }
        });

        if(mModellist.get(position).isSelected){
            holder.name.setBackgroundResource(R.drawable.active_dot);
            holder.name.setTextColor(context.getResources().getColor(R.color.white));
        }
        else
        {
            holder.name.setBackgroundResource(R.drawable.non_active_dot);
            holder.name.setTextColor(context.getResources().getColor(R.color.navyblue));
        }
    }


    public void reselectAll() {

        for (int i = 0; i < mModellist.size(); i++) {
            mModellist.get(i).setSelected(false);

        }
    }

    @Override
    public int getItemCount() {
        return mModellist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        Button name;
        RelativeLayout ques_layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (Button) itemView.findViewById(R.id.optionbtn);
            ques_layout = (RelativeLayout) itemView.findViewById(R.id.ques_layout);

        }
    }
}
