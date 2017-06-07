package com.baking.mirela.bakingapp.ui;


import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.baking.mirela.bakingapp.IngredientsWidget;
import com.baking.mirela.bakingapp.R;
import com.baking.mirela.bakingapp.GlobalValues;
import com.baking.mirela.bakingapp.model.Ingredient;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mirela on 4/6/2017.
 */

public class IngrediensFragment extends Fragment {


    @BindView(R.id.textView) TextView list;
    ArrayList<Ingredient> ingredience;

    public IngrediensFragment() {
    }

    public void setRecipe(ArrayList<Ingredient> ingredience) {
        GlobalValues.setIngredient(ingredience);
        this.ingredience = ingredience;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ButterKnife.bind(this, rootView);
        String items ="";

        if(ingredience == null) {
            ingredience = GlobalValues.getIngredient();
        }
        for(int i=0; i< ingredience.size(); i++){
            items += ingredience.get(i).getIngredient() + ": " + ingredience.get(i).getQuantity() + ingredience.get(i).getMeasure() + "\n\n";
        }
        GlobalValues.setIngredients(items);
        list.setText(items);

        ComponentName thisWidget = new ComponentName( getContext(), IngredientsWidget.class);


        RemoteViews views = new RemoteViews(getContext().getPackageName(), R.layout.ingredients_widget);
        ComponentName widget = new ComponentName( getContext(), IngredientsWidget.class );
        views.setTextViewText(R.id.appwidget_text, items);
        AppWidgetManager.getInstance( getContext() ).updateAppWidget( thisWidget, views );
        return rootView;
    }
}
