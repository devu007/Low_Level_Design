package com.lld.structural.AdapterPattern;

public class AirConditionerAdapter implements SmartDevices {
    private AirConditioner airConditioner;

    public AirConditionerAdapter(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void turnOn() {
        airConditioner.connectWithBluetooth();
        airConditioner.startCooling();
    }

    @Override
    public void turnOff() {
        airConditioner.disconnectFromBluetooth();
        airConditioner.stopCooling();
    }
}
