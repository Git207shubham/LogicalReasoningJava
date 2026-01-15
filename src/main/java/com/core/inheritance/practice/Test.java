package com.core.inheritance.practice;

public class Test {

	public static void main(String[] args) {

		A a=new A();
		A b=new B();
		A d=new D();
		A c=new C();
		A e=new E();

		B b1=new B();

		B d1=new D();

		D d2=new D();
		C c1=new C();
		C e1=new E();
		E e2=new E();

		a.m1();
		System.out.println(a.a);
		System.out.println(a.b);

		b.m1();
		//b.m2();
		System.out.println(b.a);
		System.out.println(b.b);
		d.m1();
		//d.m2();
		//d.m3();
		//d.m4();
		System.out.println(d.a);
		System.out.println(d.b);
		//System.out.println(d.d);
		c.m1();
		//c.m2();
		//c.m3();
		System.out.println(c.a);
		System.out.println(c.b);
		//System.out.println(c.c);
		e.m1();
		//e.m2();
		//e.m3();
		//e.m5();
		//e.m6();
		System.out.println(e.a);
		System.out.println(e.b);
		//System.out.println(e.c);
		//System.out.println(e.e);
		
		}
}
