package com.baking.mirela.bakingapp;

import com.baking.mirela.bakingapp.model.Ingredient;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.model.Steps;

import java.util.ArrayList;

/**
 * Created by mirela on 5/6/2017.
 */

public final class GlobalValues {
    private static String ingredients;
    private static ArrayList<Recipe> recipes;
    private static ArrayList<Steps> steps;
    private static ArrayList<Ingredient> i;
    private static boolean isTwoPane;

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

    public static ArrayList<Steps> getStep(){
        return steps;
    }

    public static void setSteps(ArrayList<Steps> s){
        if(s == null) {return;}
        steps = s;
    }


    public static ArrayList<Ingredient> getIngredient(){
        return i;
    }

    public static void setIngredient(ArrayList<Ingredient>s){
        if(s == null) {return;}
        i = s;
    }

    public static boolean isTwoPane() {
        return isTwoPane;
    }

    public static void setIsTwoPane(boolean isTwoPane) {
        GlobalValues.isTwoPane = isTwoPane;
    }
}
