package com.baking.mirela.bakingapp.ui;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.model.Ingredient;

import java.util.ArrayList;

/**
 * Created by mirela on 4/6/2017.
 */

public class IngrediensFragment extends Fragment {


    ArrayList<Ingredient> ingredience;
    TextView list;

    public IngrediensFragment() {
    }

    public void setRecipe(ArrayList<Ingredient> ingredience) {
        this.ingredience = ingredience;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ingredients, container, false);

        list = (TextView)rootView.findViewById(R.id.textView);
        String items ="";
        for(int i=0; i< ingredience.size(); i++){
            items += ingredience.get(i).getIngredient() + ": " + ingredience.get(i).getQuantity() + ingredience.get(i).getMeasure() + "\n\n";
        }
        list.setText(items);

        return rootView;
    }
}
