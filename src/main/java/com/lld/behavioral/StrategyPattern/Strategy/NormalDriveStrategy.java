package com.lld.behavioral.StrategyPattern.Strategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving normally");
    }
}