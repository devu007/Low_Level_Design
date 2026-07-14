package com.lld.structural.AdapterPattern;

public class SmartLight {
    public void connectWithBluetooth() {
        System.out.println("SmartLight connected with Bluetooth");
    }

    public void connectWithWifi() {
        System.out.println("SmartLight connected with Wifi");
    }

    public void switchOn() {
        System.out.println("SmartLight switched on");
    }

    public void switchOff() {
        System.out.println("SmartLight switched off");
    }

    public void disconnectFromBluetooth() {
        System.out.println("SmartLight disconnected from Bluetooth");
    }

    public void disconnectFromWifi() {
        System.out.println("SmartLight disconnected from Wifi");
    }
}
