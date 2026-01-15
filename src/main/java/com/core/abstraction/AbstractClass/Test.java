package com.core.abstraction.AbstractClass;

import java.util.Scanner;
public class Test 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("select an arithmatic operation t be perfomed");
		System.out.println("1.add 2.substract 3.multiply 4.divide");
		int m=sc.nextInt();
		System.out.println("enter two numbers to perfor m arithmatic operation");
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		Calculator aa=new Division();
	
		switch(m)
		{
			case 1:aa.add(x,y);
			       break;
			case 2:aa.sub(x,y);
		           break;
			case 3:aa.mul(x,y);
		           break;
			case 4:aa.div(x,y);
		            break;
		     default:System.out.println("entered wrong input");
		}
		}
}
