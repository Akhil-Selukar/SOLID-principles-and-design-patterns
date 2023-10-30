package com.design.patterns.vehicle;

public class TeslaModelX implements Vehicle{
    @Override
    public void assemble() {
        addWheels();
        paint();
        System.out.println("Tesla modleX is ready..!!");
    }

    @Override
    public void addWheels() {
        System.out.println("4 wheels added to modelX..!!");
    }

    @Override
    public void paint() {
        System.out.println("ModelX painted 'Red'..!!");
    }
}
