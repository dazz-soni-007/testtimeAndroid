package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Activities.Chapters_Activity;
import com.techconfer.quiz.Activities.ResultScreen;
import com.techconfer.quiz.Model.NotificationModel;
import com.techconfer.quiz.R;

import java.util.List;

public class TestHistoryAdapter extends RecyclerView.Adapter<TestHistoryAdapter.MyViewHolder> {
    public List<NotificationModel> notificationModelList;
    Context context;


    public TestHistoryAdapter(Context context, List<NotificationModel> notificationModelList) {
        this.context = context;
        this.notificationModelList = notificationModelList;
    }

    @Override
    public TestHistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.testhistory_row, parent, false);
        return new TestHistoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TestHistoryAdapter.MyViewHolder holder, final int position) {
        final NotificationModel productModel = notificationModelList.get(position);

        holder.heading.setText(productModel.getHeading());
        holder.subheading.setText(productModel.getSubheading());
        holder.view_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ResultScreen.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return notificationModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView heading, subheading,view_result;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            heading = (TextView) itemView.findViewById(R.id.exam_name);
            subheading = (TextView) itemView.findViewById(R.id.marks);
            view_result=(TextView)itemView.findViewById(R.id.view_result);

        }
    }
}

