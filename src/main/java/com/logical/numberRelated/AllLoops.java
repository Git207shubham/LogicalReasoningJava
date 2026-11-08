package com.logical.numberRelated;

import java.util.Scanner;

// for, while and do-while examples
// do-while runs the body at least once, because the condition is checked at the end
public class AllLoops {
	// for loop - multiplication table of 2
	public void table2() {
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println(2 * i);
		}
	}

	// do-while - odd numbers from 20 to 40
	public void odd() {
		int n = 20;
		do {
			{
				if (n % 2 != 0) {
					System.out.println(n);
				}
			}
			n++;
		} while (n <= 40);
	}

	// while - even numbers from 1 to 20
	public void even() {
		int n = 1;
		while (n <= 20) {
			{
				if (n % 2 == 0) {
					System.out.println(n);

				}
			}
			n++;
		}
	}

	// do-while counting down - table of 4 in reverse (40 to 4)
	public void reverseTable() {
		int n = 10;
		do {
			System.out.println(4 * n);
			n--;
		} while (n >= 1);
	}
}

// runner: reads a choice from the console and calls the matching loop example
class B {
	public static void main(String args[]) {
		AllLoops aa = new AllLoops();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 1 or 2 or 3 or 4");
		int ss = sc.nextInt();
		switch (ss) {
		case 1:
			aa.table2();
			break;
		case 2:
			aa.even();
			break;
		case 3:
			aa.odd();
			break;
		case 4:
			aa.reverseTable();
			break;
		default:
			System.out.println("ENTER VALID INPUT");
		}
	}
}