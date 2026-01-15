package com.core.constructor;

class C extends B {

    int z;

    // 5️⃣ No-arg constructor
    C() {
        this(5, 6, 7); // calls C(int,int,int)
        System.out.println("C: no-arg constructor");
    }

    // 6️⃣ Parameterized constructor
    C(int x, int y, int z) {
        super(x, y);   // calls B(int,int)
        this.z = z;
        System.out.println("C: parameterized constructor, z = " + z);
    }
}
