package com.core.comparableComparator.comparable;

import java.util.TreeSet;

// sorting objects of class String using compareTo method in Comparable interface
//no need to implement comparable interface
// because String class has already implement comparable interface.
//compareTo method of String-class which return diff betn ASCII value of
// first element of each string then second if first diff is zero

public class Demo {
	public static void main(String[] args) {

		// TreeSet calls compareTo method of the class whose
		// elements we are storing internally to sort the elements

		// a class has to implemenet Comparable interface to store in treeset

		TreeSet<String> t = new TreeSet<>();
		t.add("A");
		t.add("Z");
		t.add("B");
		t.add("A");

		System.out.println(t);
		// Ascending order removing duplicate elements

	}
}
