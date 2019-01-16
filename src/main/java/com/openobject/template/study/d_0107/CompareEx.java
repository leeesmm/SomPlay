package com.openobject.template.study.d_0107;

public class CompareEx {

	public static void exec(Compare compare) {
		int i = 10;
		int j = 20;
		int value = compare.compareTo(i, j);
		System.out.println("result : " + value);
	}
	
	public static void main(String[] args) {
		exec(new Compare() {
			@Override
			public int compareTo(int value1, int value2) {
				return value1 - value2;
			}
		});
		
		exec((i, j) -> {return i - j;});
		
	}
	
}
