package com.baking.mirela.bakingapp.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baking.mirela.bakingapp.NetworkUtil;
import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.adapter.RecipeAdapter;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.parser.JsonParser;

import java.net.URL;
import java.util.ArrayList;


/**
 * Created by mirela on 31/5/2017.
 */

public class MainFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<Recipe>  list;
    private AppCompatActivity appCompatActivity;

    public MainFragment() {
    }

    public void setActivity(AppCompatActivity activity){
        appCompatActivity = activity;

    }
    public void setList(ArrayList<Recipe> recipes) {
        list = recipes;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new RecipeAdapter(list, appCompatActivity);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;

    }

}
