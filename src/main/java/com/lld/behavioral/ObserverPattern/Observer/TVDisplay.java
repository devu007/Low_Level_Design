package com.lld.behavioral.ObserverPattern.Observer;

import com.lld.behavioral.ObserverPattern.WeatherData;

public class TVDisplay implements Observer {
    private WeatherData weatherData;
    private float temperature;
    private float humidity;

    public TVDisplay(WeatherData weatherData) {
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
        System.out.println("TV display: " + message);
    }

    public void display() {
        System.out.println("TV display: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
