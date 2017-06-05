package com.baking.mirela.bakingapp.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.model.Steps;
import com.baking.mirela.bakingapp.ui.IngrediensFragment;
import com.baking.mirela.bakingapp.ui.StepFragment;

import java.util.ArrayList;

/**
 * Created by mirela on 4/6/2017.
 */

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder> {

    private static ArrayList<Steps> mSteps;
    public static AppCompatActivity mActivity;

    public StepsAdapter(ArrayList<Steps> stepsArrayList, AppCompatActivity activity) {
        mSteps = stepsArrayList;
        mActivity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView cv;
        public TextView step;

        public ViewHolder(View view) {
            super(view);
            cv = (CardView)itemView.findViewById(R.id.step_view);
            step = (TextView)itemView.findViewById(R.id.info_text);

            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            StepFragment stepFragment = new StepFragment();
            stepFragment.setSteps(mSteps, getAdapterPosition());
            stepFragment.setAppCompatActivity(mActivity);
            //ingrediensFragment.setRecipe(recipe.getIngredience());
            mActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,stepFragment).commit();
        }
    }

    @Override
    public StepsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(StepsAdapter.ViewHolder holder, int position) {
        holder.step.setText(mSteps.get(position).getShortDescription());
    }

    @Override
    public int getItemCount() {
        return mSteps.size();
    }
}
