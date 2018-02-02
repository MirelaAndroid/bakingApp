package com.baking.mirela.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baking.mirela.bakingapp.asyncTask.FetchRecipesAsyncTask;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FetchRecipesAsyncTask(this).execute("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
    }
}
