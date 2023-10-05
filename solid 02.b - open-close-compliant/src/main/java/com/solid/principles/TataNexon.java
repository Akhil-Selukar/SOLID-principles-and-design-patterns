package com.solid.principles;

public class TataNexon extends Vehicle{
    @Override
    public double calculateOnRoadPrice(){
        double gst = getExShowroomPrice() * 0.18;
        double roadTax = getExShowroomPrice() * 0.1;
        int rtoFees = 120000;
        return getExShowroomPrice() + gst + roadTax + rtoFees;
    }
}
