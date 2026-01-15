package com.core.abstraction.multipleInherUsingInterface;

public class A implements I3
// so A must implement all methods of I3 ie merger of I,I1,I3
{

	@Override
	public void m1() {
		System.out.println("m1 of I and I1--A ..");
	} // M1 AND M2 has to be same implemented becoz same way defined in I & I1
		// unlik method m8 has two implementations

	@Override
	public void m2() {
		System.out.println("m2-I3--A");
	}

	@Override
	public void m5() {
		System.out.println("m5-I3-A");
	}

	@Override
	public void m7() {
		System.out.println("m7-I3-A");
	}

	@Override
	public void m8() {
		System.out.println("m8-3--A");
	}

	@Override
	public int m8(int a) {
		System.out.println("m8-I3-A");
		System.out.println(a);
		return a;

	}

}
