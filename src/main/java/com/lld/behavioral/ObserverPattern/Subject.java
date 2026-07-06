package com.lld.behavioral.ObserverPattern;

import java.util.List;
import java.util.ArrayList;
import com.lld.behavioral.ObserverPattern.Observer.Observer;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void notifyObservers(WeatherData weatherData) {
        for (Observer observer : observers) {
            observer.update(weatherData);
        }
    }
}
