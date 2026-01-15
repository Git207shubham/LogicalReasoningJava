package com.core.clonable.shalowCopy;

/*Primitive fields → copied in seperate locations
        Object references → shared*/

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Employee implements Cloneable {
    int id;
    Address address;

    Employee(int id, Address address) {
        this.id = id;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
}


class Test {
    public static void main(String[] args) throws Exception {
        Address addr = new Address("Mumbai");
        Employee e1 = new Employee(1, addr);
        Employee e2 = (Employee) e1.clone();

        e2.address.city = "Pune";

        System.out.println(e1.address.city); // Pune ❌
    }
}