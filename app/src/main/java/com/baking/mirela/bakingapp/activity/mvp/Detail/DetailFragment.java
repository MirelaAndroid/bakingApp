package com.baking.mirela.bakingapp.activity.mvp.Detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.adapter.StepsAdapter;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.ui.IngredientFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mirela on 5/2/2018.
 */

public class DetailFragment extends Fragment implements DetailView {

    @BindView(R.id.ingredient_button)
    Button ingredientButton;

    private Recipe recipe;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private AppCompatActivity appCompatActivity;

    public DetailFragment() {
    }

    public void setRecipe(Recipe recipe){
        this.recipe = recipe;
    }

    public void setActivity(AppCompatActivity activity){
        appCompatActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootView);
        ingredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngredientFragment ingredientFragment = new IngredientFragment();
                ingredientFragment.setRecipe(recipe.getIngredience());

                if(GlobalValues.isTwoPane()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container2, ingredientFragment).commit();
                } else {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, ingredientFragment).commit();
                }
            }
        });
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.steps_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        if(recipe != null) {
            mAdapter = new StepsAdapter(recipe.getSteps(), appCompatActivity);
            mRecyclerView.setAdapter(mAdapter);
        }
        return  rootView;

    }

    @Override
    public void displayListOfSteps() {

    }
}
