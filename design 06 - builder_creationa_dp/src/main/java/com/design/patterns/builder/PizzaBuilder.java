package com.design.patterns.builder;

import com.design.patterns.ingredients.CheeseType;
import com.design.patterns.ingredients.SauceType;
import com.design.patterns.pizza.Pizza;
import com.design.patterns.ingredients.PizzaType;

public class PizzaBuilder implements Builder{
    private PizzaType pizzaType;
    private SauceType sauceType;
    private CheeseType cheeseType;
    private String onionTopping;
    private String tomatoTopping;
    private String capsicumTopping;
    private String extraCheese;

    @Override
    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    @Override
    public void setSauces(SauceType sauce) {
        this.sauceType = sauce;
    }

    @Override
    public void setCheese(CheeseType cheese) {
        this.cheeseType = cheese;
    }

    @Override
    public void setOnionTopping() {
        this.onionTopping = "5 onion slices.";
    }

    @Override
    public void setTomatoTopping() {
        this.tomatoTopping = "3 Tomato slices.";
    }

    @Override
    public void setCapsicumTopping() {
        this.capsicumTopping = "3 capsicum slices.";
    }

    @Override
    public void setExtraCheese(boolean isAdded) {
        this.extraCheese = isAdded? "Add extra cheese." : "No extra cheese.";
    }

    public Pizza getPizza(){
        return new Pizza(pizzaType, sauceType, cheeseType, onionTopping, tomatoTopping, capsicumTopping, extraCheese);
    }
}
