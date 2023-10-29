package com.design.patterns.drinks;

public abstract class Drink {
    private String color;
    private boolean isCarbonated;
    private String taste;

    public Drink(String color, boolean isCarbonated, String taste) {
        this.color = color;
        this.isCarbonated = isCarbonated;
        this.taste = taste;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCarbonated() {
        return isCarbonated;
    }

    public void setCarbonated(boolean carbonated) {
        isCarbonated = carbonated;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
