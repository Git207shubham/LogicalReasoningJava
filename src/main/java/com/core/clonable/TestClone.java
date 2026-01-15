package com.core.clonable;

public class TestClone {

    /*Shallow Copy
    Primitive fields → copied
    Object references → shared*/

    public static void main(String[] args) throws Exception {
        Person p1 = new Person(25, "Shubham");
        Person p2 = (Person) p1.clone();

        System.out.println(p1.age); // 25
        System.out.println(p2.age); // 30

        p2.age = 30;
        System.out.println(p1.age); // 25
        System.out.println(p2.age); // 30
    }
}

