package com.design_pattern.decorator_pattern;

//Step 3: Decorator Abstract Class
abstract class CoffeeDecorator implements Coffee {

	protected Coffee decoratedCoffee;

	public CoffeeDecorator(Coffee coffee) {
		this.decoratedCoffee = coffee;
	}

	@Override
	public String getDescription() {
		return decoratedCoffee.getDescription();
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost();
	}
}
