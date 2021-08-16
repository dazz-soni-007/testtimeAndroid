package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.techconfer.quiz.Model.AnswersheetModel;
import com.techconfer.quiz.Model.NotificationModel;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerSheet_Adapter extends RecyclerView.Adapter<AnswerSheet_Adapter.MyViewHolder> {
    public List<AnswersheetModel> notificationModelList;
    Context context;
    ArrayList personNames = new ArrayList<>(Arrays.asList("Banking","Industries","Fishing","Cattle Rearing"));



    public AnswerSheet_Adapter(Context context, List<AnswersheetModel> notificationModelList) {
        this.context = context;
        this.notificationModelList = notificationModelList;
    }

    @Override
    public AnswerSheet_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answersheet_row, parent, false);
        return new AnswerSheet_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AnswerSheet_Adapter.MyViewHolder holder, final int position) {
        final AnswersheetModel productModel = notificationModelList.get(position);

        holder.heading.setText(productModel.getQuestion());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        holder.options.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        FavSubAdapter customAdapter = new FavSubAdapter(context.getApplicationContext(), personNames);
        holder.options.setAdapter(customAdapter); // set the Adapter to RecyclerView

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
        TextView heading;
        RecyclerView options;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            heading = (TextView) itemView.findViewById(R.id.questiontext);
            options = (RecyclerView) itemView.findViewById(R.id.recyclerview);

        }
    }
}
