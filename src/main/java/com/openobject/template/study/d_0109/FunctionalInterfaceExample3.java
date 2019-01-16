package com.openobject.template.study.d_0109;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class FunctionalInterfaceExample3 {

	public static void main(String[] args) {
		final List<Product> products = Arrays.asList(
			new Product(1L, "A", new BigDecimal("10.00")),
			new Product(2L, "B", new BigDecimal("20.00")),
			new Product(3L, "C", new BigDecimal("30.00")),
			new Product(4L, "D", new BigDecimal("40.00")),
			new Product(5L, "E", new BigDecimal("50.00"))
		);
		
		final List<Product> result = new ArrayList<>();
		final BigDecimal twenty = new BigDecimal("20");
		for (final Product product : products) {
			if ( product.getPrice().compareTo(twenty) >= 0 ) {
				result.add(product);
			}
		}
		
		System.out.println(result);
		
		System.out.println(filter(products, product -> product.getPrice().
				compareTo(twenty) >= 0 ));
		System.out.println(filter(products, product -> product.getPrice().
				compareTo(new BigDecimal("10")) < 1 ));
		
		final List<Product> expensiveProducts = filter(products, product -> product.getPrice().
				compareTo(new BigDecimal("50")) > 0);
		
		final List<DiscountedProduct> discountedProducts = new ArrayList<>();
		
		for ( Product product : expensiveProducts ) {
			discountedProducts.add(new DiscountedProduct(product.getId(), product.getName(), 
					product.getPrice()));
		}
		
		System.out.println("expensive : " + expensiveProducts);
		System.out.println("discount : " + discountedProducts);
		
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		final List<T> result = new ArrayList<>();
		for (final T t : list) {
			if ( predicate.test(t) ) {
				result.add(t);
			}
		}
		
		return result;
	}
	
}

@AllArgsConstructor
@Data
class Product {
	private Long id;
	private String name;
	private BigDecimal price;
}

@ToString(callSuper = true)
class DiscountedProduct extends Product {

	public DiscountedProduct(Long id, String name, BigDecimal price) {
		super(id, name, price);
	}
	
}

