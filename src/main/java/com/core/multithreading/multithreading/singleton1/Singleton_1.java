package com.core.multithreading.singleton1;

public class Singleton_1 {

	static Singleton_1 singleobj;
	int x;

	private Singleton_1(int h) {

		this.x = h;
	}

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
