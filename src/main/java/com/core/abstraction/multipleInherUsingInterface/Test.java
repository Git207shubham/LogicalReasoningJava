package com.core.abstraction.multipleInherUsingInterface;

public class Test {

	public static void main(String[] args) {
		I3 i = new A();

		i.m1();
		i.m2();
		i.m5();
		i.m7();
		i.m8();
		i.m8(33);

		I ii = new B();

		ii.m1();
		ii.m2();
		ii.m8();

		I iii = new C();

		iii.m1();
		iii.m2();
		iii.m8();

		I g = new D();
		I1 h = new D();

		g.m1();
		g.m2();
		g.m8();

		h.m1();
		h.m5();
		h.m8(99);
	}

}
