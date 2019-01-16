package com.openobject.template.study.d_0114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;
public class StreamExamples2 {

	public static void main(String[] args) {
		Stream.of(1,2,3,4,5)
			  .forEach(i -> System.out.println(i + " "));
		
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer result = null;
		for (final Integer number : numbers) {
			if (number > 3 && number < 9) {
				final Integer nuwNumber = number * 2;
				
				if (nuwNumber > 10) {
					result = nuwNumber;	
					break;
				}
				
			}
		}
	
		System.out.println("Imperative Result : " + result);
		System.out.println("Functional Result : " +
			numbers.stream()
				   .filter(number -> number > 3)
				   .filter(number -> number < 9)
				   .map(number -> number * 2)
				   .filter(number -> number > 10)
				   .findFirst()
		);
		// Functional Result : Optional[12]
		
		
//		System.out.println("Functional Result : " +
//				numbers.stream()
//					   .filter(number -> { 
//						   System.out.println("number > 3");
//						   return number > 3; })
//					   .filter(number -> { 
//						   System.out.println("number < 9");
//						   return number < 9; })
//					   .map(number -> { 
//						   System.out.println("number * 2");
//						   return number * 2; })
//					   .filter(number -> { 
//						   System.out.println("number > 10");
//						   return number > 10; })
//					   .findFirst()
//		);
		
		// Stream? 
		// 컬렉션 빌더(게으른?)
		// 하라고 그랬는데 안하고 있다가 마지막에 수행함
		
//		final AtomicInteger count = new AtomicInteger(1);
//		
//		final List<Integer> greaterThan3 = filter(numbers, i ->  { 
//			System.out.println(count.getAndAdd(1) + ": i > 3");
//			return i > 3;});
//		final List<Integer> lessThan9 = filter(greaterThan3, i ->  { 
//			System.out.println(count.getAndAdd(1) + ": i < 9");
//			return i < 9;});
//		final List<Integer> doubled = map(lessThan9, i -> { 
//			System.out.println(count.getAndAdd(1) + ": i * 2");
//			return i * 2;});
//		final List<Integer> greaterThan10 = filter(doubled, i -> { 
//			System.out.println(count.getAndAdd(1) + ": i > 1");
//			return i > 10;});
//		System.out.println("My own method result : " + greaterThan10.get(0));
		// count : 15
		
		
		final List<Integer> greaterThan3 = filter(numbers, i -> i > 3);
		final List<Integer> lessThan9 = filter(greaterThan3, i -> i <9);
		final List<Integer> doubled = map(lessThan9, i -> i * 2);
		final List<Integer> greaterThan10 = filter(doubled, i -> i > 10);
		
		System.out.println("My own method result : " + greaterThan10);
		System.out.println("My own method result.get(0) : " + greaterThan10.get(0));

		final List<Integer> myOwnMethodResult = filter(map(filter
				(filter(numbers, i -> i > 3), i -> i <9), i -> i * 2), i -> i > 10);
		
		System.out.println("My own method result : " + myOwnMethodResult);
		System.out.println("My own method result.get(0) : " + myOwnMethodResult.get(0));
	}
	
	private static<T> List<T> filter(List<T> list, Predicate<T> predicate) {
		final List<T> result = new ArrayList<>();
		for(final T t: list) {
			if (predicate.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	private static<T,R> List<R> map(List<T> list, Function<T, R> mapper) {
		final List<R> result = new ArrayList<>();
		for(final T t: list) {
			result.add(mapper.apply(t));
		}
		
		return result;
	}
	
}
