package com.baking.mirela.bakingapp.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mirela on 29/5/2017.
 */

public class Recipe implements Serializable{
    private int id;
    private String name;
    private ArrayList<Ingredient> ingredience;
    private ArrayList<Steps> steps;
    private String servings;
    private String image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredience() {
        return ingredience;
    }

    public ArrayList<Steps> getSteps() {
        return steps;
    }

    public String getServings() {
        return servings;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredient(ArrayList<Ingredient> ingredience) {
        this.ingredience = ingredience;
    }

    public void setSteps(ArrayList<Steps> steps) {
        this.steps = steps;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
