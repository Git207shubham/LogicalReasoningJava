package set;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetWithComparatorConstructorTakesObjects {

	public static void main(String[] args) {
	
		Set<Employee> semp = null;

		System.out.println("enter 1 or 2 or 3");
		Scanner sc = new Scanner(System.in);

		int ch = sc.nextInt();

		if (ch == 1) {
			semp = new TreeSet<>(new IdSort());
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

	}
}

@Data
@AllArgsConstructor
class Employee {
	private int id;
	private String name;
	private int age;

}

class AgeSort implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1,Employee o2)
	{
		return o1.getAge()-o2.getAge();
	}
}
class IdSort implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1,Employee o2)
	{
		// o1 is new obj passed by add method
		// o2 is old fisrt obj stored
//		System.out.println(o1.getId());
//		System.out.println("");
//		System.out.println(o2.getAge());
//		System.out.println("");
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