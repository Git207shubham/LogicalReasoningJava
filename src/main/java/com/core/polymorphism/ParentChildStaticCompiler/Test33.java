package com.core.polymorphism.ParentChildStaticCompiler;

class Parent {
	public void m1() {
		System.out.println("hello parent");
	}
	
	public void m2() {
		System.out.println("hello---m2--parent");
	}
}

class Child extends Parent {

	@Override
	public void m2() {
		System.out.println("hello---m2");
	}
}

public class Test33 {

	public static void main(String[] args) {
		Parent pp = new Child();
		pp.m2();

		// compiletime polymorphism
		// compiler check if variable and method is present in reference object

		// runtime poly
		//  excuted impl who's object created at runtime , if not found then its parents implementation is called
		// varriable overriding not allowed
		
	}

}
