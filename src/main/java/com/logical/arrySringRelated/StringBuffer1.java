package com.logical.arrySringRelated;

public class StringBuffer1 {

	public static void  main(String[] args) throws Exception{

		StringBuffer sb = new StringBuffer();
		System.out.println(sb+fesfef);

		StringBuffer sb1 = new StringBuffer("aaa");

		System.out.println(sb1);

		StringBuffer sb2 = sb1.append("bbb");
		System.out.println(sb1);
		System.out.println(sb2);
		
		System.out.println(sb1.equals(sb2)); // will cheks if sb1 also changed or not -----mutable so changed
		System.out.println(sb1 == sb2); // checks refering to same or not...true...String behaves same

		sb1.insert(3, "ccc");
		System.out.println(sb1);
		
		System.out.println(sb1.delete(3,6));
		System.out.println(sb1);
		
		System.out.println(sb1.deleteCharAt(3));
		
		
		// when capacity fulls then ==old cap*2 + 2 ==new cap
				
		StringBuffer sb4 = new StringBuffer();  // empty sb
		System.out.println(sb4.capacity());
		sb4.append("abcdeabcdeabcdea");       // filled sb with 16 items  --if >16 then above formula
		System.out.println(sb4.capacity());
				
		StringBuffer sb5 = new StringBuffer("bbbbb");  // sb prefilled
		System.out.println(sb5.capacity());

	}
}
