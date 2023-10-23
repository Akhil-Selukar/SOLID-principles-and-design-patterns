package com.design.patterns.builder;

import com.design.patterns.ingredients.CheeseType;
import com.design.patterns.ingredients.SauceType;
import com.design.patterns.ingredients.PizzaType;
import com.design.patterns.pizzabox.BoxLabel;
import com.design.patterns.pizzabox.PizzaBox;

public class PizzaBoxBuilder implements Builder {
    private PizzaType pizzaType;
    private CheeseType cheeseType;
    private SauceType sauceType;
    private String toppings;
    private String addOn;

    StringBuilder builder = new StringBuilder();

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
        builder.append("Onions, ");
    }

    @Override
    public void setTomatoTopping() {
        builder.append("Tomato, ");
    }

    @Override
    public void setCapsicumTopping() {
        builder.append("Capsicum, ");
    }

    @Override
    public void setExtraCheese(boolean isAdded) {
        this.addOn = "Extra cheese.";
    }

    public PizzaBox getPizzaBox(){
        BoxLabel label = new BoxLabel();
        label.setPizzaType(pizzaType);
        label.setSauceType(sauceType);
        label.setCheeseType(cheeseType);
        label.setToppings(builder.toString());
        label.setAddOn(addOn);
        return new PizzaBox(label);
    }
}
