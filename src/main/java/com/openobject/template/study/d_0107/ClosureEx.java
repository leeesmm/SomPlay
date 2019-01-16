package com.openobject.template.study.d_0107;

import java.util.function.Function;

public class ClosureEx {

	public static void test()  {
		int number = 100;
		
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(number);
			}
		};
		
		run.run();
		
		Runnable run2 = () -> System.out.println(number);
		run2.run();
		
		Function<Integer, Integer> func = i -> i * 2;
		System.out.println(func.apply(2));
//		Function<Integer, Integer> func2 = new Function<Integer, Integer>() {
//			
//			@Override
//			public Integer apply(Integer t) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
	}
	
	public static void main(String[] args) {
		test();
	}
}
