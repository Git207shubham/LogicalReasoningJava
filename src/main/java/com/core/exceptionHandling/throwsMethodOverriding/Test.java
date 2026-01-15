package com.core.exceptionHandling.throwsMethodOverriding;

public class Test {

    public static void main(String[] args) {

        Child ch= new Child();

        try
        {
            ch.m2();
        }
        catch (Exception e)
        {
            System.out.println("Exception handled ...");
        }


    }
}
