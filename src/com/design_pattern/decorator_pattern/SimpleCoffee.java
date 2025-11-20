package com.design_pattern.decorator_pattern;

//Step 2: Concrete Component
public class SimpleCoffee implements Coffee{

	@Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
