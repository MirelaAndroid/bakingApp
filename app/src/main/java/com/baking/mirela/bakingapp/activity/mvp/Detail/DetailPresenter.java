package com.baking.mirela.bakingapp.activity.mvp.Detail;

import com.baking.mirela.bakingapp.model.Recipe;

/**
 * Created by mirela on 1/2/2018.
 *
 * The presenter is responsible to act as the middle man between view and model.
 */

public interface  DetailPresenter {

    Recipe getDetailRecipeToDisplay(int position);

    void perpareDetailFragment(final boolean mTwoPane);

    void onDestroy();


}
