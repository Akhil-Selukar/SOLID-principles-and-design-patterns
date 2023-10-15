package com.solid.principles.animals;

public class Fish implements Action{
    @Override
    public String walk() {
        throw new UnsupportedOperationException("This operation is not supported by fish.");
    }

    @Override
    public String makeSound() {
        throw new UnsupportedOperationException("This operation is not supported by fat.");
    }

    @Override
    public String eat() {
        return "Fish is eating her food!";
    }

    @Override
    public String swim() {
        return "The fish is swimming really fast!";
    }
}
