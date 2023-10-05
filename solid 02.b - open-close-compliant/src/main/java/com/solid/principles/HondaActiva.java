package com.solid.principles;

public class HondaActiva extends Vehicle{
    @Override
    public double calculateOnRoadPrice(){
        double gst = getExShowroomPrice() * 0.18;
        double roadTax = getExShowroomPrice() * 0.05;
        int rtoFees = 5000;
        return getExShowroomPrice() + gst + roadTax + rtoFees;
    }
}
