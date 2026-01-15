package com.core.abstraction.interfaceImplUsingAbsClasses;

public abstract class B extends A
{
	
	public void mul(int x,int y)
	{
		System.out.println("Muliplication = "+(x*y));
	}
	
	public void sub(int x,int y)
	{
		System.out.println("Substraction = "+(x-y));
	}
	
}
