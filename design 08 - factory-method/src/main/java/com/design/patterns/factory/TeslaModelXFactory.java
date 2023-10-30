package com.design.patterns.factory;

import com.design.patterns.vehicle.TeslaModelX;
import com.design.patterns.vehicle.Vehicle;

public class TeslaModelXFactory extends VehicleFactory{
    @Override
    protected Vehicle manufactureVehicle() {
        return new TeslaModelX();
    }
}
