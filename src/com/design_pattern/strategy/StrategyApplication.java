package com.design_pattern.strategy;

public class StrategyApplication {

	public static void main(String[] args) {
		
		Context c1 = new Context(new AddOperation());
		System.out.println("10 + 5 :- "+c1.executeStrategy(10, 5));
		
		c1 = new Context(new SubOperation());
		System.out.println("10 - 5:- "+c1.executeStrategy(10, 5));
		
		c1 = new Context(new MultiplyOperation());
		System.out.println("10 * 5:- "+c1.executeStrategy(10, 5));
	}
}
