package com.core.abstraction.interfaceImplUsingAbsClasses;

public abstract class A implements Calculator {
	@Override
	public void add(int x, int y) {
		System.out.println("ADDITION = " + (x + y));
	}

}
