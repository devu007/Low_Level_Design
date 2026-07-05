package com.lld.structural.DecoratorPattern;

import com.lld.structural.DecoratorPattern.Decorator.CheeseToppings;
import com.lld.structural.DecoratorPattern.Decorator.MushroomTopping;

public class main {
    public static void main(String[] args) {
        BasePizza pizza = new VeggiePizza();
        pizza = new CheeseToppings(pizza);
        pizza = new MushroomTopping(pizza);
        System.out.println(pizza.cost());
    }
}