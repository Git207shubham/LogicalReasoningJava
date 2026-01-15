package com.core.inheritance.theory;

public class Test {
public static void main(String[] args) {

	// for method call compilation succeeds only if Reference has the method defined which is called or Reference class inherits the method
	// which class's which method( overloaded ) method to execute is decided at runtime time based on Object type
	//acc to Run time polymorphism of method is overriden otherwise ,
	// Reference class method is executed
	// Run time polymorphism only works in case of method overriding

	// for variable compilation succeeds if Reference  has variable defined or Inherits from parent class
	//which class's which variable will be used is decided at compile time based on reference type

	A a=new B();//object of class B
	A a1=new A();
	a.m1();
	a.m2();
	//a.m3();  // compiler error  as A dont have m3
	System.out.println(a.x);
	System.out.println(a.y);
	//System.out.println(a.z);   //compiler error as A dont have z
	
	a1.m1();
	a1.m2();
	//a1.m3(); // compiler error as A dont have m3
	System.out.println(a1.x);
	System.out.println(a1.y);
	//System.out.println(a1.z);
}
}




