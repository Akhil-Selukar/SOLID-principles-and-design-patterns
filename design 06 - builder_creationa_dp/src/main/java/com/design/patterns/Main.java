package com.design.patterns;

import com.design.patterns.builder.PizzaBoxBuilder;
import com.design.patterns.builder.PizzaBuilder;
import com.design.patterns.director.Director;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        director.constructVegLoadedPizza(pizzaBuilder);

        PizzaBoxBuilder boxBuilder = new PizzaBoxBuilder();
        director.constructVegLoadedPizza(boxBuilder);

        System.out.println("==>> Here is your pizza : " + pizzaBuilder.getPizza().toString());
        System.out.println("======================================================================");
        System.out.println("==>> Here is the label on pizza box : " + boxBuilder.getPizzaBox().getBoxLabel().toString());
    }
}