package com.baking.mirela.bakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.parser.JsonParser;
import com.baking.mirela.bakingapp.ui.DetailRecipeFragment;
import com.baking.mirela.bakingapp.ui.MainFragment;

import java.util.ArrayList;

/**
 * Created by mirela on 4/6/2017.
 */

public class DetailActivity extends AppCompatActivity {


    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailRecipeFragment fragment = new DetailRecipeFragment();

        fragment.setActivity(this);
        fragment.setRecipe(GlobalValues.getRecipe().get(getIntent().getExtras().getInt("position")));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();

    }

}
