package com.logical.Java8;

import java.util.*;
import java.util.stream.*;

public class StreamExamples2 {

    public static void main(String[] args) {

                // 1. Filter Even Numbers from a List
                // Question: Given a list of integers, filter the even numbers.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
                    List<Integer> evenNumbers = numbers.stream()
                            .filter(n -> n % 2 == 0)
                            .collect(Collectors.toList());
                    System.out.println(evenNumbers); // Output: [2, 4, 6]
                }

                // 2. Find Maximum in a List
                // Question: Find the maximum number from a list of integers.
                {
                    List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
                    int maxNumber = numbers.stream()
                            //.max(Integer::compare)
                            .max(Comparator.reverseOrder())
                            .orElseThrow(NoSuchElementException::new);
                    System.out.println(maxNumber); // Output: 50
                }

                // 3. Sort a List
                // Question: Sort a list of integers in descending order.
                {
                    List<Integer> numbers = Arrays.asList(3, 5, 1, 4, 2);
                    List<Integer> sortedNumbers = numbers.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList());
                    System.out.println(sortedNumbers); // Output: [5, 4, 3, 2, 1]
                }

                // 4. Count Strings with Specific Prefix
                // Question: Count strings starting with a specific prefix, e.g., "A".
                {
                    List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
                    long count = names.stream()
                            .filter(name -> name.startsWith("A"))
                            .count();
                    System.out.println(count); // Output: 3
                }

                // 5. Find First Non-Repeated Character in a String
                // Question: Find the first non-repeated character in a string.
                {
                    String input = "swiss";
                    Optional<Character> firstNonRepeated = input.chars()
                            .mapToObj(c -> (char) c)
                            .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                            .findFirst();
                    System.out.println(firstNonRepeated.orElse(null)); // Output: w
                }

                // 6. Convert List of Strings to Uppercase
                // Question: Convert all strings in a list to uppercase.
                {
                    List<String> names = Arrays.asList("java", "stream", "api");
                    List<String> uppercaseNames = names.stream()
                            .map(String::toUpperCase)
                            .collect(Collectors.toList());
                    System.out.println(uppercaseNames); // Output: [JAVA, STREAM, API]
                }

                // 7. Sum of Numbers in a List
                // Question: Calculate the sum of all numbers in a list.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
                    int sum = numbers.stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    System.out.println(sum); // Output: 15
                }

                // 8. Check if Any String Matches a Condition
                // Question: Check if any string in a list contains "API".
                {
                    List<String> strings = Arrays.asList("Java", "Stream API", "Lambda");
                    boolean containsAPI = strings.stream()
                            .anyMatch(s -> s.contains("API"));
                    System.out.println(containsAPI);
                }

                // 9. Find Duplicate Elements in a List
                // Question: Identify duplicate elements in a list.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
                    Set<Integer> unique = new HashSet<>();
                    Set<Integer> duplicates = numbers.stream()
                            .filter(n -> !unique.add(n))
                            .collect(Collectors.toSet());
                    System.out.println(duplicates); // Output: [1, 2]
                }

                // 10. Group Strings by Length
                // Question: Group a list of strings based on their length.
                {
                    List<String> words = Arrays.asList("Java", "Stream", "API", "Code", "Fun");
                    Map<Integer, List<String>> groupedByLength = words.stream()
                            .collect(Collectors.groupingBy(String::length));
                    System.out.println(groupedByLength);
                    // Output: {3=[API], 4=[Java, Code, Fun], 6=[Stream]}
                }

                // 11. Flatten a List of Lists
                // Question: Given a list of lists, flatten it into a single list.
                {
                    List<List<Integer>> listOfLists = Arrays.asList(
                            Arrays.asList(1, 2, 3),
                            Arrays.asList(4, 5),
                            Arrays.asList(6, 7, 8, 9)
                    );
                    List<Integer> flattenedList = listOfLists.stream()
                            .flatMap(List::stream)
                            .collect(Collectors.toList());
                    System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
                }

                // 12. Concatenate Strings
                // Question: Concatenate all strings in a list into a single string.
                {
                    List<String> words = Arrays.asList("Stream", "API", "is", "powerful");
                    String concatenated = words.stream()
                            .reduce("", (s1, s2) -> s1 + " " + s2).trim();
                    System.out.println(concatenated); // Output: Stream API is powerful
                }

                // 13. Find the Longest String
                // Question: Find the longest string in a list.
                {
                    List<String> words = Arrays.asList("Java", "Stream", "API", "Development");
                    String longest = words.stream()
                            .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                            .orElse(null);
                    System.out.println(longest); // Output: Development
                }

                // 14. Count Frequency of Characters in a String
                // Question: Count the frequency of each character in a string.
                {
                    String input = "success";
                    Map<Character, Long> frequency = input.chars()
                            .mapToObj(c -> (char) c)
                            .collect(  Collectors.groupingBy(c -> c, Collectors.counting())  );
                    System.out.println(frequency); // Output: {s=3, u=1, c=2, e=1}
                }

//                // 15. Parallel Stream to Compute Sum
//                // Question: Use parallel streams to compute the sum of numbers.
//                {
//                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//                    int sum = numbers.parallelStream()
//                            .mapToInt(Integer::intValue)
//                            .sum();
//                    System.out.println(sum); // Output: 15
//                }

                // 16. Create Custom Collector
                // Question: Create a custom collector to join strings with a delimiter.
                {
                    List<String> words = Arrays.asList("Java", "Stream", "API");
                    String joined = words.stream()
                            .collect(Collectors.joining(", "));
                    System.out.println(joined); // Output: Java, Stream, API
                }

                // 17. Remove Null Values
                // Question: Remove null values from a list using filter.
                {
                    List<String> words = Arrays.asList("Java", null, "Stream", null, "API");
                    List<String> nonNullWords = words.stream()
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
                    System.out.println(nonNullWords); // Output: [Java, Stream, API]
                }

                // 18. Calculate Average of Numbers
                // Question: Calculate the average of a list of integers.
                {
                    List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
                    double average = numbers.stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(0.0);
                    System.out.println(average); // Output: 30.0
                }

                // 19. Collect Map from List
                // Question: Convert a list of strings into a map with the string as the key and its length as the value.
                {
                    List<String> words = Arrays.asList("Java", "Stream", "API");
                    Map<String, Integer> wordLengthMap = words.stream()
                            .collect(Collectors.toMap(word -> word, String::length));
                    System.out.println(wordLengthMap); // Output: {Java=4, Stream=6, API=3}
                }


                // 21. Find Nth Largest Element in a List
                // Question: Find the 3rd largest element in a list.
                {
                    List<Integer> numbers = Arrays.asList(10, 20, 50, 40, 30);
                    int nthLargest = numbers.stream()
                            .sorted(Comparator.reverseOrder())
                            .skip(2)
                            .findFirst()
                            .orElseThrow(NoSuchElementException::new);
                    System.out.println(nthLargest); // Output: 30
                }

                // 22. Find All Palindromic Strings
                // Question: Find all strings that are palindromes in a list.
                {
                    List<String> words = Arrays.asList("radar", "level", "world", "java");
                    List<String> palindromes = words.stream()
                            .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                            .collect(Collectors.toList());
                    System.out.println(palindromes); // Output: [radar, level]
                }

                // 23. Reverse Each String in a List
                // Question: Reverse each string in a list.
                {
                    List<String> words = Arrays.asList("Java", "Stream", "API");
                    List<String> reversedWords = words.stream()
                            .map(word -> new StringBuilder(word).reverse().toString())
                            .collect(Collectors.toList());
                    System.out.println(reversedWords); // Output: [avaJ, maertS, IPA]
                }

                // 24. Filter and Convert Map to List
                // Question: Given a map, filter entries with values greater than 10 and collect keys into a list.
                {
                    Map<String, Integer> map = Map.of("A", 5, "B", 15, "C", 10, "D", 20);
                    List<String> keys = map.entrySet().stream()
                            .filter(entry -> entry.getValue() > 10)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toList());
                    System.out.println(keys); // Output: [B, D]
                }

                // 25. Remove Duplicates Without Collectors
                // Question: Remove duplicates from a list using distinct().
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
                    List<Integer> uniqueNumbers = numbers.stream()
                            .distinct()
                            .collect(Collectors.toList());
                    System.out.println(uniqueNumbers); // Output: [1, 2, 3, 4, 5]
                }

                // 26. Find the Most Frequent Character in a String
                // Question: Find the most frequent character in a string.
                {
                    String input = "success";
                    char mostFrequent = input.chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                            .entrySet().stream()
                            .max(Map.Entry.comparingByValue())
                            .map(Map.Entry::getKey)
                            .orElseThrow(NoSuchElementException::new);
                    System.out.println(mostFrequent); // Output: s
                }

                // 27. Find Common Elements Between Two Lists
                // Question: Find common elements between two lists.
                {
                    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
                    List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
                    List<Integer> common = list1.stream()
                            .filter(list2::contains)
                            .collect(Collectors.toList());
                    System.out.println(common); // Output: [3, 4, 5]
                }

                // 28. Find the Sum of Squares of Even Numbers
                // Question: Calculate the sum of squares of all even numbers in a list.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
                    int sumOfSquares = numbers.stream()
                            .filter(n -> n % 2 == 0)
                            .mapToInt(n -> n * n)
                            .sum();
                    System.out.println(sumOfSquares); // Output: 56 (2^2 + 4^2 + 6^2)
                }

                // 29. Partition Strings by Palindrome
                // Question: Partition strings into palindromes and non-palindromes.
                {
                    List<String> words = Arrays.asList("radar", "level", "java", "stream");
                    Map<Boolean, List<String>> partitioned = words.stream()
                            .collect(Collectors.partitioningBy(word -> word.equals(new StringBuilder(word).reverse().toString())));
                    System.out.println(partitioned);
                    // Output: {false=[java, stream], true=[radar, level]}
                }

                // 30. Skip and Limit Elements
                // Question: Skip the first 3 elements and limit the result to the next 2.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
                    List<Integer> result = numbers.stream()
                            .skip(3)
                            .limit(2)
                            .collect(Collectors.toList());
                    System.out.println(result); // Output: [4, 5]
                }

                // 31. Find the Longest Word from a Sentence
                // Question: Find the longest word in a sentence using Streams.
                {
                    String sentence = "Java Stream API is very powerful";
                    String longestWord = Arrays.stream(sentence.split(" "))
                            .max(Comparator.comparingInt(String::length))
                            .orElse(null);
                    System.out.println(longestWord); // Output: powerful
                }

                // 32. Compute Cartesian Product of Two Lists
                // Question: Compute the Cartesian product of two lists of integers.
                {
                    List<Integer> list1 = Arrays.asList(1, 2, 3);
                    List<Integer> list2 = Arrays.asList(4, 5);
                    List<String> cartesianProduct = list1.stream()
                            .flatMap(i -> list2.stream().map(j -> "(" + i + "," + j + ")"))
                            .collect(Collectors.toList());
                    System.out.println(cartesianProduct); // Output: [(1,4), (1,5), (2,4), (2,5), (3,4), (3,5)]
                }

                // 33. Find Top N Highest Scoring Students
                // Question: From a list of students, find the top 3 by score.
                {
                    class Student {
                        String name;
                        int score;
                        Student(String name, int score) { this.name = name; this.score = score; }
                    }

                    List<Student> students = Arrays.asList(
                            new Student("Alice", 85),
                            new Student("Bob", 92),
                            new Student("Charlie", 88),
                            new Student("Dave", 78),
                            new Student("Eve", 91)
                    );

                    List<String> topStudents = students.stream()
                            .sorted(Comparator.comparingInt((Student s) -> s.score).reversed())
                            .limit(3)
                            .map(s -> s.name)
                            .collect(Collectors.toList());
                    System.out.println(topStudents); // Output: [Bob, Eve, Charlie]
                }

                // 34. Group by First Character
                // Question: Group a list of strings by their first character.
                {
                    List<String> words = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry");
                    Map<Character, List<String>> groupedByFirstChar = words.stream()
                            .collect(Collectors.groupingBy(word -> word.charAt(0)));
                    System.out.println(groupedByFirstChar);
                    // Output: {a=[apple, avocado], b=[banana, blueberry], c=[cherry]}
                }

                // 35. Custom Reduce to Concatenate Strings
                // Question: Concatenate strings in reverse order using reduce.
                {
                    List<String> words = Arrays.asList("Stream", "API", "is", "awesome");
                    String reversedConcatenation = words.stream()
                            .reduce((w1, w2) -> w2 + " " + w1)
                            .orElse("");
                    System.out.println(reversedConcatenation); // Output: awesome is API Stream
                }

                // 36. Find Median of a List
                // Question: Find the median of a list of integers.
                {
                    List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 5);
                    List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
                    double median = (sorted.size() % 2 == 0)
                            ? (sorted.get(sorted.size() / 2 - 1) + sorted.get(sorted.size() / 2)) / 2.0
                            : sorted.get(sorted.size() / 2);
                    System.out.println(median); // Output: 3.0
                }

                // 37. Collect Nested Map by Grouping
                // Question: Group employees by department and then by age.
                {
                    class Employee {
                        String name, department;
                        int age;
                        Employee(String name, String department, int age) {
                            this.name = name;
                            this.department = department;
                            this.age = age;
                        }
                    }

                    List<Employee> employees = Arrays.asList(
                            new Employee("Alice", "HR", 25),
                            new Employee("Bob", "IT", 30),
                            new Employee("Charlie", "HR", 30),
                            new Employee("Dave", "IT", 25)
                    );

                    Map<String, Map<Integer, List<String>>> grouped = employees.stream()
                            .collect(Collectors.groupingBy(e -> e.department,
                                    Collectors.groupingBy(e -> e.age,
                                            Collectors.mapping(e -> e.name, Collectors.toList()))));
                    System.out.println(grouped);
                    // Output: {HR={25=[Alice], 30=[Charlie]}, IT={30=[Bob], 25=[Dave]}}
                }

                // 38. Detect Cycles in a Graph-Like Structure
                // Question: Detect cycles in a list of parent-child relationships.
                {
                    class Node {
                        int id, parentId;
                        Node(int id, int parentId) {
                            this.id = id;
                            this.parentId = parentId;
                        }
                    }

                    List<Node> nodes = Arrays.asList(
                            new Node(1, 0), new Node(2, 1), new Node(3, 2), new Node(4, 3), new Node(5, 4), new Node(2, 5)
                    );

                    boolean hasCycle = nodes.stream()
                            .anyMatch(node -> nodes.stream().filter(n -> n.id == node.parentId).anyMatch(n -> n.id == node.id));
                    System.out.println(hasCycle); // Output: true
                }

                // 39. Find the Word with Maximum Vowels
                // Question: Find the word with the most vowels in a list.
                {
                    List<String> words = Arrays.asList("stream", "java", "programming", "awesome");
                    String wordWithMostVowels = words.stream()
                            .max(Comparator.comparingInt(word -> (int) word.chars().filter(c -> "aeiou".indexOf(c) != -1).count()))
                            .orElse(null);
                    System.out.println(wordWithMostVowels); // Output: programming
                }

                // 40. Compute Running Sum
                // Question: Compute the running sum of a list of integers.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
                    List<Integer> runningSum = IntStream.range(0, numbers.size())
                            .mapToObj(i -> numbers.subList(0, i + 1).stream().mapToInt(Integer::intValue).sum())
                            .collect(Collectors.toList());
                    System.out.println(runningSum); // Output: [1, 3, 6, 10, 15]
                }

                // 41. Generate Fibonacci Sequence Using Streams
                // Question: Generate the first N numbers in the Fibonacci sequence.
                {
                    int n = 10;
                    List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                            .limit(n)
                            .map(arr -> arr[0])
                            .collect(Collectors.toList());
                    System.out.println(fibonacci); // Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
                }

                // 42. Find Employees with Highest Salary in Each Department
                // Question: From a list of employees, find the highest-paid employee in each department.
                {
                    class Employee {
                        String name, department;
                        double salary;
                        Employee(String name, String department, double salary) {
                            this.name = name;
                            this.department = department;
                            this.salary = salary;
                        }
                    }

                    List<Employee> employees = Arrays.asList(
                            new Employee("Alice", "HR", 50000),
                            new Employee("Bob", "IT", 80000),
                            new Employee("Charlie", "IT", 75000),
                            new Employee("Dave", "HR", 60000),
                            new Employee("Eve", "Finance", 70000)
                    );

                    Map<String, Employee> highestPaid = employees.stream()
                            .collect(Collectors.groupingBy(
                                    e -> e.department,
                                    Collectors.collectingAndThen(
                                            Collectors.maxBy(Comparator.comparingDouble(e -> e.salary)),
                                            Optional::get
                                    )
                            ));
                    System.out.println(highestPaid);
                    // Output: {HR=Dave, IT=Bob, Finance=Eve}
                }

                // 43. Group Words by Length and Sort Them
                // Question: Group words by their length and sort each group alphabetically.
                {
                    List<String> words = Arrays.asList("java", "stream", "api", "example", "code", "test");
                    Map<Integer, List<String>> groupedAndSorted = words.stream()
                            .collect(Collectors.groupingBy(String::length, Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    list -> list.stream().sorted().collect(Collectors.toList())
                            )));
                    System.out.println(groupedAndSorted);
                    // Output: {4=[code, java, test], 3=[api], 6=[stream], 7=[example]}
                }

                // 44. Calculate the Product of All Numbers
                // Question: Calculate the product of all numbers in a list using reduce.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
                    int product = numbers.stream()
                            .reduce(1, (a, b) -> a * b);
                    System.out.println(product); // Output: 120
                }

                // 45. Sliding Window of N Elements
                // Question: Create a sliding window of size 3 for a list of integers.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
                    List<List<Integer>> slidingWindows = IntStream.range(0, numbers.size() - 2)
                            .mapToObj(i -> numbers.subList(i, i + 3))
                            .collect(Collectors.toList());
                    System.out.println(slidingWindows); // Output: [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6]]
                }

                // 46. Detect Anagrams in a List
                // Question: Detect all anagrams in a list of strings.
                {
                    List<String> words = Arrays.asList("listen", "silent", "enlist", "google", "elbow", "below");
                    Map<String, List<String>> anagrams = words.stream()
                            .collect(Collectors.groupingBy(
                                    word -> word.chars().sorted()
                                            .mapToObj(c -> String.valueOf((char) c))
                                            .collect(Collectors.joining())
                            ));
                    System.out.println(anagrams);
                    // Output: {eilnst=[listen, silent, enlist], eggloo=[google], below=[elbow, below]}
                }

                // 47. Generate a Pyramid Pattern
                // Question: Generate a pyramid of numbers using Streams.
                {
                    int levels = 5;
                    List<String> pyramid = IntStream.rangeClosed(1, levels)
                            .mapToObj(i -> String.join("", Collections.nCopies(levels - i, " ")) + IntStream.rangeClosed(1, i).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                            .collect(Collectors.toList());
                    pyramid.forEach(System.out::println);
                    // Output:
                    //     1
                    //    1 2
                    //   1 2 3
                    //  1 2 3 4
                    // 1 2 3 4 5
                }

                // 48. Find Maximum Path Sum in a Triangle
                // Question: Given a triangle of numbers, find the maximum path sum using Streams.
                {
                    List<List<Integer>> triangle = Arrays.asList(
                            Arrays.asList(3),
                            Arrays.asList(7, 4),
                            Arrays.asList(2, 4, 6),
                            Arrays.asList(8, 5, 9, 3)
                    );

                    int maxPathSum = IntStream.range(0, triangle.size())
                            .mapToObj(i -> triangle.get(triangle.size() - 1 - i))
                            .reduce((rowBelow, currentRow) -> IntStream.range(0, currentRow.size())
                                    .mapToObj(j -> currentRow.get(j) + Math.max(rowBelow.get(j), rowBelow.get(j + 1)))
                                    .collect(Collectors.toList()))
                            .orElse(List.of()).get(0);
                    System.out.println(maxPathSum); // Output: 23
                }

                // 49. Find Non-Repeating Characters in a String
                // Question: Find all non-repeating characters in a string.
                {
                    String input = "swiss";
                    List<Character> nonRepeating = input.chars()
                            .mapToObj(c -> (char) c)
                            .filter(c -> input.chars().filter(ch -> ch == c).count() == 1)
                            .collect(Collectors.toList());
                    System.out.println(nonRepeating); // Output: [w, i]
                }

                // 50. Find All Subsequences of a String
                // Question: Generate all subsequences of a string.
                {
                    String str = "abc";
                    List<String> subsequences = IntStream.range(0, 1 << str.length())
                            .mapToObj(i -> IntStream.range(0, str.length())
                                    .filter(j -> (i & (1 << j)) != 0)
                                    .mapToObj(j -> String.valueOf(str.charAt(j)))
                                    .collect(Collectors.joining()))
                            .collect(Collectors.toList());
                    System.out.println(subsequences); // Output: [, a, b, ab, c, ac, bc, abc]
                }

                // 51. Count Frequency of Characters in a String
                // Question: Count the frequency of each character in a string.
                {
                    String input = "success";
                    Map<Character, Long> charFrequency = input.chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                    System.out.println(charFrequency); // Output: {s=3, u=1, c=2, e=1}
                }

                // 52. Flatten a Nested List
                // Question: Flatten a list of lists into a single list.
                {
                    List<List<Integer>> nestedList = Arrays.asList(
                            Arrays.asList(1, 2, 3),
                            Arrays.asList(4, 5),
                            Arrays.asList(6, 7, 8, 9)
                    );
                    List<Integer> flatList = nestedList.stream()
                            .flatMap(List::stream)
                            .collect(Collectors.toList());
                    System.out.println(flatList); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
                }

                // 53. Find Duplicate Elements in a List
                // Question: Identify all duplicate elements in a list.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);
                    Set<Integer> duplicates = numbers.stream()
                            .filter(n -> Collections.frequency(numbers, n) > 1)
                            .collect(Collectors.toSet());
                    System.out.println(duplicates); // Output: [2, 3]
                }

                // 54. Convert Map to List of Key-Value Pairs
                // Question: Convert a map to a list of "key=value" strings.
                {
                    Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);
                    List<String> keyValuePairs = map.entrySet().stream()
                            .map(entry -> entry.getKey() + "=" + entry.getValue())
                            .collect(Collectors.toList());
                    System.out.println(keyValuePairs); // Output: [A=1, B=2, C=3]
                }

                // 55. Check if a List is Sorted
                // Question: Verify if a list is sorted in ascending order.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
                    boolean isSorted = IntStream.range(0, numbers.size() - 1)
                            .allMatch(i -> numbers.get(i) <= numbers.get(i + 1));
                    System.out.println(isSorted); // Output: true
                }

                // 56. Find All Subarrays of a List
                // Question: Generate all contiguous subarrays of a list.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3);
                    List<List<Integer>> subarrays = IntStream.range(0, numbers.size())
                            .boxed()
                            .flatMap(i -> IntStream.rangeClosed(i + 1, numbers.size())
                                    .mapToObj(j -> numbers.subList(i, j)))
                            .collect(Collectors.toList());
                    System.out.println(subarrays); // Output: [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
                }

                // 57. Combine Two Lists into a Map
                // Question: Combine two lists into a map where one is keys and the other values.
                {
                    List<String> keys = Arrays.asList("A", "B", "C");
                    List<Integer> values = Arrays.asList(1, 2, 3);
                    Map<String, Integer> map = IntStream.range(0, keys.size())
                            .boxed()
                            .collect(Collectors.toMap(keys::get, values::get));
                    System.out.println(map); // Output: {A=1, B=2, C=3}
                }

                // 58. Find Pair of Numbers with a Given Sum
                // Question: Find all pairs of numbers from a list that add up to a given sum.
                {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
                    int targetSum = 6;
                    List<List<Integer>> pairs = numbers.stream()
                            .flatMap(a -> numbers.stream()
                                    .filter(b -> a + b == targetSum && a < b)
                                    .map(b -> Arrays.asList(a, b)))
                            .collect(Collectors.toList());
                    System.out.println(pairs); // Output: [[1, 5], [2, 4]]
                }

                // 59. Generate Random Numbers Using Stream
                // Question: Generate a list of random numbers using Stream.
                {
                    List<Integer> randomNumbers = new Random().ints(5, 1, 100) // 5 numbers in range 1-100
                            .boxed()
                            .collect(Collectors.toList());
                    System.out.println(randomNumbers); // Example Output: [45, 23, 89, 12, 78]
                }

                // 60. Find Longest Increasing Subsequence
                // Question: Find the longest increasing subsequence in a list.
                {
                    List<Integer> numbers = Arrays.asList(10, 9, 2, 5, 3, 7, 101, 18);
                    List<Integer> lis = new ArrayList<>();
                    numbers.forEach(num -> {
                        int pos = Collections.binarySearch(lis, num);
                        if (pos < 0) pos = -(pos + 1);
                        if (pos < lis.size()) lis.set(pos, num);
                        else lis.add(num);
                    });
                    System.out.println(lis); // Output: [2, 3, 7, 101]
                }

                // 61. Sort a List Based on Frequency of Elements
                // Question: Sort a list based on the frequency of elements in descending order.
                {
                    List<Integer> numbers = Arrays.asList(4, 5, 6, 5, 4, 3);
                    List<Integer> sortedByFrequency = numbers.stream()
                            .sorted(Comparator.comparingInt(n -> -Collections.frequency(numbers, n)))
                            .distinct()
                            .collect(Collectors.toList());
                    System.out.println(sortedByFrequency); // Output: [4, 5, 6, 3]
                }

                // 62. Convert List of Strings to Sentence Case
                // Question: Convert a list of strings to sentence case.
                {
                    List<String> words = Arrays.asList("java", "stream", "api");
                    List<String> sentenceCase = words.stream()
                            .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                            .collect(Collectors.toList());
                    System.out.println(sentenceCase); // Output: [Java, Stream, Api]
                }
            }
        }
