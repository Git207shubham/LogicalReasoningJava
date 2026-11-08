package com.logical;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class MyMapTest {

	static class Employee {
		private final int id;
		private final String name;
		private final double salary;
		private final String gender;

		Employee(int id, String name, double salary, String gender) {
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.gender = gender;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + "]";
		}
	}

	public static void employeeMapExample() {

		List<Employee> employeeList = new ArrayList<>();
		// Add some employees to the list
		employeeList.add(new Employee(2, "Jane Smith", 60000.0, "Female"));
		employeeList.add(new Employee(3, "Bob Johnson", 55000.0, "Male"));
		employeeList.add(new Employee(5, "Mary Johnson", 54000.0, "Female"));
		employeeList.add(new Employee(6, "David Lee", 58000.0, "Male"));
		employeeList.add(new Employee(7, "Linda White", 51000.0, "Female"));
		employeeList.add(new Employee(8, "Michael Smith", 63000.0, "Male"));
		employeeList.add(new Employee(4, "Alice Brown", 62000.0, "Female"));
		employeeList.add(new Employee(1, "John Doe", 50000.0, "Male"));

		System.out.println(employeeList);

		// LinkedHashMap keeps insertion order (HashMap does not)
		Map<Integer, Employee> emap = new LinkedHashMap<>();
		for (Employee e : employeeList) {
			emap.put(e.getId(), e);
		}

		System.out.println(emap);

		emap.entrySet().stream()
				.forEach(entry -> System.out.println("EMP-ID : " + entry.getKey() + " Employee " + entry.getValue()));

		// e2 - e1 -> sorts by key in DESCENDING order (e1 - e2 would be ascending)
		// same as Map.Entry.comparingByKey(Comparator.reverseOrder())
		Comparator<Entry<Integer, Employee>> comparator = (e1, e2) ->e2.getKey()- e1.getKey() ;

		emap.entrySet().stream().sorted(comparator)
				.forEach(entry -> System.out.println("EMP-ID: " + entry.getKey() + " Employee " + entry.getValue()));

	}
	
	public static void main(String[] args) {
		
		Map<String, Integer> scoresMap = new HashMap<>();
		scoresMap.put("Alice", 95);
		scoresMap.put("Bobd", 88);

		Integer valueAdded = scoresMap.put("Chardlie", 92);
		// returns previously associated or null if newly added

		// adds only if the key is missing; "Alice" exists, so value stays 95 and 95 is returned
		// (returns null if the key was absent and the value was added)
		scoresMap.putIfAbsent("Alice", 105);

		boolean flag1 = scoresMap.containsKey("Bobd");
		boolean flag2 = scoresMap.containsValue(95);


		Set<Entry<String, Integer>> entrySet = scoresMap.entrySet();

		System.out.println(entrySet);

		// printls entry set with key containing
		scoresMap.entrySet().stream().filter(entrySet1 -> entrySet1.getKey().contains("d"))
				.forEach((b) -> System.out.println(b));

		// printls entry set with value>90
		scoresMap.entrySet().stream().filter(entrySet2 -> entrySet2.getValue() > 90)
				.forEach((b) -> System.out.println(b));

		System.out.println(scoresMap.entrySet().stream().collect(Collectors.toList()));

		// prints key and value..forEach method in map takes Biconsumer
		scoresMap.forEach((key, value) -> System.out.println("key : " + key + " VALUE " + value));

		employeeMapExample();
	}

}
