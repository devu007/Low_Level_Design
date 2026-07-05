package com.lld.behavioral.StrategyPattern;

import com.lld.behavioral.StrategyPattern.Strategy.DriveStrategy;

public class Vehicle{
    DriveStrategy driveStrategyObject;

    public Vehicle(DriveStrategy driveStrategyObject) {
        this.driveStrategyObject = driveStrategyObject;
    }

    public void drive() {
        driveStrategyObject.drive();
    }
}