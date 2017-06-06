package com.baking.mirela.bakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.parser.JsonParser;
import com.baking.mirela.bakingapp.ui.DetailRecipeFragment;
import com.baking.mirela.bakingapp.ui.IngrediensFragment;
import com.baking.mirela.bakingapp.ui.MainFragment;

import java.util.ArrayList;

/**
 * Created by mirela on 4/6/2017.
 */

public class DetailActivity extends AppCompatActivity {


    private boolean mTwoPane;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        if (findViewById(R.id.item_list) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.

            mTwoPane = true;
        }

        if(mTwoPane) {
            GlobalValues.setIsTwoPane(true);
            DetailRecipeFragment fragment = new DetailRecipeFragment();

            fragment.setActivity(this);
            fragment.setRecipe(GlobalValues.getRecipe().get(getIntent().getExtras().getInt("position")));

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();

            IngrediensFragment ingrediensFragment = new IngrediensFragment();
            ingrediensFragment.setRecipe(GlobalValues.getRecipe().get(getIntent().getExtras().getInt("position")).getIngredience());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container2,ingrediensFragment).commit();


        } else {

            DetailRecipeFragment fragment = new DetailRecipeFragment();

            fragment.setActivity(this);
            fragment.setRecipe(GlobalValues.getRecipe().get(getIntent().getExtras().getInt("position")));

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();

        }




    }

}
