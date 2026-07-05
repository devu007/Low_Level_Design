package com.lld.behavioral.StrategyPattern;

import com.lld.behavioral.StrategyPattern.Strategy.SportsDriveStrategy;

public class main {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();
    }
}