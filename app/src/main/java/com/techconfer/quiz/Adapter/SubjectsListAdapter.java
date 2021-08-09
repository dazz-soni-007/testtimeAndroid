package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
import com.techconfer.quiz.R;

import java.util.ArrayList;

public class SubjectsListAdapter extends RecyclerView.Adapter<SubjectsListAdapter.MyViewHolder> {
    ArrayList personNames;
    ArrayList personImages;
    Context context;
    private int clickedPosition=-1;
    private boolean isSelected = false;


    public SubjectsListAdapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.homesubjects_custom_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

      /*  if(clickedPosition == position) {
            holder.subjectlayout.setBackgroundResource(R.drawable.gradient_bg);
            holder.name.setTextColor(Color.WHITE);
            holder.image.setColorFilter(holder.image.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        } else {
            holder.subjectlayout.setCardBackgroundColor(Color.WHITE);
            holder.name.setTextColor(context.getResources().getColor(R.color.navyblue));
            holder.image.setColorFilter(holder.image.getContext().getResources().getColor(R.color.navyblue), PorterDuff.Mode.SRC_ATOP);

        }*/

        // set the data in items
        holder.name.setText((CharSequence) personNames.get(position));
        holder.image.setImageResource((Integer) personImages.get(position));
        // implement setOnClickListener event on item view.
        holder.subjectlayout.setOnClickListener(v -> {

          /*  if(clickedPosition==position){
                clickedPosition=-1;
                notifyDataSetChanged();
                return;
            }
            clickedPosition = position;
            notifyDataSetChanged();*/

          /*  holder.subjectlayout.setBackgroundResource(R.drawable.gradient_bg);
            holder.name.setTextColor(Color.WHITE);
            holder.image.setColorFilter(holder.image.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);*/

          Intent i=new Intent(context,Chapters_Activity.class);
          i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          context.startActivity(i);

        });


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
        CardView subjectlayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.sub_name);
            image = (ImageView) itemView.findViewById(R.id.cardimg);
            subjectlayout=(CardView) itemView.findViewById(R.id.subjectlay);
        }
    }
}
