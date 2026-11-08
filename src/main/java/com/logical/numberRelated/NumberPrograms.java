package com.logical.numberRelated;

public class NumberPrograms {

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

        // multiply/divide way: num1 = 200, num2 = 200/20 = 10, num1 = 200/10 = 20
        // NOTE: fails if either number is 0 (divide by zero) and can overflow for big numbers
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

        // count all divisors of n from 1 to n
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        // a prime has exactly 2 divisors: 1 and itself
        // (nothing is printed when the number is not prime)
        if (count == 2) {
            System.out.println("number is prime");
        }
    }
    public static void largestOfThree() {
        int num1 = 10;
        int num2 = 20;
        int num3 = 15;

        // nested ternary: if num1 > num2 compare num1 with num3, else compare num2 with num3
        int largest = (num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);

        System.out.println("The largest number among " + num1 + ", " + num2 + ", and " + num3 + " is " + largest);

    }

    // perfect number = sum of its proper divisors equals the number (6 = 1+2+3, 28 = 1+2+4+7+14)
    public static void perfectNumber() {
        int n = 28;

        // int n=496;

        // int n=6;

        int sum = 0;

        // NOTE: looping only up to sqrt(n) misses the bigger divisors (7 and 14 for 28),
        // so 28 prints "not perfect"; use i <= n / 2 to include all proper divisors
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

    // spy number = sum of digits equals product of digits (213 -> 2+1+3 = 6 = 2*1*3)
    public static void spy() {
        // int n = 34556564;
        // int n = 321;
        int n = 213;

        int sum = 0;

        int prod = 1;

        do {

            // n % 10 gives the last digit, n / 10 removes it
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

    // neon number = sum of digits of its square equals the number (9 -> 81 -> 8+1 = 9)
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

    // armstrong number = sum of (each digit ^ number of digits) equals the number
    // 8208 -> 8^4 + 2^4 + 0^4 + 8^4 = 4096 + 16 + 0 + 4096 = 8208
    public static void armstrong() {
        int nn = 8208;

        int n = nn;

        int sum = 0;

        do {

            int x = n % 10;

            int h = nn;

            int z = 1;

            // runs once per digit of nn, so z becomes x ^ (number of digits)
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

        // count the digits first
        while (n != 0) {
            n = n / 10;
            count++;
            System.out.println(count);
        }

        // NOTE: n is now 0 (the loop above used it up), so the loop below sees only one digit (0)
        // and (cc >= 0) multiplies count+1 times; reset n = nn and use (cc > 0) to fix

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

    // leap year rule: divisible by 4, except century years (divisible by 100),
    // which are leap only if also divisible by 400 (2000 yes, 2100 no)
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
