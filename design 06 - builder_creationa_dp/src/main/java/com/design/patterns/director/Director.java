package com.design.patterns.director;

import com.design.patterns.builder.Builder;
import com.design.patterns.ingredients.CheeseType;
import com.design.patterns.ingredients.PizzaType;
import com.design.patterns.ingredients.SauceType;

public class Director {
    public void constructMargheritaPizza(Builder builder){
        builder.setPizzaType(PizzaType.REGULAR);
        builder.setSauces(SauceType.REGULAR_PIZZA_SAUCE);
        builder.setCheese(CheeseType.MOZZARELLA_CHEESE);
        builder.setExtraCheese(true);
    }

    public void constructVegLoadedPizza(Builder builder){
        builder.setPizzaType(PizzaType.THIN_CRUST);
        builder.setSauces(SauceType.HOT_SPICY_SAUCE);
        builder.setCheese(CheeseType.SLICED_CHEESE);
        builder.setOnionTopping();
        builder.setTomatoTopping();
        builder.setCapsicumTopping();
    }

    public void constructOnionPizza(Builder builder){
        builder.setPizzaType(PizzaType.CHEESE_BURST);
        builder.setSauces(SauceType.FRESH_PIZZA_SAUCE);
        builder.setCheese(CheeseType.SALTED_CHEESE);
        builder.setOnionTopping();
    }
}
