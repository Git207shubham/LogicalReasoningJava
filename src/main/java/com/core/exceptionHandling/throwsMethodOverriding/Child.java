package com.core.exceptionHandling.throwsMethodOverriding;

public class Child extends Parent {

    @Override
    public void m0() throws NullPointerException
    {
        System.out.println("child class m1");

    }
    @Override
    public void m1() throws NullPointerException
    {

        System.out.println("child class m1");

    }

    @Override
//    public void m2()throws Exception
//    public void m2()throws NullPointerException
//    public void m2() throws ArithmeticException
    //child throws nothing or same or any uncheched is ok
   public void m2()
    {
        System.out.println("child m2 start...");
        String abcd = null;
        System.out.println(abcd.toLowerCase());
        System.out.println("child m2 end....");
    }

}