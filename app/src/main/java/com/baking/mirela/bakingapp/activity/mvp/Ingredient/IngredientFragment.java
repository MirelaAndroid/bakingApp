package com.baking.mirela.bakingapp.activity.mvp.Ingredient;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.model.Ingredient;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mirela on 4/6/2017.
 */

public class IngredientFragment extends Fragment {


    @BindView(R.id.textView) TextView list;

    public IngredientPresenterImpl presenter = new IngredientPresenterImpl();

    public IngredientFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ButterKnife.bind(this, rootView);


        list.setText(presenter.displayIngredients());

        return rootView;
    }
}
