package com.logical.if_else;

/*
 * CONTROL FLOW in one place: if / else-if / ternary / switch / loops / break / continue
 */

public class ControlFlow {

    public static void main(String[] args) {
        grade(82);
        System.out.println(maxOfTwo(4, 9));
        dayName(3);
        loops();
    }

    // if / else-if / else : first TRUE condition wins, rest blocks are skipped
    // else is not compulsary  -- write else when you require default fallback
    static void grade(int marks) {
        if (marks >= 90) {
            System.out.println("A");
        } else if (marks >= 75) {
            System.out.println("B");
        } else if (marks >= 35) {
            System.out.println("C");
        } else {
            System.out.println("Fail");
        }
    }

    // ternary : condition ? valueIfTrue : valueIfFalse
    static int maxOfTwo(int a, int b) {
        return a > b ? a : b;
    }

    // switch works with: byte, short, char, int, their wrappers, String (Java 7+), enum
    // NOT with long, float, double, boolean.
    // Without break -> "fall through" to the next case.
    static void dayName(int day) {
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }
        // Java 14+ arrow switch (no break needed, can return value):
        // String name = switch (day) { case 1 -> "Mon"; case 2 -> "Tue"; default -> "Other"; };
    }

    static void loops() {
        // for       : when you KNOW how many times
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // while     : checks condition FIRST (may run 0 times)
        int n = 1;
        while (n <= 3) {
            System.out.print(n + " ");
            n++;
        }
        System.out.println();

        // do-while  : runs body FIRST, checks later (runs at least 1 time)
        int m = 10;
        do {
            System.out.print(m + " ");
            m++;
        } while (m <= 3);           // false, but body already ran once -> prints 10
        System.out.println();

        // for-each  : read every element, no index
        int[] arr = {5, 6, 7};
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // continue skips the current iteration, break exits the loop
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;
            if (i > 7) break;
            System.out.print(i + " ");   // 1 3 5 7
        }
        System.out.println();
    }
}
