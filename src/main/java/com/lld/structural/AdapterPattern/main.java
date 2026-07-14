package com.lld.structural.AdapterPattern;

public class main {
    public static void main(String[] args) {
        SmartDevices airConditioner = new AirConditionerAdapter(new AirConditioner());
        airConditioner.turnOn();
        airConditioner.turnOff();

        SmartDevices smartLight = new SmartLightAdapter(new SmartLight());
        smartLight.turnOn();
        smartLight.turnOff();
    }
}
