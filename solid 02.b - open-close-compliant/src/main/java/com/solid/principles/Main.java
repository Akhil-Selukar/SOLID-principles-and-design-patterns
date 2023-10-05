package com.solid.principles;

public class Main {
    public static void main(String[] args) {
        TataNexon tataNexon = new TataNexon();
        tataNexon.setEngineType("1.5L 4-Cylinder");
        tataNexon.setNumberOfWheels(4);
        tataNexon.setSeatingCapacity(5);
        tataNexon.setExShowroomPrice(1200000.00);
        HondaActiva hondaActiva = new HondaActiva();
        hondaActiva.setEngineType("124 CC Air-Cooled");
        hondaActiva.setNumberOfWheels(2);
        hondaActiva.setSeatingCapacity(2);
        hondaActiva.setExShowroomPrice(82000.00);
        System.out.println("Details for Tata Nexon - "+tataNexon.toString());
        System.out.println("OnRoad price for Tata Nexon - " + tataNexon.calculateOnRoadPrice());
        System.out.println("Details for Honda Activa - "+hondaActiva.toString());
        System.out.println("OnRoad price for Honda Activa - " + hondaActiva.calculateOnRoadPrice());
    }
}