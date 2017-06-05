package com.baking.mirela.bakingapp;

import com.baking.mirela.bakingapp.model.Recipe;

import java.util.ArrayList;

/**
 * Created by mirela on 5/6/2017.
 */

public class GlobalValues {
    private static String ingredients;
    private static ArrayList<Recipe> recipes;

    public static String getIngredients() {
        return ingredients;
    }

    public static void setIngredients(String ingredients) {
        GlobalValues.ingredients = ingredients;
    }

    public static ArrayList<Recipe> getRecipe(){
        return recipes;
    }

    public static void getRecipe(ArrayList<Recipe> r){
        recipes = r;
    }
}
