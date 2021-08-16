package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Model.NotificationModel;
import com.techconfer.quiz.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    public List<NotificationModel> notificationModelList;
    Context context;


    public NotificationAdapter(Context context, List<NotificationModel> notificationModelList) {
        this.context = context;
        this.notificationModelList = notificationModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final NotificationModel productModel = notificationModelList.get(position);

        holder.heading.setText(productModel.getHeading());
        holder.subheading.setText(productModel.getSubheading());

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
        TextView heading, subheading;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            heading = (TextView) itemView.findViewById(R.id.heading);
            subheading = (TextView) itemView.findViewById(R.id.sub_heading);

        }
    }
}
