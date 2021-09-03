package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Activities.Chapters_Activity;
import com.techconfer.quiz.OnCLickListener;
import com.techconfer.quiz.R;

import java.util.ArrayList;

public class SubsCardAdapter extends RecyclerView.Adapter<SubsCardAdapter.MyViewHolder> {
    ArrayList personNames;
    ArrayList personImages;
    ArrayList price;
    Context context;
    private int clickedPosition=-1;
    private boolean isSelected = false;


    public SubsCardAdapter(Context context, ArrayList personNames,ArrayList personImages,ArrayList price) {
        this.context = context;
        this.personNames = personNames;
        this.personImages=personImages;
        this.price=price;
    }

    @Override
    public SubsCardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subsripcard_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        SubsCardAdapter.MyViewHolder vh = new SubsCardAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(SubsCardAdapter.MyViewHolder holder, int position) {


        // set the data in items
        holder.name.setText((CharSequence) personNames.get(position));
      //     holder.bg.setBackgroundResource((Integer) personImages.get(position));

        // implement setOnClickListener event on item view.
        holder.mainlay.setOnClickListener(v -> {
            isSelected=true;
            holder.name.setVisibility(View.VISIBLE);
            holder.bg.setBackgroundResource((Integer) personImages.get(position));
            holder.bg.setText((CharSequence) price.get(position));
        });




    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name,bg;
        ImageView image;
        LinearLayout mainlay;
        CardView subjectlayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.price_range);
            bg=(TextView)itemView.findViewById(R.id.textbg);
            subjectlayout=(CardView) itemView.findViewById(R.id.subjectlay);
            mainlay=(LinearLayout)itemView.findViewById(R.id.cardlinear);
        }
    }
}

