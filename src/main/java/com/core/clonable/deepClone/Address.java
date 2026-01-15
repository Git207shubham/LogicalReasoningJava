package com.core.clonable.deepClone;

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
        Employee emp = (Employee) super.clone();
        emp.address = new Address(this.address.city);
        // deep copy by creating a Primitive reference object and initialising ie
        // assigning the values of its variables
        // from current object which is being copied
        return emp;
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

