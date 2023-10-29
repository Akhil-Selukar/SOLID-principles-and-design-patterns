package com.design.patterns;

import com.design.patterns.drinks.Drink;
import com.design.patterns.drinks.DrinkFactory;

public class Main {
    public static void main(String[] args) {
        Drink drink1 = DrinkFactory.generateDrink("Sprite");
        System.out.println("Drink 1 - " + drink1);

        Drink drink2 = DrinkFactory.generateDrink("OrangeJuice");
        System.out.println("Drink 2 - " + drink2);
    }
}