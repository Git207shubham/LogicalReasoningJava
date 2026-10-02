package com.logical.numberRelated;

public class Test {

    public static void main(String[] args) {

        swapTwoNumbers();
        prime();
        largestOfThree();

        leapYear();
        //factorial_and_palendrom();
    }

    public static void swapTwoNumbers()
    {
        int num1 = 10;
        int num2 = 20;

        System.out.println("Before swapping:");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        // Swap the numbers without a third variable
//		num1 = num1 + num2;
//		num2 = num1 - num2;
//		num1 = num1 - num2;

        num1=num1*num2;
        num2=num1/num2;
        num1=num1/num2;

        System.out.println("After swapping:");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void prime()
    {
        int n = 23;

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            System.out.println("number is prime");
        }
    }
    public static void largestOfThree() {
        int num1 = 10;
        int num2 = 20;
        int num3 = 15;

        int largest = (num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);

        System.out.println("The largest number among " + num1 + ", " + num2 + ", and " + num3 + " is " + largest);

    }

    public static void perfectNumber() {
        int n = 28;

        // int n=496;

        // int n=6;

        int sum = 0;

        for (int i = 1; i < Math.sqrt(n); i++) {

            if (n % i == 0) {
                sum = sum + i;
            }

        }

        if (sum == n) {
            System.out.println("perfect");
        } else {
            System.out.println("not perfect");
        }

    }

    public static void spy() {
        // int n = 34556564;
        // int n = 321;
        int n = 213;

        int sum = 0;

        int prod = 1;

        do {

            int x = n % 10;

            sum = x + sum;

            prod = prod * x;

            n = n / 10;

        } while (n != 0);

        if (sum == prod) {
            System.out.println("spy");
        } else {
            System.out.println("not spy");
        }
    }

    public static void neon() {
        int n = 9; // 81 = 8+1 = 9
        int m = n;
        int nn = n * n; // 81

        int sum = 0;

        int x = 0;

        for (int i = 0; nn != 0; i++) {

            x = nn % 10; // 1 8

            nn = nn / 10; // 8 0

            sum = sum + x; // 0+1+9

            System.out.println(sum);
        }

        if (m == sum) {
            System.out.println("neon");
        } else {
            System.out.println("not neon");
        }
    }

    public static void armstrong() {
        int nn = 8208;

        int n = nn;

        int sum = 0;

        do {

            int x = n % 10;

            int h = nn;

            int z = 1;

            do {
                z = z * x;

                h = h / 10;

            } while (h > 0);

            sum = sum + z;

            n = n / 10;

        } while (n != 0);

        if (nn == sum) {
            System.out.println(nn + " IS " + "ARMSTRONG number");
        } else {
            System.out.println("not ARMSTRONG");
        }
    }

    public static void armstrong2() {
        int nn = 8208;

        int n = nn;

        int sum = 0;

        int count = 0;

        while (n != 0) {
            n = n / 10;
            count++;
            System.out.println(count);
        }

        do {

            int cc = count;

            int x = n % 10;

            int h = nn;

            int z = 1;

            do {
                z = z * x;
                cc--;

                System.out.println(z);
            } while (cc >= 0);

            sum = sum + z;

            n = n / 10;

        } while (n != 0);

        if (nn == sum) {
            System.out.println(nn + " IS " + "ARMSTRONG number");
        } else {
            System.out.println("not ARMSTRONG");
        }
    }

    public static void leapYear()
    {
        for (int y = 2000; y <= 2300; y++) {

            if (y % 100 == 0) {
                //
                if (y % 400 == 0) {
                    System.out.println(y + "IS LEAP YEAR");
                } else {
                    System.out.println(y + " IS NOT LEAP YEAR");
                }
            } else if (y % 4 == 0)
            //
            {
                System.out.println(y + "IS LEAP YEAR");
            } else
            //
            {
                System.out.println(y + " IS NOT LEAP YEAR");
            }
        }
    }

}
