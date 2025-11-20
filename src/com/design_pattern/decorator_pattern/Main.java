package com.design_pattern.decorator_pattern;

//Step 5: Client Code
public class Main {
 public static void main(String[] args) {
     Coffee coffee = new SimpleCoffee();
     System.out.println(coffee.getDescription() + " $" + coffee.getCost());

     // Add Milk
     coffee = new MilkDecorator(coffee);
     System.out.println(coffee.getDescription() + " $" + coffee.getCost());

     // Add Sugar
     coffee = new SugarDecorator(coffee);
     System.out.println(coffee.getDescription() + " $" + coffee.getCost());
 }
}