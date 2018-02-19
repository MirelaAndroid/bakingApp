package com.baking.mirela.bakingapp.activity.mvp.Ingredient;

import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.model.Ingredient;

import java.util.ArrayList;

/**
 * Created by mirela on 19/2/2018.
 */

public class IngredientPresenterImpl implements IngredientPresenter {

    ArrayList<Ingredient> ingredience;

    @Override
    public String displayIngredients() {
        String items ="";

        if(ingredience == null) {
            ingredience = GlobalValues.getIngredient();
        }
        for(int i=0; i< ingredience.size(); i++){
            items += ingredience.get(i).getIngredient() + ": " + ingredience.get(i).getQuantity() + ingredience.get(i).getMeasure() + "\n\n";
        }
        GlobalValues.setIngredients(items);
        return items;

    }

    @Override
    public void setRecipe(ArrayList<Ingredient> ingredient) {
        GlobalValues.setIngredient(ingredient);
        this.ingredience = ingredient;
    }

    @Override
    public void onDestroy() {

    }
}
