package com.core.exceptionHandling.throwsMethodOverriding;


import java.io.FileNotFoundException;

public class Parent
{
    public void m0()
    {
        System.out.println("PARENT CLASS");
    }
    public void m1()throws FileNotFoundException
    {
        System.out.println("PARENT CLASS");
    }

    public void m2()throws NullPointerException
    {



        System.out.println("parent m2");
    }

}


