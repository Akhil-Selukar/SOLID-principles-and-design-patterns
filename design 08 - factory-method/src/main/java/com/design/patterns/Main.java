package com.design.patterns;

import com.design.patterns.factory.HondaActivaFactory;
import com.design.patterns.factory.TeslaModelXFactory;
import com.design.patterns.factory.VehicleFactory;

public class Main {
    private static VehicleFactory factory;

    public static void main(String[] args) {
        factory = configureFactory("Honda");
        factory.create();

        System.out.println("====================");

        factory = configureFactory("Tesla");
        factory.create();
    }

    private static VehicleFactory configureFactory(String company) {
        switch(company){
            case "Honda":
                return new HondaActivaFactory();
            default:
                return new TeslaModelXFactory();
        }
    }
}