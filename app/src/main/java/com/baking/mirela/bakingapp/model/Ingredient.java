package com.baking.mirela.bakingapp.model;

import java.io.Serializable;

/**
 * Created by mirela on 29/5/2017.
 */

public class Ingredient implements Serializable {
    private String quantity;
    private String measure;
    private String ingredient;

    public String getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
