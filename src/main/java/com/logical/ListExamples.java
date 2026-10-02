package com.logical;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListExamples {

	public static void main(String[] args) {

		// non generic list of primititve data members i.e. of raw type
		// Auto boxing happens to respective data type
		//  -- if raw then Object , if generic then To the respective type
		// even if we are storing Integer , it doesnt become List of Integers , its still List of Objects only

		List myList1 = new ArrayList();
		myList1.add(31);
		myList1.add(32);
		myList1.add(33);
		myList1.add(34);
		myList1.add(35);

		System.out.println("list : " + myList1);
		System.out.println(myList1.get(0).getClass());

		// retrive elements using index number
		int number1 = (int) myList1.get(0);
		System.out.println(number1);

		Iterator iterator = myList1.iterator();
		while (iterator.hasNext()) {
			int x = (int) iterator.next();
			System.out.println(x);
		}

		// changes original structure of list
		Collections.sort(myList1);
		System.out.println(myList1);

		Collections.reverse(myList1);
		System.out.println(myList1);


		Object[] objectArray = (Integer[])myList1.toArray();
		Stream.of(objectArray).forEach(System.out::println);


		// list to array conversion
		Object[] objectArray = myList1.stream().toArray(Integer[]::new);
		System.out.println("array type Integer "+(objectArray instanceof Integer[]));
		System.out.println("array type PObject "+(objectArray instanceof Object[]));


		Integer[] integerArray = (Integer[]) myList1.stream().toArray(Integer[]::new);
		System.out.println("hello...."+integerArray[0].getClass());
		Stream.of(integerArray).forEach(System.out::println);

		//myList1.stream().filter(a -> a - 5 == 1).forEach((st) -> System.out.println(st));
		//System.out.println("duplicate arraylist : " + li);

		// to remove duplicates from arraylist
		// store this list into hashset /linkedhashset
		Set hs21 = new LinkedHashSet<>(myList1);
		System.out.println("hashset fro  duplicate arraylist : " + hs21);
		// use stream api
		ArrayList<Integer> li22 = (ArrayList<Integer>) myList1.stream().distinct().collect(Collectors.toList());
		System.out.println("dupl removed arraylist using stream " + li22);
		System.out.println("original list : " + myList1);



		// WAYS TO ITERATE A LIST
		// 1. simple for loop...start woth 0 to list.size() for indexed collection only
		// 2. forEach() loop for non indexed as well
		// 3. iterator ..hasNext...next ....just forward iterate
		// 4. listiterator(list.size())....hasPrevious() ....previous()
		// 5. adv for loop ...requires Generic
		// list.forEach(consumer lambda);

		removeDuplicatedFromList();
		SortingArrayListOfStrings();
	}

	public static void removeDuplicatedFromList()
	{
		List<Integer> list2 = Arrays.asList(11,1,32,8, 3, 5, 2, 9, 3, 2);
		System.out.println("original list : " + list2);

		Set<Integer> ss = new LinkedHashSet<>(list2);
		System.out.println("Hello, World!  " + ss);

		// use stream api
		ArrayList<Integer> list3 = (ArrayList<Integer>) list2.stream().distinct().collect(Collectors.toList());
		System.out.println("dupl removed arraylist using stream " + list3);
	}

	public static void SortingArrayListOfStrings()
	{
		List<String> stringList = new ArrayList<>();
		stringList.add("Apple");
		stringList.add("Bananas");
		stringList.add("Chery");
		stringList.add("Grapes");
		stringList.add("Fig");

		// Sort the list using Collections.sort use internally Arrays.sort()
		Collections.sort(stringList);

		System.out.println(stringList);

		Comparator<String> comp = Collections.reverseOrder(); // returns a Comparator<T> generic type
		Collections.sort(stringList, comp);
		// same as --
		stringList.sort(comp);
		System.out.println(stringList);

		// Custom comparator
		Comparator<String> lengthComparator = (c1, c2) -> (c1.length() - c2.length());
		Collections.sort(stringList, lengthComparator);
		System.out.println(stringList);

		Set<String> ss=new TreeSet<>(Collections.reverseOrder());
		ss.addAll(stringList);
		System.out.println(ss);
	}

	public static void methodsInList()
	{
		List<String> list = new ArrayList<String>(Arrays.asList( "cc", "dd", "ee", "aa", "bb", "zz","dd" ) );

		List<String> list2 = Arrays.asList( "AA","CC","EE" );

		list.add("abc");

		list.add(2,"xyz");

		list.remove(3);

		list.remove("xyz");

		System.out.println(list);

		list.addAll(list2);

		list.addAll(6,list2);

		list.set(0,"shubham" );

		list.contains("shubham");

		System.out.println(list);

		list.indexOf("aa");   // gives index or -1

		list.lastIndexOf("aa");  // gives index or -1

		list.size();

		//list.clear();

		list.equals(list2);
		System.out.println(list);

		list.sort(Comparator.reverseOrder());
		System.out.println(list);

		list.isEmpty();

	}
}
