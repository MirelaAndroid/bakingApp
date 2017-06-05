package com.baking.mirela.bakingapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.parser.JsonParser;
import com.baking.mirela.bakingapp.ui.MainFragment;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private boolean mTwoPane;
    public AppCompatActivity appCompatActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appCompatActivity = this;
        new FetchRecipesAsyncTask().execute("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
    }



    public class FetchRecipesAsyncTask extends AsyncTask<String, Void, ArrayList<Recipe>> {


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
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,fragment).commit();
        }
    }

}
