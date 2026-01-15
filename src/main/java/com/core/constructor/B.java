package com.core.constructor;

class B extends A {

    int y;

    // 3️⃣ No-arg constructor
    B() {
        super(); // calls A()
        this.y = 20;
        System.out.println("B: no-arg constructor, y = " + y);
    }

    // 4️⃣ Parameterized constructor
    B(int x, int y) {
        super(x);      // calls A(int)
        this.y = y;
        System.out.println("B: parameterized constructor, y = " + y);
    }
}
