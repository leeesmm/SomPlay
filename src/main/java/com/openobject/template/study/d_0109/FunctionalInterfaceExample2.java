package com.openobject.template.study.d_0109;

import java.math.BigDecimal;

public class FunctionalInterfaceExample2 {

	public static void main(String[] args) {
		println(1, 2, 3, (i1, i2, i3) -> (i1 + i2 + i3) + "");
		println("area is ", 12, 20, (message, lenth, width) -> message + (lenth * width));

		BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
		System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));
		
		final invalidFunctionalInterface invalidFunctionalInterface = new invalidFunctionalInterface() {
			@Override
			public <T> String mkString(T value) {
				return value.toString();
			}
		};
		
		// Illegal lambda expression: Method mkString of type invalidFunctionalInterface is generic 
//		final invalidFunctionalInterface invalidFunctionalInterface2 = (value) -> value.toString(); 
	}
	
	private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
		System.out.println(function.apply(t1, t2, t3));
	}
}

@FunctionalInterface
interface Function3<T1, T2, T3, R> {
	R apply(T1 t1, T2 t2, T3 t3); // abstract method only one
}

@FunctionalInterface
interface BigDecimalToCurrency {
	String toCurrency(BigDecimal bigDecimal);
}

@FunctionalInterface
interface invalidFunctionalInterface {
	<T> String mkString(T value);
}
