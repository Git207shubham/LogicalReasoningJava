package com.core.abstraction.noObjOFAbsCls;

abstract class Parent
{
	public abstract void m1();

	public void m2()
	{
		System.out.println("m2---Parent");
	}

}

class Child extends Parent
{
	public final void m1()
	{
		System.out.println("m1---Child");
	}
}

public class Test 
{
	public static void main(String args[]) 
	{  
   		Child c = new Child(); 
   		
   		c.m1(); 
   		
	    c.m2();

		// can create object of Abstract class
		// then it may be used to call abstact method by using the object and
		// that class's method may be called whhich is abstract
	    Parent p=new Child(); //compiled all methods of class Parent
	    
	    p.m1();
	    p.m2();
	} 
}
