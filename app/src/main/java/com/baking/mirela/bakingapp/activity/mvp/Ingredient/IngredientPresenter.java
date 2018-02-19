package com.baking.mirela.bakingapp.activity.mvp.Ingredient;

import com.baking.mirela.bakingapp.model.Ingredient;

import java.util.ArrayList;

/**
 * Created by mirela on 19/2/2018.
 */

public interface IngredientPresenter {

    String displayIngredients();

    void setRecipe(ArrayList<Ingredient> ingredient);

    void onDestroy();
}
