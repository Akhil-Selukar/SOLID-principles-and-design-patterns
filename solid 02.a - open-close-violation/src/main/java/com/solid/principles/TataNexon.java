package com.solid.principles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TataNexon {
    private String engineType;
    private int seatingCapacity;
    private int numberOfWheels;
    private double exShowroomPrice;

    public double calculateOnRoadPrice(){
        double gst = exShowroomPrice * 0.18;
        double roadTax = exShowroomPrice * 0.1;
        int rtoFees = 120000;
        return exShowroomPrice + gst + roadTax + rtoFees;
    }
}
