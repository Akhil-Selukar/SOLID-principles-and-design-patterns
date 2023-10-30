package com.design.patterns.factory;

import com.design.patterns.vehicle.HondaActiva;
import com.design.patterns.vehicle.Vehicle;

public class HondaActivaFactory extends VehicleFactory{
    @Override
    protected Vehicle manufactureVehicle() {
        return new HondaActiva();
    }
}
