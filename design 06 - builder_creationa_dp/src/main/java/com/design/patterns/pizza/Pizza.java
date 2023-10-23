package com.design.patterns.pizza;

import com.design.patterns.ingredients.CheeseType;
import com.design.patterns.ingredients.PizzaType;
import com.design.patterns.ingredients.SauceType;

public class Pizza {
    private PizzaType pizzaType;
    private SauceType sauceType;
    private CheeseType cheeseType;
    private String onionTopping;
    private String tomatoTopping;
    private String capsicumTopping;
    private String extraCheese;

    public Pizza(PizzaType pizzaType, SauceType sauceType, CheeseType cheeseType, String onionTopping,
                 String tomatoTopping, String capsicumTopping, String extraCheese) {
        this.pizzaType = pizzaType;
        this.sauceType = sauceType;
        this.cheeseType = cheeseType;
        this.onionTopping = onionTopping;
        this.tomatoTopping = tomatoTopping;
        this.capsicumTopping = capsicumTopping;
        this.extraCheese = extraCheese;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaType=" + pizzaType +
                ", sauceType=" + sauceType +
                ", cheeseType=" + cheeseType +
                ", onionTopping='" + onionTopping + '\'' +
                ", tomatoTopping='" + tomatoTopping + '\'' +
                ", capsicumTopping='" + capsicumTopping + '\'' +
                ", extraCheese='" + extraCheese + '\'' +
                '}';
    }
}
