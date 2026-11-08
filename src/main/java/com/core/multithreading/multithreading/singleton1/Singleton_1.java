package com.core.multithreading.multithreading.singleton1;

// LAZY singleton: object is created only on the first getObj() call
public class Singleton_1 {

	static Singleton_1 singleobj;
	int x;

	// private constructor -> no other class can call new Singleton_1()
	private Singleton_1(int h) {

		this.x = h;
	}

	// NOTE: not thread safe - two threads can both see null and create two objects
	// fix: make this method synchronized, or use double-checked locking with a volatile field
	public static Singleton_1 getObj() {
		if (singleobj == null) {
			singleobj = new Singleton_1(15);
		}
		return singleobj;
	}

	public void m1() {

		x = 100;
		System.out.println(x);
	}

	public static void main(String[] args) {

		Singleton_1 obj = Singleton_1.getObj();
		obj.m1();
	}
}
