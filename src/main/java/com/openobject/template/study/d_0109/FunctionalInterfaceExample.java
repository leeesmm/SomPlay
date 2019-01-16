package com.openobject.template.study.d_0109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		
		// Function
		/*
		Function<String, Integer> toInt = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		*/
		
		Function<String, Integer> toInt = (value) -> Integer.parseInt(value);
		final Integer number = toInt.apply("2222");		
		System.out.println(number);
		
		final Function<Integer, Integer> identity = Function.identity();
		System.out.println(identity.apply(100));
		
		// Consumer 
		final Consumer<String> print = value -> System.out.println(value);
		final Consumer<String> grettings = value -> System.out.println("hello " + value);
		
		print.accept("hello");
		grettings.accept("somi");
		
		// Predicate --> Function<T, Boolean>
		// 조건 만족에 많이 쓰임
		final Predicate<Integer> isPositive = i -> i > 0;
		System.out.println(isPositive.test(-3));
		System.out.println(isPositive.test(2));
		
		List<Integer> numbers = Arrays.asList(-1, 3, 5, 6, 0, -4);
		
		List<Integer> positiveNumbers = new ArrayList<>();
		for(Integer num : numbers) {
			if ( isPositive.test(num) ) {
				positiveNumbers.add(num);
			}
		}
		
		System.out.println(positiveNumbers);
		
		final Predicate<Integer> lessThon3 = i -> i < 3;
		List<Integer> lessThon3Numbers = new ArrayList<>();
		for(Integer num : numbers) {
			if ( lessThon3.test(num) ) {
				lessThon3Numbers.add(num);
			}
		}
		
		System.out.println(lessThon3Numbers);
		
		System.out.println(filter(numbers, isPositive));
		System.out.println(filter(numbers, lessThon3));
		
		// Supplier
		final Supplier<String> hello = () -> "hello";
		System.out.println(hello.get() + "world");
		
		long start = System.currentTimeMillis();
		
//		printInvalidIndex(0, getVeryExpensiveValue());
//		printInvalidIndex(-2, getVeryExpensiveValue());
//		printInvalidIndex(-3, getVeryExpensiveValue());
		printInvalidIndex(0, () -> getVeryExpensiveValue());
		printInvalidIndex(-2, () -> getVeryExpensiveValue());
		printInvalidIndex(-3, () -> getVeryExpensiveValue());
		
		System.out.println("It took " + (System.currentTimeMillis() - start) / 1000 + " seconds.");
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
		List<T> result = new ArrayList<>();
		for(T input : list) {
			if ( filter.test(input) ) {
				result.add(input);
			}
		}
		return result;
	}
	
//	private static void printInvalidIndex(int number, String value) {
	private static void printInvalidIndex(int number, Supplier<String> valueSupplier) {
		if ( number >= 0 ) {
			System.out.println("The value is " + valueSupplier.get() + ".");
		} else {
			System.out.println("Invalid");
		}
	}
	
	private static String getVeryExpensiveValue() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Let's just say it has very expensive calculation here!
		return "somi";
	}
}

