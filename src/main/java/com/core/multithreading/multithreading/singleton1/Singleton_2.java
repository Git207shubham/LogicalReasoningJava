package com.core.multithreading.multithreading.singleton1;

public class Singleton_2 {

	static Singleton_2 singleobj = new Singleton_2();
	int x;

	private Singleton_2() {

	}

	public static Singleton_2 getObj() {

		return singleobj;
	}

	public void m1() {

		x = 100;
		System.out.println(x);
	}

	public static void main(String[] args) {

		Singleton_2 obj = Singleton_2.getObj();
		obj.m1();
	}
}
