package com.core.constructor;

class A {

    int x;

    // 1️⃣ Default / No-arg constructor
    A() {
        this(10); // calls parameterized constructor of SAME class
        System.out.println("A: no-arg constructor");
    }

    // 2️⃣ Parameterized constructor
    A(int x) {
        this.x = x;
        System.out.println("A: parameterized constructor, x = " + x);
    }
}







