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
import com.techconfer.quiz.Model.RulesListModel;
import com.techconfer.quiz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RulesListAdapter extends RecyclerView.Adapter<RulesListAdapter.MyViewHolder> {
    public List<RulesListModel> notificationModelList;
    Context context;
    ArrayList personNames = new ArrayList<>(Arrays.asList("Banking","Industries","Fishing","Cattle Rearing"));



    public RulesListAdapter(Context context, List<RulesListModel> notificationModelList) {
        this.context = context;
        this.notificationModelList = notificationModelList;
    }

    @Override
    public RulesListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ruleslist_row, parent, false);
        return new RulesListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RulesListAdapter.MyViewHolder holder, final int position) {
        final RulesListModel productModel = notificationModelList.get(position);

        holder.heading.setText(productModel.getRuledescription());


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


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            heading = (TextView) itemView.findViewById(R.id.rulesline);

        }
    }
}

