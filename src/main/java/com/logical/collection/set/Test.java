package com.logical.collection.set;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

public class Test {

    //TreeSetTakesComparableObjects
    public static void main(String[] args) {

        Employee e1 = new Employee(233, "sss", 33);
        Employee e2 = new Employee(133, "aaa", 53);
        Employee e3 = new Employee(356, "ddd", 12);

        Set<Employee> s = new TreeSet<>();
        // add method take Comparable only
        // otherwise throws cant cast from Employee to Comparable

        s.add(e1);
        s.add(e2);
        s.add(e3);
        System.out.println("set : " + s);
    }
}

@Data
@AllArgsConstructor
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;

    @Override
    public int compareTo(Employee emp) {
        // return this.name.compareTo(emp.name); // ascending
        return emp.name.compareTo(this.name); // descending
    }
}
