package com.solid.principles.animals;

public class Cat implements Action{

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

    @Override
    public String swim() {
        throw new UnsupportedOperationException("This operation is not supported by Cat.");
    }
}
