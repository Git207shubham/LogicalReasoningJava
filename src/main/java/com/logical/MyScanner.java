package com.logical;

import java.util.Scanner;
public class MyScanner
{
	public static void main(String[] args) {
		
    Scanner sc=new Scanner(System.in);
    System.out.println("enter your name");
    String name=sc.next();
    System.out.println("enter age");
    int age=sc.nextInt();

    System.out.println("Values stored : "+name+" : "+age);
}
}



