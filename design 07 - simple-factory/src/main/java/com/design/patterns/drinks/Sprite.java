package com.design.patterns.drinks;

public class Sprite extends Drink{
    private String name;
    private float price;

    public Sprite(String color, boolean isCarbonated, String taste, String name, float price) {
        super(color, isCarbonated, taste);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
