package com.core.abstraction.multipleInherUsingInterface;

public class B implements I
//multiple classes can implement same interface ie class B AND C both are implementing interface I
{
	@Override
	public void m1() {
		System.out.println("m1 of I and I1--B ");
	}

	@Override
	public void m2() {
		System.out.println("m2-I--B");
	}

	public void m3() {
		System.out.println("m3-I--B");
	}

	public void m4() {
		System.out.println("m4-I--B");
	}

	@Override
	public void m8() {
		System.out.println("m8-I--B");
	}
}
