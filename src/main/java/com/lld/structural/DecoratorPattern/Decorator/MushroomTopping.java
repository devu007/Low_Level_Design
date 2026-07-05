package com.lld.structural.DecoratorPattern.Decorator;

import com.lld.structural.DecoratorPattern.BasePizza;

public class MushroomTopping extends ToppingsDecorator {
    private BasePizza basePizza;

    public MushroomTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 15;
    }
}