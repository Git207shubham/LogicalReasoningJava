package com.core.clonable;

// Cloneable is a marker interface (no methods) - it just allows Object.clone() to work
// shallow copy is fine here: int is copied, and String is immutable so sharing it is safe
class Person implements Cloneable {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
}

