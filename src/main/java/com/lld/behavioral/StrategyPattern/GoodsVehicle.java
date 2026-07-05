package com.lld.behavioral.StrategyPattern;

import com.lld.behavioral.StrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}