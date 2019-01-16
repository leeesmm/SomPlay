package com.openobject.template.study.d_0109;

public class OOP {
}

interface Calculation {
	int calculate(int num1, int num2);
}

class Addition implements Calculation {
	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
}

class Subtration implements Calculation {
	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
}
