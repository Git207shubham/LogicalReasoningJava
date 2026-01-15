package com.core.exceptionHandling;

public class TestTryCatchFinally {

    public static void main(String[] args) {

        System.out.println("MAIN START");

        TestTryCatchFinally e = new TestTryCatchFinally();

        int x = e.m1();
        System.out.println(" x : " + x);

        System.out.println("MAIN ENDS");

        m2();
    }

	// try has return then either catch or ( finally or method must have return)

    public static int m2() {
        try {
            int i = Integer.parseInt("");

            // if i is blank how to print it
            System.out.println("I value : " + i);
            return 10; // goes to FINALLY BLOCK
        } catch (ArithmeticException e) {
            //return 20;// goes to FINALLY BLOCK
        } finally {
            System.out.println("hello finally..");
            return 30; // execution wont go back to try or finally, will go to call point
        }
		//return 10;


    }

    public int m1() {
        int x = 10;

        try {
            System.out.println("try block");
            int a = 10 / 0;
            return x;

        } finally {
            System.out.println("FINALLY BLOCK");
            // if try has return stament then
            // not compulsary need of writing retun compulsary ????? BUT
            // if exe happen then the method must return something through finally block
            // SO FOR EX HAPPEN OR DONT WE MUST GIVE RETURN STMT IN BOTH TRY AND FINALLY
            // BLOCK ????????????
            // if wrote return in finally then due to return call goes to where it was
            // called ie method m1 ( ireesp of exeption) not in try block
            return 102;
        }
    }
}
