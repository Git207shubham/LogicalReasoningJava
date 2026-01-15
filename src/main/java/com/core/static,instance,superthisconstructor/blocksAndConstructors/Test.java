package blocksAndConstructors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {

		// when ever object is created /instantiated then constructor of that class is
		// called
		B b = new B();
		B b1 = new B(10);
		B b2 = new B("abc");
		 
	}
}

class A {

	static 
	{
		System.out.println("ststic block class A called");
	}
	
	{
		System.out.println("instance block of A");
	}
	
	public A()
	{
		System.out.println("simple parent constructor-A");
	}
}

class B extends A {

	public B() {

// by default super() present in every constructor so calls parent class
		// constructor or object class constructor( if no parent clas present)
		System.out.println("non parameterised child constructor-B");
	}

	public B(int i) {

		System.out.println("parameterised child constructor-B ");
	}

	public B(String s) 
	{

		System.out.println("parameterised child constructor 2 - B");
	}

	{
		System.out.println("instance block class B");
	}
}
