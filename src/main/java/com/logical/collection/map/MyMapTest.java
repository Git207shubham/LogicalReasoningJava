package com.logical.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MyMapTest {

//	public static void main(String[] args) {
//		// Create a list of employees
//		List<Employee> employeeList = new ArrayList<>();
//
//		// Add some employees to the list
//		employeeList.add(new Employee(2, "Jane Smith", 60000.0, "Female"));
//		employeeList.add(new Employee(3, "Bob Johnson", 55000.0, "Male"));
//		employeeList.add(new Employee(5, "Mary Johnson", 54000.0, "Female"));
//		employeeList.add(new Employee(6, "David Lee", 58000.0, "Male"));
//		employeeList.add(new Employee(7, "Linda White", 51000.0, "Female"));
//		employeeList.add(new Employee(8, "Michael Smith", 63000.0, "Male"));
//		employeeList.add(new Employee(4, "Alice Brown", 62000.0, "Female"));
//		employeeList.add(new Employee(1, "John Doe", 50000.0, "Male"));
//		
//		System.out.println(employeeList);
//
//		Map<Integer, Employee> emap = new LinkedHashMap<>();
//		for (Employee e : employeeList) {
//			emap.put(e.getId(), e);
//		}
//		
//		System.out.println(emap);
//
//		emap.entrySet().stream()
//				.forEach(entry -> System.out.println("EMP-ID : " + entry.getKey() + " Employee " + entry.getValue()));
//
//		Comparator<Map.Entry<Integer, Employee>> comparator = (e1, e2) ->e2.getKey()- e1.getKey() ;
//
//		emap.entrySet().stream().sorted(comparator)
//				.forEach(entry -> System.out.println("EMP-ID: " + entry.getKey() + " Employee " + entry.getValue()));
//
//	}
	
	public static void main(String[] args) {
		
		Map<String, Integer> scoresMap = new HashMap<>();
		scoresMap.put("Alice", 95);
		scoresMap.put("Bobd", 88);

		Integer valueAdded = scoresMap.put("Chardlie", 92);
		// returns previously associated or null if newly added

		scoresMap.putIfAbsent("Alice", 105); // return null if

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
	}

}
