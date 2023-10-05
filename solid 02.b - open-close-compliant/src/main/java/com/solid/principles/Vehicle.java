package com.solid.principles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Vehicle {
    private String engineType;
    private int seatingCapacity;
    private int numberOfWheels;
    private double exShowroomPrice;

    public abstract double calculateOnRoadPrice();
}
