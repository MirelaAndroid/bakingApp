package com.baking.mirela.bakingapp.parser;

import android.util.Log;

import com.baking.mirela.bakingapp.model.Ingredient;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.model.Steps;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mirela on 29/5/2017.
 */

public class JsonParser {
    public static ArrayList<Recipe> parseRecipes(String response) {
        final String RECIPE_ID = "id";
        final String RECIPE_NAME = "name";
        final String RECIPE_INGREDIENTS = "ingredients";
        final String RECIPE_STEPS = "steps";
        final String RECIPE_SERVINGS = "servings";
        final String RECIPE_IMAGE = "image";


        ArrayList<Recipe> list = new ArrayList<Recipe>();
        try{
            JSONArray recipeJson = new JSONArray(response);
            Log.e("kotek  ", recipeJson.length() + " len");
            for(int i = 0; i < recipeJson.length(); i++) {
                Recipe recipe = new Recipe();
                JSONObject jsonObject = recipeJson.getJSONObject(i);
                recipe.setId(jsonObject.getInt(RECIPE_ID));
                recipe.setName(jsonObject.getString(RECIPE_NAME));
                recipe.setImage(jsonObject.getString(RECIPE_IMAGE));
                recipe.setServings(jsonObject.getString(RECIPE_SERVINGS));

                ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
                JSONArray ingredientJson = new JSONArray(jsonObject.getString(RECIPE_INGREDIENTS));
                JSONArray stepsJson = new JSONArray(jsonObject.getString(RECIPE_STEPS));
                for(int j=0; j <  ingredientJson.length(); j++) {
                    Ingredient ingredient = new Ingredient();
                    jsonObject = ingredientJson.getJSONObject(j);
                    ingredient.setIngredient(jsonObject.getString("ingredient"));
                    ingredient.setMeasure(jsonObject.getString("measure"));
                    ingredient.setQuantity(jsonObject.getString("quantity"));
                    ingredients.add(ingredient);
                }
                recipe.setIngredient(ingredients);

                ArrayList<Steps> steps =  new ArrayList<Steps>();
                for(int j = 0; j < stepsJson.length(); j++) {
                    Steps step = new Steps();
                    jsonObject = stepsJson.getJSONObject(j);
                    step.setId(jsonObject.getInt("id"));
                    step.setDescription(jsonObject.getString("description"));
                    step.setShortDescription(jsonObject.getString("shortDescription"));
                    step.setThumbnailURL(jsonObject.getString("thumbnailURL"));
                    step.setVideoURL(jsonObject.getString("videoURL"));
                    steps.add(step);
                }
                recipe.setSteps(steps);
                list.add(recipe);
            }

        } catch (JSONException e) {
            Log.e("Exception: ", e.getMessage());
        }

        return list;
    }
}
