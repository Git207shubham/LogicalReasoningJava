package com.core.abstraction.multipleInherUsingInterface;

public class D implements I, I1

// one class can implement multiple interfaces
// multiple inheritance is possible by sing interfaces not normal java classes only 
{
	@Override
	public void m1() {
		System.out.println("m1-I & I1--D");
	}

	@Override
	public void m2() {
		System.out.println("m2-I--D");
	}

	public void m3() {
		System.out.println("m3-I--D");
	}

	public void m4() {
		System.out.println("m4-I1--D");
	}

	@Override
	public void m5() {
		System.out.println("m5-I1--D");
	}

	@Override
	public void m8() {
		System.out.println("m8-I--D");
	}

	@Override
	public int m8(int x) {
		System.out.println("m8-I1--D");
		return x;
	}

}
