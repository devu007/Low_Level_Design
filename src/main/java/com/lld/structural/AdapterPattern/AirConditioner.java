package com.lld.structural.AdapterPattern;

public class AirConditioner {
    public void connectWithBluetooth() {
        System.out.println("AirConditioner connected with Bluetooth");
    }

    public void connectWithWifi() {
        System.out.println("AirConditioner connected with Wifi");
    }

    public void startCooling() {
        System.out.println("AirConditioner started cooling");
    }

    public void stopCooling() {
        System.out.println("AirConditioner stopped cooling");
    }

    public void disconnectFromBluetooth() {
        System.out.println("AirConditioner disconnected from Bluetooth");
    }

    public void disconnectFromWifi() {
        System.out.println("AirConditioner disconnected from Wifi");
    }
}
