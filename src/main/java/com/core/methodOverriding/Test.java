package com.core.methodOverriding;

public class Test {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.roll = 12;
		s1.name = "xyz";

		Student s2 = new Student();
		s2.roll = 23;
		s2.name = "abc";

		Test t = new Test();

		System.out.println("Student1 : roll = " + s1.roll + " name = " + s1.name);
		System.out.println("Student2 : roll = " + s2.roll + " name " + s2.name);

		// student class has toString overriden
		System.out.println(s1.toString());
		System.out.println(s2);// no need to call toString object to print data of an object

		System.out.println(t);// compiler writes t.toString();
		// but class Test dont have this method so invokes toString of object class and
		// prints string representation of object/reference ie HASHCODE

		Integer ii = new Integer(12);
		System.out.println("String type 12 = " + ii.toString());// invoved overriden toString method of integer class
																// and prints object ii in string type representation
		System.out.println("hex type 15 is " + ii.toHexString(15));
	}
}
