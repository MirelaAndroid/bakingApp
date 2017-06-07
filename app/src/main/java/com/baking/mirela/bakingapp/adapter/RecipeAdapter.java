package com.baking.mirela.bakingapp.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baking.mirela.bakingapp.DetailActivity;
import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.ui.DetailRecipeFragment;

import java.util.ArrayList;

/**
 * Created by mirela on 31/5/2017.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private static ArrayList<Recipe> mDataset;
    public static AppCompatActivity mActivity;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        // each data item is just a string in this case

        private CardView cv;
        public TextView recipeName;

        public ViewHolder(View view) {
            super(view);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            recipeName = (TextView)itemView.findViewById(R.id.info_text);

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            GlobalValues.setPosition(getAdapterPosition());

            Intent intent = new Intent(mActivity, DetailActivity.class);

            mActivity.startActivity(intent);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecipeAdapter(ArrayList<Recipe> myDataset, AppCompatActivity activity) {
        mDataset = myDataset;
        mActivity = activity;
    }

    public void update(ArrayList<Recipe> list) {
        mDataset = list;
        notifyDataSetChanged();
    }
    // Create new views (invoked by the layout manager)
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.crad_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.recipeName.setText(mDataset.get(position).getName());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(mDataset == null) return 0;
        return mDataset.size();
    }
}
