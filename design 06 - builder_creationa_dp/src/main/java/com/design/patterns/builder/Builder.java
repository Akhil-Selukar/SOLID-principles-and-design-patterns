package com.design.patterns.builder;

import com.design.patterns.ingredients.CheeseType;
import com.design.patterns.ingredients.SauceType;
import com.design.patterns.ingredients.PizzaType;

public interface Builder {
    void setPizzaType(PizzaType pizzaType);
    void setSauces(SauceType sauce);
    void setCheese(CheeseType cheese);
    void setOnionTopping();
    void setTomatoTopping();
    void setCapsicumTopping();
    void setExtraCheese(boolean isAdded);
}
