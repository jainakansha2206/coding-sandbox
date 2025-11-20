package com.design_pattern.decorator_pattern;

public class SugarDecorator extends CoffeeDecorator {

	public SugarDecorator(Coffee coffee) {
		super(coffee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return decoratedCoffee.getDescription() + ", Sugar";
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost() + 0.5;
	}

}
