package com.lld.structural.AdapterPattern;

public class SmartLightAdapter implements SmartDevices {
    private SmartLight smartLight;

    public SmartLightAdapter(SmartLight smartLight) {
        this.smartLight = smartLight;
    }

    @Override
    public void turnOn() {
        smartLight.connectWithBluetooth();
        smartLight.switchOn();
    }

    @Override
    public void turnOff() {
        smartLight.disconnectFromBluetooth();
        smartLight.switchOff();
    }
}
