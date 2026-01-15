package com.core.comparableComparator.comparator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Data
@AllArgsConstructor
class Student 
{
	
	private String name;
	private double percentage;
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", percentage=" + percentage + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double d) {
		this.percentage = d;
	}	
}

class Test1
{
	public static void main(String[] args) {

		Student s1 = new Student("aaa", 90.91);
		Student s2 = new Student("ddd", 85.23);
		Student s3 = new Student("ccc", 87.23);


		List<Student> l2 = new ArrayList<>();
	
	l2.add(s1);
	l2.add(s2);
	l2.add(s3);
	
	// from util class since java 1.2
	Collections.sort(l2 , new SortedStudent());	
	System.out.println(l2);
	
	// default method in List interface from java 1.8
	l2.sort(new SortedStudent());
	System.out.println(l2);

	}
}

class SortedStudent implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2)
	{
		return (int) (o1.getPercentage()-o2.getPercentage());
	}

}

