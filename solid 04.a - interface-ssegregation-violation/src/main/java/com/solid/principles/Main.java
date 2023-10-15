package com.solid.principles;

import com.solid.principles.animals.Cat;
import com.solid.principles.animals.Fish;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Fish fish = new Fish();

        System.out.println(cat.walk());
        System.out.println(fish.eat());
    }
}