package com.techconfer.quiz.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.techconfer.quiz.Model.TestModel;
import com.techconfer.quiz.R;

import java.util.ArrayList;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.MyViewHolder> {
    ArrayList personNames;
    Context context;
    ArrayList<TestModel> modelArrayList = new ArrayList<>();


    public OptionsAdapter(Context context, ArrayList<TestModel> personNames) {
        this.context = context;
        this.modelArrayList = personNames;
    }

    @Override
    public OptionsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.options_rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        OptionsAdapter.MyViewHolder vh = new OptionsAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(OptionsAdapter.MyViewHolder holder, int position) {

        final TestModel testModel = modelArrayList.get(position);


            //holder.name.setText(modelArrayList.get(position).getOptions());



        for (String a : modelArrayList.get(position).getOptions()) {

            holder.name.setText(a);

        }

        /*for (String obj : testModel.getOptions()) {

            for (int i = 0; i <= modelArrayList.size(); i++) {

               // if(obj.equals(modelArrayList.get(i)))
                holder.name.setText(testModel.getOptions().get(i));
            }

        }*/

        // set the data in items
//        holder.name.setText((CharSequence) personNames.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                view.setSelected(true);
                holder.name.setTextColor(Color.WHITE);
            }
        });
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        Button name;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (Button) itemView.findViewById(R.id.optionbtn);

        }
    }
}
