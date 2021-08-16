package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Activities.RulesRegulationActivity;
import com.techconfer.quiz.R;

import java.util.ArrayList;

public class SubscriptionTextAdapter extends RecyclerView.Adapter<SubscriptionTextAdapter.MyViewHolder> {
    ArrayList personNames;
    ArrayList personImages;
    Context context;

    public SubscriptionTextAdapter(Context context, ArrayList personNames) {
        this.context = context;
        this.personNames = personNames;
    }

    @Override
    public SubscriptionTextAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscrip_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        SubscriptionTextAdapter.MyViewHolder vh = new SubscriptionTextAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(SubscriptionTextAdapter.MyViewHolder holder, int position) {
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
        RelativeLayout mainlay;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.testname);
            image = (ImageView) itemView.findViewById(R.id.testimg);
        }
    }
}