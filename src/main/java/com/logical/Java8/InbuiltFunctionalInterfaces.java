package com.logical.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class InbuiltFunctionalInterfaces {

    public static void main(String args[])
    {
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };
        System.out.println(isEven.test(4));   // true
        System.out.println(isEven.test(7));   // false

        isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4));   // true

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test(""));  // true

        Predicate<Integer> isPositive = n -> n > 0;
        isEven     = n -> n % 2 == 0;

        isPositive.and(isEven).test(4);     // true  (positive AND even)
        isPositive.or(isEven).test(-4);     // true  (even)
        isEven.negate().test(4);            // false (NOT even)

        Predicate<String> isJava = Predicate.isEqual("Java");
        isJava.test("Java");                // true

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);  // 2 4 6

    }
}
