package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streamm {

	public static void main(String[] args) {

		// min form array
		Integer[] array = { 1, 4, 23, 5, 76, -23, 13, 64 };

		Comparator<Integer> integerComparator = (i1, i2) -> i1 - i2;

		Integer ii = Stream.of(array).min(integerComparator)
				.orElseThrow(() -> new IllegalArgumentException("Array is empty"));

		System.out.println(ii);

		int[] array11 = { 1, 4, 23, 5, 76, -23, 13, 64 };

		// IntStream
		IntStream iii = Arrays.stream(array11);
		// .min().orElseThrow(() -> new IllegalArgumentException("Array is empty"));
		System.out.println(iii);

		List<Integer> list = new ArrayList<>(Arrays.asList(22, 33, 44, 11));

		Stream<Integer> sss = list.stream();

		char[] ar9 = { 'a', 's', 'w', 's', 'k', 'p' };
		// System.out.println(Arrays.toString(ar3));

		Stream<char[]> ss = Stream.of(ar9);

		long count = ss.count();
		System.out.println("count : " + count);

		// max in IntStream class doesn't take Comparator
		int array3[] = { 22, 32, 12, 45, 25 };
		System.out.println(Arrays.stream(array3).max());

		// max in Stream class takes Comparator
		Integer array4[] = { 22, 32, 12, 45, 25 };
		// System.out.println(Arrays.stream(array4).max());

		Integer array5[] = { 22, 32, 12, 45, 25 };
		System.out.println(Arrays.stream(array5).max((a, b) -> a.compareTo(b)));

		// *********************************************************************************************************

		// array from stream
		List<Integer> li = Arrays.asList(3, 4, 5, 6, 3, 4);

		Integer[] asr2 = li.stream().toArray(Integer[]::new);
		System.out.println(Arrays.toString(asr2));

		System.out.println(Arrays.toString(asr2));

		// ======

		System.out.println();

		System.out.println("o/p : " + li.stream().allMatch(x -> x % 2 == 0)); // terminal
		System.out.println();
		System.out.println("o/p : " + li.stream().noneMatch(x -> x % 2 == 0)); // terminal
		System.out.println();

		System.out.println("o/p : " + li.stream().max(integerComparator)); // terminal
		System.out.println();

		System.out.println("o/p : " + li.stream().min(integerComparator)); // terminal
		System.out.println();

		System.out.println("o/p : " + li.stream().count()); // terminal
		System.out.println();

		li.stream().forEach(System.out::println); // terminal
		System.out.println();

		list.sort(integerComparator);

		// Convert Stream<Integer> to IntStream...
		System.out.println("sum from IntStream : " + li.stream().mapToInt(Integer::intValue).sum()); // terminal

		System.out
				.println("average from IntStream : " + li.stream().mapToInt(Integer::intValue).average().getAsDouble()); // terminal

		// *********************************************************************************************************

// convert List<String> to Map<String,length>

		List<String> stringList1 = new ArrayList<>(
				Arrays.asList("Hello", "World", "Java", "Programming", "Jokes", "Java"));

		Map<String, Integer> map = new HashMap<>();

		map = stringList1.stream().collect(Collectors.toMap(x -> x, x -> x.length()));
		System.out.println(map);

// ===
		List<String> stringList = new ArrayList<>(
				Arrays.asList("Hello", "World", "Java", "Programming", "Jokes", "Java"));

		Optional<String> ss12 = stringList.stream().filter(st -> st.startsWith("J")).findFirst();

		System.out.println(stringList.stream().map((x) -> x.length()).count());

		stringList.stream().distinct().forEach(x -> System.out.println(x));

		System.out.println(stringList.stream().allMatch((aa) -> aa.contains("x")));
		System.out.println(stringList.stream().anyMatch((aa) -> aa.contains("x")));
		System.out.println(stringList.stream().noneMatch((aa) -> aa.contains("x")));

		System.out.println(stringList.stream().sorted().skip(3).limit(2).toArray());

		Comparator<String> com = (s1, s2) -> s2.compareTo(s1);
		System.out.println(stringList.stream().sorted(com).toArray());

		System.out.println(stringList.stream().sorted(Collections.reverseOrder()).toArray());

//  parallel

		System.out.println(" random : " + stringList.stream().parallel().filter(x -> x.length() == 5).findAny());

		System.out.println(" random : " + stringList.stream().parallel().filter(x -> x.length() == 5).findAny()
				.orElseThrow(() -> new ArithmeticException()));

// interview questions -- 1

		List<Employee> employeeList = new ArrayList<>();

		Employee employee1 = new Employee(1, "John Doe", 30, 50000.0, Gender.MALE);
		Employee employee2 = new Employee(2, "Jane Smith", 28, 55000.0, Gender.FEMALE);
		Employee employee3 = new Employee(3, "Peter Ryan", 35, 60000.0, Gender.MALE);
		Employee employee4 = new Employee(3, "Lim Hoon", 33, 45000.0, Gender.OTHER);
		Employee employee5 = new Employee(3, "Bob Johnson", 41, 73000.0, Gender.MALE);

		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);

		Comparator<Employee> salaryComparator = (s1, s2) -> {
			return (int) (s1.getSalary() - s2.getSalary());
		};

		Comparator<Employee> ageComparator = (s1, s2) -> {
			return (int) (s1.getAge() - s2.getAge());
		};

		System.out.println(employeeList.stream().sorted(salaryComparator).skip(3).findFirst().get());

		System.out.println(employeeList.stream().map(e -> {
			if ((e.getAge()) > 33) {
				e.setSalary(e.getSalary() * 2);
			}
			return e;
		}).collect(Collectors.toList()));

		System.out.println(employeeList.stream().sorted(ageComparator.reversed()).collect(Collectors.toList()));

		employeeList.stream().max(ageComparator).ifPresent(System.out::println);

		employeeList.stream().collect(Collectors.groupingBy(Employee::getGender));

	}
}
