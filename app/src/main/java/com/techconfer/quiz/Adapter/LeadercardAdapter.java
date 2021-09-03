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

public class LeadercardAdapter extends RecyclerView.Adapter<LeadercardAdapter.MyViewHolder> {
    ArrayList personNames;
    ArrayList points;
    ArrayList rank;
    Context context;

    public LeadercardAdapter(Context context, ArrayList personNames,ArrayList points,ArrayList rank) {
        this.context = context;
        this.personNames = personNames;
        this.points=points;
        this.rank=rank;
    }

    @Override
    public LeadercardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        LeadercardAdapter.MyViewHolder vh = new LeadercardAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(LeadercardAdapter.MyViewHolder holder, int position) {
        // set the data in items
        holder.name.setText((CharSequence) personNames.get(position));
        holder.rank.setText((CharSequence) rank.get(position));
        holder.points.setText((CharSequence) points.get(position));
        //  holder.image.setImageResource((Integer) personImages.get(position));
        // implement setOnClickListener event on item view.

    }


    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name,rank,points;
        ImageView image;
        RelativeLayout mainlay;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.testname);
            rank = (TextView) itemView.findViewById(R.id.rank);
            points = (TextView) itemView.findViewById(R.id.points);

        }
    }
}
