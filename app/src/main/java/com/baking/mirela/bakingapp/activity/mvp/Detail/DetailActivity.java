package com.baking.mirela.bakingapp.activity.mvp.Detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.activity.mvp.Ingredient.IngredientFragment;

/**
 * Created by mirela on 4/6/2017.
 */

public class DetailActivity extends AppCompatActivity implements DetailView {


    private boolean mTwoPane;

    private DetailPresenter presenter;

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

        presenter = new DetailPresenterImpl(this, new DetailInteractorImpl());

        Recipe recipe = presenter.getDetailRecipeToDisplay(getIntent().getExtras().getInt("position"));
        DetailFragment fragment = new DetailFragment();

        if(mTwoPane) {
            GlobalValues.setIsTwoPane(true);

            fragment.setActivity(this);
            fragment.setRecipe(recipe);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();

            IngredientFragment ingredientFragment = new IngredientFragment();
            ingredientFragment.presenter.setRecipe(GlobalValues.getRecipe().get(getIntent().getExtras().getInt("position")).getIngredience());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container2,ingredientFragment).commit();


        } else {
            fragment.setActivity(this);
            if(GlobalValues.getRecipe() != null) {
                fragment.setRecipe(GlobalValues.getRecipe().get(getIntent().getExtras().getInt("position")));
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();

        }


    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();

    }

    @Override
    public void displayListOfSteps() {

    }
}
