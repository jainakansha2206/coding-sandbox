package com.design_pattern.strategy;

public class MultiplyOperation implements Strategy{

	@Override
	public Integer doOperation(int num1, int num2) {
		
		return num1*num2;
	}

}
