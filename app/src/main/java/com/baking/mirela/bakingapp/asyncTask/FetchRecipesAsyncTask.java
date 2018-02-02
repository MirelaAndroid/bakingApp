package com.baking.mirela.bakingapp.asyncTask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.NetworkUtil;
import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.parser.JsonParser;
import com.baking.mirela.bakingapp.ui.MainFragment;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mirela on 26/10/2017.
 */

public class FetchRecipesAsyncTask extends AsyncTask<String, Void, ArrayList<Recipe>> {


    public AppCompatActivity appCompatActivity;

    public FetchRecipesAsyncTask(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Recipe> doInBackground(String... params) {
        if (params.length == 0) {
            return null;
        }

        String location = params[0];
        URL movieRequestUrl = NetworkUtil.buildUrl(location);

        try {
            String jsonWeatherResponse = NetworkUtil
                    .getResponseFromHttpUrl(movieRequestUrl);

            return JsonParser.parseRecipes(jsonWeatherResponse);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<Recipe> list) {
        super.onPostExecute(list);
        MainFragment fragment = new MainFragment();
        fragment.setActivity(appCompatActivity);
        fragment.setList(list);
        GlobalValues.getRecipe(list);
        appCompatActivity.getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,fragment).commit();
    }
}
