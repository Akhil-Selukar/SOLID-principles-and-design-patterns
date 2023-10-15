package com.solid.principles.animals;

public class Fish implements AquaticAnimalActions{

    @Override
    public String eat() {
        return "Fish is eating her food!";
    }

    @Override
    public String swim() {
        return "The fish is swimming really fast!";
    }
}
