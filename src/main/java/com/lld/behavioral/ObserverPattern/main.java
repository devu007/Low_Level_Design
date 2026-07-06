package com.lld.behavioral.ObserverPattern;

import com.lld.behavioral.ObserverPattern.Observer.PhoneDisplay;
import com.lld.behavioral.ObserverPattern.Observer.TVDisplay;

public class main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherData);
        TVDisplay tvDisplay = new TVDisplay(weatherData);
        weatherData.setMeasurements(84, 60, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(80, 90, 29.2f);
        phoneDisplay.display();
        tvDisplay.display();
    }
}
