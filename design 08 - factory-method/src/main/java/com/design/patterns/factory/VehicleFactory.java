package com.design.patterns.factory;

import com.design.patterns.vehicle.Vehicle;

public abstract class VehicleFactory {
    public Vehicle create(){
        Vehicle vehicle = manufactureVehicle();
        vehicle.assemble();
        return vehicle;
    }

    protected abstract Vehicle manufactureVehicle();
}
