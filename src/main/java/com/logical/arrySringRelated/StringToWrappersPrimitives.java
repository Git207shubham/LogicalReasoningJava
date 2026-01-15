package com.logical.arrySringRelated;

public class StringToWrappersPrimitives {
	public static void main(String[] args) {

		String str = "1234";

		// gives string from any Wrapper data type
		String s3 =String.valueOf(str);
		System.out.println("string value : "+s3);
        String s4 = String.valueOf(132453.34F);
        System.out.println("float value : "+s4);
		String s5=String.valueOf(34625263L);
		System.out.println("long value : "+s5);
        
        System.out.println(Integer.valueOf("123") instanceof Integer);

		// get primitive data type from String
		int x=Integer.parseInt("1023");
		System.out.println("value of x : int value : "+x);
		
		float ff = Float.parseFloat("12.4f");
		System.out.println("value of x : float value : "+ff);
	}
}
