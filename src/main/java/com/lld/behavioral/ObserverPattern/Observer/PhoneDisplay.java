package com.lld.behavioral.ObserverPattern.Observer;

import com.lld.behavioral.ObserverPattern.WeatherData;

public class PhoneDisplay implements Observer {
    private WeatherData weatherData;
    private float temperature;
    private float humidity;

    public PhoneDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    public void update(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void update(String message) {
        System.out.println("Phone display: " + message);
    }

    public void display() {
        System.out.println("Phone display: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
