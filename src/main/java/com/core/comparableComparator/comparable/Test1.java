package com.core.comparableComparator.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private int age;

	// implementing methods of interface Comparable
	@Override
	public int compareTo(Employee emp) {

		 return this.id - emp.id; // so ascending
		// return id - this.id; //----descending

		// return this.name - emp.name;
		// ---cant use minus sign for name so below approach BUT why becoz it should
		// compareTo of String substract ASCII value ???

		//return emp.name.compareTo(this.name); // descending
	}
}

public class Test1 {

	public static void main(String[] args) {
		Employee e1 = new Employee(233,"sss",33);
		Employee e2 = new Employee(846,"abd",23);
		Employee e3 = new Employee(126,"rtp",29);

		Set<Employee> eSet = new TreeSet<>();

		// sorting happens while adding only
		eSet.add(e1);// call compareTo(Employee1 emp)
		eSet.add(e2);// call compareTo(Employee1 emp)
		eSet.add(e3); // this.id has e2 data is globala wala and emp.id has passed data by s.add(e1);

		System.out.println(eSet);


	}
}
