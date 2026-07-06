package com.lld.behavioral.ObserverPattern.Observer;

import com.lld.behavioral.ObserverPattern.WeatherData;

public interface Observer {
    void update(String message);

    void update(WeatherData weatherData);
}
