package com.logical.start_pattern;

public class All_star {

	public static void main(String[] args) {
		
		
		// simple rising start pattern --start starr from 1
		int max=5;
		for (int row = 0; row <= max; row++) {
			for (int col = 0; col <=row ; col++) 
			{    
				System.out.print("*");
			}
			System.out.println();
		}

		// simple 4*4 falling start pattern---fall stars from n
		for (int row = 0; row <=max ; row++) {
			for (int col = 0; col <= max-row ; col++) 
			{    
				System.out.print("*");
			}
			System.out.println();

		}
		

		// 3*3 falling space from n to >i to and rising star from 1
		// pyramid

		for (int row = 0; row <= max; row++) {
			
			// 3*3 falling spaces reflectiontriangle
			for (int col =0 ; col <= max-row; col++) 
			{
				System.out.print(" ");
			}

			for (int col = 0; col <= row; col++) {
				System.out.print("* ");                   ///====> imp--small diff
			}
			System.out.println();
		}

		// 3*3 falling space from n to >i to and rising star from 1
		for (int row = 0; row <= max; row++) 
		{
			for (int col = 0 ; col <= max-row ; col++)   // 
		    {
				System.out.print(" ");
			}

			for (int col = 0; col <= row; col++) {
				System.out.print("*");					///====> imp--small diff
			}
			System.out.println();
		}

		System.out.println();
		
		// 4*4 falling start from n and rises spaces from 1
		for (int row = 0; row <= max; row++) {

			for (int col = 0 ; col <= row-1 ; col++)   // needs 3*3 from row no 2
		    {
				System.out.print(" ");
			}
			
			for (int col = 0; col <= max-row; col++) 
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
