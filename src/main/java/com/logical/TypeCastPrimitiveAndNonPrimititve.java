package com.logical;

/*
 * TYPE CASTING = converting a value from one type to another.
 *
 * 1) PRIMITIVE casting
 *    - Widening  (small -> big)  : automatic.  byte -> short -> int -> long -> float -> double
 *    - Narrowing (big -> small)  : manual (int) and may LOSE data.
 *
 * 2) OBJECT (reference) casting - works only inside one inheritance tree
 *    - Upcasting   (Child -> Parent) : automatic, always safe.
 *    - Downcasting (Parent -> Child) : manual, safe ONLY if the real object is that child,
 *                                      otherwise ClassCastException at runtime.
 *    - Always check with instanceof before downcasting.
 *
 * KEY RULE: the REFERENCE type decides what you can ACCESS,
 *           the OBJECT type decides which overridden method RUNS.
 */

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

public class TypeCastPrimitiveAndNonPrimititve {

    public static void main(String[] args) {
        primitiveCasting();
        objectCasting();
    }

    static void primitiveCasting() {
        int i = 100;
        long l = i;          // widening - automatic
        double d = l;        // widening - automatic
        System.out.println("widening : " + i + " -> " + l + " -> " + d);

        double price = 99.99;
        int rounded = (int) price;   // narrowing - decimal part is cut, NOT rounded
        System.out.println("narrowing 99.99 -> " + rounded);

        int big = 130;
        byte small = (byte) big;     // byte range is -128..127, so value overflows
        System.out.println("overflow (byte) 130 -> " + small);   // -126

        char ch = 'A';
        int ascii = ch;              // char -> int is widening
        System.out.println("'A' as int -> " + ascii);            // 65

        // Autoboxing / unboxing (primitive <-> wrapper) is done by the compiler
        Object obj = 45;             // int -> Integer (autoboxing) -> Object (upcasting)
        int back = (Integer) obj;    // downcast to Integer, then auto-unbox to int
        System.out.println("Object -> int : " + back);
    }

    static void objectCasting() {
        A refA = createC();          // UPCASTING: C object held by an A reference
        System.out.println("refA.x = " + refA.x);
        // refA.s1  -> compile error: reference type A does not know about s1

        if (refA instanceof C) {     // check before downcasting
            C refC = (C) refA;       // DOWNCASTING: now all fields are accessible
            System.out.println("refC : " + refC.s1 + " " + refC.c1 + " " + refC.x);
        }

        A pureA = new A();
        try {
            C wrong = (C) pureA;     // compiles, but the object is only an A
            System.out.println(wrong);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException : an A object is not a C");
        }

        System.out.println("refA instanceof A = " + (refA instanceof A)
                + ", instanceof B = " + (refA instanceof B)
                + ", instanceof C = " + (refA instanceof C));
    }

    static C createC() {
        C c = new C();
        c.s1 = "ABC";
        c.s2 = "xyz";
        c.c1 = 'A';
        c.c2 = 'B';
        c.x = 10;
        c.y = 20;
        return c;
    }
}
