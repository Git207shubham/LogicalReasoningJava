package com.core.thisSuper;

/*Must be first statement
in default constructor --super() If not written → compiler inserts super() on first line
this is NOT implicitly provided , if needed  then call
* */

public class Test {
    public static void main(String[] args) {

        System.out.println("---- Object 1 ----");
        B b1 = new B();

        System.out.println("\n---- Object 2 ----");
        B b2 = new B(5);

        System.out.println("\n---- Method Call ----");
        b2.show();
    }
}

class A {

    int x;

    // 1️⃣ No-arg constructor
    A() {
        System.out.println("A: no-arg constructor");
    }

    // 2️⃣ Parameterized constructor
    A(int x) {
        this.x = x; // this refers to current class variable
        System.out.println("A: parameterized constructor, x = " + this.x);
    }

    void show() {
        System.out.println("A show(), x = " + x);
    }
}

class B extends A {

    int x;

    // 3️⃣ No-arg constructor
    B() {
        super(); // calls A() constructor (implicit if not written)
        System.out.println("B: no-arg constructor");
    }

    // 4️⃣ Parameterized constructor
    B(int x) {
        super(x);      // calls A(int)
        this.x = x+10; // this refers to B's variable
        System.out.println("B: parameterized constructor, x = " + this.x);
    }

    @Override
    void show() {
        System.out.println("B show(), x = " + x);
        super.show(); // calls A's show()
    }
}