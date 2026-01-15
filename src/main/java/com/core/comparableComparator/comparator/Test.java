package com.core.comparableComparator.comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		Set<Employee> semp = null;
		// creted ref var of interface set of geenric <employee> type
		// but stored no obj of implemented class
		System.out.println("enter 1 or 2 or 3");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();

		if (ch == 1) {
			// normally new TressSet<>(); used to creste obj of
			// impl class TreeSet<>();

			semp = new TreeSet<>(new IdSort());
			// called par constructor of class TreeSet
			// & created obj of interface Set using impl class TreeSet
		} else if (ch == 2) {
			semp = new TreeSet<>(new NameSort());
		} else if (ch == 3) {
			semp = new TreeSet<Employee>(new AgeSort());
		}

		Employee e1 = new Employee(18, "dfg", 34);
		Employee e2 = new Employee(13, "fhgdfs", 37);
		Employee e3 = new Employee(20, "ryrt", 23);

		semp.add(e1);
		semp.add(e2);
		semp.add(e3);

		System.out.println("Sorted addedd set : "+semp);

	}
}

@Data
@AllArgsConstructor
class Employee
{
	private int id;
	private String name;
	private int age;

}

class IdSort implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1,Employee o2)
	{
		return o1.getId()-o2.getId();
	}
}
class NameSort implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1,Employee o2)
	{
		return o1.getName().compareTo(o2.getName());
	}
}

class AgeSort implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1,Employee o2)
	{
		return o1.getAge()-o2.getAge();
	}
}
