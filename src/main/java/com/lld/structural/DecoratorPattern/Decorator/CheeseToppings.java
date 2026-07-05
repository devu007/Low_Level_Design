package com.lld.structural.DecoratorPattern.Decorator;

import com.lld.structural.DecoratorPattern.BasePizza;

public class CheeseToppings extends ToppingsDecorator {
    private BasePizza basePizza;

    public CheeseToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}