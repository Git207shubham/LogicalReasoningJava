package com.logical.collection.list;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.LinkedList;

public class CollSortOnlyForComparableObjects {
	public static void main(String[] args) {


		LinkedList<Student> list = new LinkedList<Student>();
		list.add(new Student("Meet", 102, 2));
		list.add(new Student("Jhon", 103, 5));
		list.add(new Student("Sham", 101, 1));
		list.add(new Student("William", 107, 3));
		list.add(new Student("Harry", 109, 4));

		System.out.println("UnSorted LinkedList " + list);
		Collections.sort(list);
		System.out.println("Sorted LinkedList " + list);

		Collections.reverse(list);
		System.out.println("Sorted LinkedList reverse " + list);

		Collections.sort(list, Collections.reverseOrder());
		System.out.println("Sorted List : " + list);

		Comparator<Student> comparator1=(s1,s2)->{return s1.Id-s2.Id;}  ;
		
		Comparator<Student> comparator2=(s1,s2)->{return s1.Rank-s2.Rank;}  ;
		
		Comparator<Student> comparator3=(s1,s2)->{return s1.Name.compareTo(s2.Name) ;}  ;
		
		Collections.sort(list,comparator1);
		System.out.println(list);
		
		// anonymous inner class
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {

				return o1.Id-o2.Id;
			};
		});
		
	}


}


@Data
@AllArgsConstructor
class Student implements Comparable<Student> {
	public  String Name;
	public int Id;
	public int Rank;
	@Override
	public int compareTo(Student s) {
		return Name.compareTo(s.Name);
	}
}
