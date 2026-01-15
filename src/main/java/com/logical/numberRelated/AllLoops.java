package com.logical.numberRelated;

import java.util.Scanner;

public class AllLoops {
	public void table2() {
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println(2 * i);
		}
	}

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

	public void reverseTable() {
		int n = 10;
		do {
			System.out.println(4 * n);
			n--;
		} while (n >= 1);
	}
}

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