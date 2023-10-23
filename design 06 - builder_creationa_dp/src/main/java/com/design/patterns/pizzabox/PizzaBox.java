package com.design.patterns.pizzabox;

public class PizzaBox {
    private BoxLabel boxLabel;

    public PizzaBox(BoxLabel boxLabel) {
        this.boxLabel = boxLabel;
    }

    public BoxLabel getBoxLabel() {
        return boxLabel;
    }
}
