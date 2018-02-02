package com.baking.mirela.bakingapp.activity.mvp.Detail;

import android.app.Activity;

import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.ui.DetailRecipeFragment;
import com.baking.mirela.bakingapp.ui.IngredientFragment;

import java.util.ArrayList;

/**
 * Created by mirela on 1/2/2018.
 */

public class DetailPresenterImpl implements DetailPresenter {

    private DetailView detailView;
    private DetailInteractorImpl detailInteractor;

    private Recipe recipe;

    public DetailPresenterImpl(DetailView detailView, DetailInteractorImpl detailInteractor){
        this.detailView = detailView;
        this.detailInteractor = detailInteractor;
    }

    @Override
    public Recipe getDetailRecipeToDisplay(int position) {
        return GlobalValues.getRecipe().get(position);
    }

    @Override
    public void perpareDetailFragment(boolean mTwoPane) {

    }

    @Override
    public void onDestroy() {
        detailView = null;
    }

}
