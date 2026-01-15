package com.core.thisSuper;

public class ThisWithInstanceVariable
{

	public static void main(String args[])
	{
		
		Div c=new Div();
		Div dv=c.divv(100,5);
		Mult d=new Mult();
		Mult ml=d.multt(15,5);
		
		System.out.println("Division "+ dv.x+" : "+dv.y+" : "+dv.z);
		System.out.println("Multiplication "+ ml.x+" : "+ml.y+" : "+ ml.z);

	}
}

class Div
{

	int x=10;
	int y=20;
	int z;
	public Div divv(int x, int y)
	{
		this.x=x;
		this.y=y;
		Div a=new Div();
		a.z=x/y;
		return a;
	}
}

class Mult
{

	int x;
	int y;
	int z;
	public Mult multt(int x, int y)
	{
		this.x=x;
		this.y=y;
		Mult a=new Mult();
		a.z=x*y;
		return a;
	}
}