package com.lld.structural.DecoratorPattern.Decorator;

import com.lld.structural.DecoratorPattern.BasePizza;

public abstract class ToppingsDecorator extends BasePizza {
    public abstract int cost();
}