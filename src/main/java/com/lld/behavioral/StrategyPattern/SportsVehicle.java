package com.lld.behavioral.StrategyPattern;

import com.lld.behavioral.StrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}