package com.lld.behavioral.StrategyPattern.Strategy;

public class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving sports");
    }
}
