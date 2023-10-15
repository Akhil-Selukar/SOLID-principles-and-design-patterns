package com.solid.principles.animals;

public class Cat implements TerrestrialAnimalActions{

    @Override
    public String walk() {
        return "Look, that cat is walking!";
    }

    @Override
    public String makeSound() {
        return "Cat is saying Meow!";
    }

    @Override
    public String eat() {
        return "Cat is eating her food!";
    }

}
