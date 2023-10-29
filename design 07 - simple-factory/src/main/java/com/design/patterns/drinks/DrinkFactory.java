package com.design.patterns.drinks;

public class DrinkFactory {
    public static Drink generateDrink(String type){
        switch(type){
            case "CocaCola":
                return new CocaCola("Dark Brown", true, "Sweet", "CocaCola", 35.00F);
            case "Sprite":
                return new Sprite("Colorless", true, "Sweet", "Sprite", 32.50F);
            case "OrangeJuice":
                return new OrangeJuice("Orange", false, "Sweet", "Slice", 30.00F);
            default:
                throw new IllegalArgumentException("Unknown drink type.");
        }
    }
}
