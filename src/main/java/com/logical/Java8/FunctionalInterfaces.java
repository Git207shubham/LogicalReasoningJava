package com.logical.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class FunctionalInterfaces {

	public static void main(String[] args) {

		Random random = new Random();

		// Supplier<T> takes no input and returns a value: T get()
		// here it returns a random string from the list each time get() is called
		Supplier<String> supplier = () -> {

			List<String> list = Arrays.asList("aa", "bb", "dd", "ww", "cc");
			return list.get(random.nextInt(list.size()));

		};
		
		System.out.println(supplier.get());

	}
}
