package com.design.patterns.vehicle;

public class HondaActiva implements Vehicle{
    @Override
    public void assemble() {
        addWheels();
        paint();
        System.out.println("Honda activa created..!!");
    }

    @Override
    public void addWheels() {
        System.out.println("2 wheels added.!!");
    }

    @Override
    public void paint() {
        System.out.println("Painted the activa 'White'..!!");
    }
}
