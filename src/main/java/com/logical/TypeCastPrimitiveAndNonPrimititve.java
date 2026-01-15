package com.logical;

class A {
    int x;
    int y;
}

class B extends A {
    char c1;
    char c2;
}

class C extends B {

    String s1;
    String s2;
}

class Demo {
    public A returnCwrappedAsA() {

        C c = new C();
        c.s1 = "ABC";
        c.s2 = "xyz";
        c.c1 = 'A';
        c.c2 = 'B';
        c.x = 10;
        c.y = 20;

        return c;
    }

    public B returnCwrappedAsB() {

        C c = new C();
        c.s1 = "DEF";
        c.s2 = "def";
        c.c1 = 'M';
        c.c2 = 'N';
        c.x = 11;
        c.y = 21;

        return c;
    }

    public C returnC() {

        C c = new C();
        c.s1 = "GHI";
        c.s2 = "ghi";
        c.c1 = 'F';
        c.c2 = 'E';
        c.x = 12;
        c.y = 23;

        return c;
    }

    public Object returnIntWrappedAsObject() {
        return 45;
    }
}

public class TypeCastPrimitiveAndNonPrimititve {

    public static void main(String[] args) {

        Demo d = new Demo();

        // type casting is neede to Type cast higher data type to lower one
        // Objet to int /Interger /CustomObject
        // Parent class to child class

        int intVar = (int) d.returnIntWrappedAsObject();
        System.out.println("aa " + intVar);

        A refA = d.returnCwrappedAsA();
        System.out.println("aa " + refA.x + " : " + refA.y);

        C refC1 = (C) d.returnCwrappedAsA();
        System.out.println("object c : " + (refC1 instanceof C) + " : " + (refC1 instanceof A));
        System.out.println(refC1.s1);
        System.out.println(refC1.s2);
        System.out.println(refC1.c1);
        System.out.println(refC1.c2);
        System.out.println(refC1.x);
        System.out.println(refC1.y);

        B refB1 = (B) d.returnCwrappedAsB();
        System.out.println("object c : " + (refB1 instanceof C) + " : " + (refB1 instanceof B));
//		System.out.println(refB1.s1);
//		System.out.println(refB1.s2);
        System.out.println(refB1.c1);
        System.out.println(refB1.c2);
        System.out.println(refB1.x);
        System.out.println(refB1.y);

        A refA1 = d.returnCwrappedAsA();//
        System.out.println("object c : " + (refB1 instanceof C) + " : " + (refB1 instanceof A));
//		System.out.println(refA1.s1);
//		System.out.println(refA1.s2);
//		System.out.println(refA1.c1);
//		System.out.println(refA1.c2);
        System.out.println(refA1.x);
        System.out.println(refA1.y);


    }

}
