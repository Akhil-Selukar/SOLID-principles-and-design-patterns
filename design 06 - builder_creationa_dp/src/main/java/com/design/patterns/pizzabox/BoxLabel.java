package com.design.patterns.pizzabox;

import com.design.patterns.ingredients.CheeseType;
import com.design.patterns.ingredients.PizzaType;
import com.design.patterns.ingredients.SauceType;

public class BoxLabel {
    private PizzaType pizzaType;
    private CheeseType cheeseType;
    private SauceType sauceType;
    private String toppings;
    private String addOn;

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    public void setSauceType(SauceType sauceType) {
        this.sauceType = sauceType;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    @Override
    public String toString() {
        return "BoxLabel{" +
                "pizzaType=" + pizzaType +
                ", sauceType=" + sauceType +
                ", cheeseType=" + cheeseType +
                ", toppings='" + toppings + '\'' +
                ", addOn='" + addOn + '\'' +
                '}';
    }
}
