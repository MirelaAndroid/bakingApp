package com.baking.mirela.bakingapp.activity.mvp.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.baking.mirela.bakingapp.R
import com.baking.mirela.bakingapp.asyncTask.FetchRecipesAsyncTask

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FetchRecipesAsyncTask(this).execute("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json")
    }
}
