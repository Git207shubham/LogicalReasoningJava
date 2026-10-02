package com.logical;

import java.util.Scanner;

/**
 * Reading input from the keyboard with Scanner.
 *
 * Interview points:
 * - next()     reads ONE word (stops at space).
 * - nextLine() reads the WHOLE line (including spaces).
 * - nextInt()  reads a number but leaves the "Enter" (\n) in the buffer, so a nextLine()
 *   called right after it returns an empty string. Fix: call sc.nextLine() once to consume it.
 * - try-with-resources closes the Scanner automatically (Scanner implements AutoCloseable).
 */
public class MyScanner {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your name:");
            String name = sc.next();

            System.out.println("Enter age:");
            int age = sc.nextInt();

            System.out.println("Values stored : " + name + " : " + age);
        }
    }
}
