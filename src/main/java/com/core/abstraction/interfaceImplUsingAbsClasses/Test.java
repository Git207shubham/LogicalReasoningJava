package com.core.abstraction.interfaceImplUsingAbsClasses;

public class Test {
	public static void main(String[] args) {

		Calculator c = new C();

		c.add(11, 22);
		c.sub(21, 12);
		c.mul(12, 5);
		c.div(15, 5);

		/*
		 * A a=new C(); a.add(); a.sub(); a.mul(); a.div();
		 * 
		 * B b=new C(); b.add(); b.sub(); b.mul(); b.div();
		 * 
		 * C cc=new C(); cc.add(); cc.sub(); cc.mul(); cc.div();
		 */
	}
}
