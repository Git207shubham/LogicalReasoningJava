package com.logical;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/*
 * ONE FILE, MANY DEMO CLASSES.
 * A .java file may contain only ONE public class (and its name must match the file name).
 * All classes below are package-private, and each has its own main() - run them one by one.
 *
 *  ArraysUtilityMethods               -> java.util.Arrays utility methods + array <-> List/Set conversion
 *  ArrayCreationAndTypes              -> ways to create arrays + which data types an array can hold
 *  ArraySortingAndReversing           -> sorting (Comparable / Comparator) and reversing arrays
 *  ArrayMinMax                        -> min / max of an array
 *  SecondHighestAndLowest             -> Kth / second highest / second lowest
 *  RemoveDuplicatesFromArray          -> remove duplicates (distinct, LinkedHashSet)
 *  FindDuplicatesAndCountOccurrences  -> find duplicates + count occurrences
 *  PairsWithTargetSum                 -> pairs whose sum = target
 *  ReverseSentenceAndWords            -> reverse a sentence / reverse every word
 *  VowelCount                         -> count which vowel occurs how many times
 *  StreakAndFrequencyPrograms         -> longest consecutive run, first non-repeated char, sorted duplicates
 *  StringConversions                  -> String <-> int / float / long / wrapper conversions
 *  StringBufferAndBuilder             -> StringBuffer / StringBuilder methods + capacity
 *  StringMethods                      -> common String methods + String pool
 */


// =====================================================================================
// java.util.Arrays utility methods
// =====================================================================================
class ArraysUtilityMethods {

    public static void main(String[] args) {

        int[] baseArr = {10, 20, 30};
        // length is NOT a method, it is a final field of every array (type int)
        // array -> .length   |   String -> .length()   |   Collection -> .size()
        System.out.println("length: " + baseArr.length);

        // 2D array = array of arrays. Rows may have different lengths ("jagged array")
        int[][] matrix2D = {
                {1, 2, 3},       // 3 elements
                {4, 5, 6, 7}     // 4 elements
        };
        System.out.println("rows: " + matrix2D.length);            // 2
        System.out.println("row0 size: " + matrix2D[0].length);    // 3
        System.out.println("row1 size: " + matrix2D[1].length);    // 4


        /* =========================
           toString()
           Converts a 1D array to a readable String like [5, 2, 9, 1]
           (printing the array directly gives something like [I@1b6d3586 -> type@hashcode)
        ========================== */
        int[] arr = {5, 2, 9, 1};
        System.out.println("toString(): " + Arrays.toString(arr));


        /* =========================
           sort()   return type: void (modifies the SAME array)
           Sorts primitive, String, Wrapper and custom Comparable arrays
        ========================== */
        Arrays.sort(arr);
        System.out.println("sort(): " + Arrays.toString(arr));   // [1, 2, 5, 9]


        /* =========================
           binarySearch()   return type: int
           Works correctly ONLY on a SORTED array.
           Compares with the middle element and throws away half each time -> O(log n)
           (1,00,000 elements need only ~17 comparisons; linear search may need 1,00,000)
           Returns index if found, otherwise a negative number: -(insertionPoint) - 1
        ========================== */
        System.out.println("binarySearch(5): " + Arrays.binarySearch(arr, 5));   // 2
        System.out.println("binarySearch(4): " + Arrays.binarySearch(arr, 4));   // -3 (not found)


        /* =========================
           equals()   return type: boolean
           true if both arrays have same length and same elements in same order.
           For object arrays each element is compared using its equals() method.
           arr1 == arr2 compares REFERENCES, Arrays.equals compares CONTENT.
        ========================== */
        int[] arrCopy = {1, 2, 5, 9};
        System.out.println("equals(): " + Arrays.equals(arr, arrCopy));   // true
        System.out.println("==      : " + (arr == arrCopy));              // false


        /* =========================
           fill()   return type: void
           Puts the same value in every index
        ========================== */
        char[] fillArr = new char[5];
        Arrays.fill(fillArr, '8');
        System.out.println("fill(): " + Arrays.toString(fillArr));   // [8, 8, 8, 8, 8]


        /* =========================
           copyOf(originalArray, newLength)   return type: new array of same type
           newLength smaller -> extra elements are cut off
           newLength bigger  -> extra places get default values (0, false, null...)
           This is how ArrayList grows internally.
        ========================== */
        int[] copyArr = Arrays.copyOf(arr, 6);
        System.out.println("copyOf(): " + Arrays.toString(copyArr));   // [1, 2, 5, 9, 0, 0]


        /* =========================
           copyOfRange(originalArray, from, to)   from = inclusive, to = EXCLUSIVE
        ========================== */
        int[] rangeArr = Arrays.copyOfRange(arr, 1, 3);
        System.out.println("copyOfRange(): " + Arrays.toString(rangeArr));   // [2, 5]


        /* =========================
           stream()
           int[]    -> IntStream
           long[]   -> LongStream
           double[] -> DoubleStream
           (no special stream for char/byte/short/float/boolean)
           T[]      -> Stream<T>   (String, Wrapper, custom objects)
           A stream can be used ONLY ONCE - create a new one for each operation.
        ========================== */
        int[] intArray = {5, 2, 9, 1};
        IntStream intStream = Arrays.stream(intArray);
        System.out.println("stream().sum(): " + intStream.sum());

        double[] doubleArray = {1.5, 2.7, 3.14};
        DoubleStream doubleStream = Arrays.stream(doubleArray);
        System.out.println("DoubleStream max: " + doubleStream.max().orElse(0));

        //java 8
        double average = Arrays.stream(intArray).average().orElse(0.0);
        System.out.println("average(): " + average);

        long[] longArray = {100L, 200L, 300L};
        LongStream longStream = Arrays.stream(longArray);
        System.out.println("LongStream count: " + longStream.count());

        String[] stringArray = {"apple", "banana", "cherry"};
        Stream<String> stringStream = Arrays.stream(stringArray);
        System.out.println("Stream<String>: " + stringStream.collect(Collectors.toList()));

        //java 8
        Integer[] integerArray = {5, 2, 9, 1};
        // Stream<Integer> has no sum() -> convert to IntStream first with mapToInt
        int sum2 = Arrays.stream(integerArray)   // Stream<Integer>
                .mapToInt(Integer::intValue)     // IntStream
                .sum();
        System.out.println(Arrays.toString(integerArray) + " sum: " + sum2);


        /* =========================
           Converting between List, Stream and arrays
           boxed()      : IntStream -> Stream<Integer>
           mapToInt()   : Stream<Integer> -> IntStream
           toArray()    : on IntStream -> int[] | on Stream<T> without argument -> Object[]
           toArray(Integer[]::new) -> gives a properly typed Integer[]
        ========================== */
        List<Integer> list = Arrays.asList(4, 8, 15, 16);

        Object[] objectsFromList = list.stream().toArray();
        Integer[] integersFromList = list.stream().toArray(Integer[]::new);
        int[] primitiveFromList = list.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(primitiveFromList) + " "
                + Arrays.toString(objectsFromList) + " " + Arrays.toString(integersFromList));

        List<Integer> listFromIntegerArray = Arrays.stream(integerArray).collect(Collectors.toList());
        List<Integer> ListOfIntegers = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        Integer[] boxedArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        System.out.println(listFromIntegerArray + " " + Arrays.toString(boxedArray));


        /* =========================
           setAll(array, index -> value)   return type: void
           For every index, calculates a new value FROM THE INDEX and stores it there.
           Old values are ignored.
        ========================== */
        long[] logicArr = new long[5];
        logicArr[0] = 12L;
        logicArr[1] = 10L;
        Arrays.setAll(logicArr, i -> i * 10L);
        System.out.println("setAll(): " + Arrays.toString(logicArr));   // [0, 10, 20, 30, 40]

        // If we DON'T want to modify the array, use a stream and collect into a new array/list
        List<Long> multipliedList = Arrays.stream(longArray)   // LongStream
                .map(element -> element * 5)
                .boxed()                                       // Stream<Long>
                .collect(Collectors.toList());      ---- List
                // .boxed().toArray(Long::new);     ---- Wrapper array
                // .toArray();                      ---- primitive array
        System.out.println(multipliedList + " " + Arrays.toString(multipliedArray));


        /* =========================
           parallelSort()   return type: void
           Splits the array and sorts parts on multiple threads (ForkJoin pool).
           Useful only for big arrays; for small arrays plain sort() is faster.
        ========================== */
        int[] bigArr = {9, 3, 7, 1, 6};
        Arrays.parallelSort(bigArr);
        System.out.println("parallelSort(): " + Arrays.toString(bigArr));


        /* =========================
           parallelPrefix(array, (x, y) -> x + y)   return type: void
           Each position becomes "result accumulated so far as per lambda expression
           [1, 2, 3, 4] -> [1, 3, 6, 10]
        ========================== */
        int[] prefixArr = {1, 2, 3, 4};
        Arrays.parallelPrefix(prefixArr, (x, y) -> x + y);
        System.out.println("parallelPrefix(): " + Arrays.toString(prefixArr));


        /* =========================
           clone()   return type: same array type
           Creates a SHALLOW copy (a new array, but elements are copied as-is).
           - Primitive array : values are copied -> behaves like an independent (deep) copy
           - Object array    : REFERENCES are copied -> both arrays point to the SAME objects
        ========================== */
        int[] original = {10, 20, 30};
        int[] clonedArr = original.clone();
        clonedArr[0] = 99;
        System.out.println("original: " + Arrays.toString(original));    // [10, 20, 30]
        System.out.println("clone   : " + Arrays.toString(clonedArr));   // [99, 20, 30]

        Person[] originalPersons = {new Person("John"), new Person("Mike")};
        Person[] shallowCopy = originalPersons.clone();
        shallowCopy[0].name = "Changed";
        System.out.println("shallow copy changed original too: " + originalPersons[0].name);   // Changed

        // Deep copy: create NEW objects for every element (here using Person's copy constructor)
        Person[] deepCopy = Arrays.stream(originalPersons).map(Person::new).toArray(Person[]::new);
        deepCopy[1].name = "OnlyInCopy";
        System.out.println("deep copy did not change original: " + originalPersons[1].name);   // Mike


        /* =========================
           deepToString() / deepEquals() -> for multi-dimensional arrays
           (toString/equals on a 2D array would only look at inner array references)
        ========================== */
        int[][] matrix = {{1, 2}, {3, 4, 5, 6, 7}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        System.out.println("deepToString(): " + Arrays.deepToString(matrix));
        System.out.println("deepEquals(): " + Arrays.deepEquals(matrix, matrix2));   // false

        convertArrayToListAndSet();
    }

    static void convertArrayToListAndSet() {
        String[] stringArray = {"C", "B", "A", "A"};

        /* =====================================================
           1. Arrays.asList(array)   -> List<T>
           Only for object arrays (String, Wrapper, custom). For int[] you get List<int[]>!
           Fixed-size list BACKED by the array:
             set()        -> allowed, and it changes the original array too
             add/remove() -> UnsupportedOperationException
        ===================================================== */
        List<String> list1 = Arrays.asList(stringArray);
        System.out.println("asList(): " + list1);

        /* 2. new ArrayList<>(Arrays.asList(array)) -> normal, fully modifiable ArrayList */
        List<String> list2 = new ArrayList<>(Arrays.asList(stringArray));
        list2.add("D");
        System.out.println("ArrayList from asList(): " + list2);

        /* 3. Collections.addAll(list, array) -> adds all elements into an existing collection */
        List<String> list3 = new ArrayList<>();
        Collections.addAll(list3, stringArray);
        System.out.println("Collections.addAll(): " + list3);

        /* 4. Stream API -> List. For primitive arrays use boxed() first */
        List<String> list4 = Arrays.stream(stringArray).collect(Collectors.toList());
        int[] primitiveArray = {3, 1, 2};
        List<Integer> integerList = Arrays.stream(primitiveArray).boxed().collect(Collectors.toList());
        System.out.println("Stream toList(): " + list4 + " " + integerList);

        /* 5. List.of(array) (Java 9+) -> IMMUTABLE list. add/remove/set -> UnsupportedOperationException,
              null elements not allowed (NullPointerException) */
        List<String> list5 = List.of(stringArray);
        System.out.println("List.of(): " + list5);

        /* 6. HashSet       -> removes duplicates, NO order guarantee */
        Set<String> set1 = new HashSet<>(Arrays.asList(stringArray));

        /* 7. Collectors.toSet() -> removes duplicates, you can't choose the Set type
              (use Collectors.toCollection(TreeSet::new) if you need a specific type) */
        Set<String> set2 = Arrays.stream(stringArray).collect(Collectors.toSet());

        /* 8. LinkedHashSet -> removes duplicates, keeps INSERTION order */
        Set<String> set3 = new LinkedHashSet<>(Arrays.asList(stringArray));

        /* 9. TreeSet       -> removes duplicates, SORTED order */
        Set<String> set4 = new TreeSet<>(Arrays.asList(stringArray));

        System.out.println("HashSet: " + set1 + " toSet: " + set2 + " LinkedHashSet: " + set3 + " TreeSet: " + set4);
    }
}

// Used by the clone() / deep copy example
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    // copy constructor -> used for deep copy
    Person(Person other) {
        this.name = other.name;
    }
}


// =====================================================================================
// Ways to create an array + data types an array can hold
// =====================================================================================
class ArrayCreationAndTypes {
    public static void main(String[] args) {

        // 1) declare with size, fill later (unfilled places keep default value: 0.0f here)
        float[] floatArray = new float[4];
        floatArray[0] = 10f;
        floatArray[1] = 20.4f;
        floatArray[2] = 30.0f;
        // floatArray.toString() prints type@hashcode, so always use Arrays.toString()
        System.out.println("Float Array = " + Arrays.toString(floatArray));   // [10.0, 20.4, 30.0, 0.0]

        // 2) new + values : size is taken from the values
        char[] charArray1 = new char[]{'a', 's', 'w', 's', 'k', 'p'};
        System.out.println("length = " + charArray1.length);

        // 3) shortcut (only allowed on the declaration line)
        char[] charArray2 = {'1', '4', 'v', 'w', '9', 'p', '1'};
        System.out.println("Char Array = " + Arrays.toString(charArray2));

        // 4) from a String (a String is a sequence of characters)
        char[] fromString = "shubham shende".toCharArray();
        System.out.println("From String = " + Arrays.toString(fromString));

        // Give EITHER a size OR values - never both:
        // char[] a = new char[5];                    -> OK
        // char[] a = new char[]{'v', 'w'};           -> OK
        // char[] a = new char[2]{'v', 'w'};          -> compile error
        // char[5] a = new char[5];                   -> compile error (size is never on the left)

        // Array size is FIXED once created. Need growing size? -> use ArrayList.


        /* ======================= 1) Primitive arrays (default value in brackets) ======================= */

        char[] charArray = {'a', 'b'};          // 16-bit unicode 0..65,535            ('\u0000')
        byte[] byteArray = {1, 2};              // -128 .. 127                          (0)
        short[] shortArray = {10};              // -32,768 .. 32,767                    (0)
        int[] intArray = {1, 4, 23, 5, 76};     // about -2.1 billion .. 2.1 billion    (0)
        long[] longArray = {100L};              // L needed for big values, +/-9.22 x 10^18 (0L)
        float[] floats = {1.2f};                // f REQUIRED, otherwise 1.2 is a double (0.0f)
        double[] doubleArray = {1.1, 2.2};      // default for decimals, d not needed   (0.0d)
        boolean[] booleanArray = {true, false}; //                                      (false)

        System.out.println(Arrays.toString(charArray) + Arrays.toString(byteArray) + Arrays.toString(shortArray)
                + Arrays.toString(intArray) + Arrays.toString(longArray) + Arrays.toString(floats)
                + Arrays.toString(doubleArray) + Arrays.toString(booleanArray));

        /* ======================= 2) String array (non-primitive, default null) ======================= */
        String[] nameArray = {"A", "B"};
        System.out.println("nameArray = " + Arrays.toString(nameArray));

        /* ======================= 3) Wrapper class array (autoboxing int -> Integer) ======================= */
        Integer[] integerWrapperArray = {1, 2};
        System.out.println("integerWrapperArray[0] instanceof Integer = " + (integerWrapperArray[0] instanceof Integer));

        /* ======================= 4) Custom class array (holds references, default null) ======================= */
        Student[] studentArray = new Student[3];
        studentArray[0] = new Student(1, "Rahul");
        studentArray[1] = new Student(2, "Neha");
        System.out.println("studentArray = " + Arrays.toString(studentArray));   // last one is null

        /* ======================= 5) Object array (any type mixed) ======================= */
        Object[] objectArray = new Object[4];
        objectArray[0] = "Hello";
        objectArray[1] = 100;                     // autoboxed to Integer
        objectArray[2] = new Student(3, "Asha");
        System.out.println("objectArray = " + Arrays.toString(objectArray));
    }
}


// Lombok @Data -> getters, setters, toString, equals and hashCode (needed for distinct(), HashSet, HashMap)
// Comparable   -> gives the "natural order" used by Arrays.sort(studentArray) and TreeSet
@AllArgsConstructor
@Data
class Student implements Comparable<Student> {
    int id;
    String name;

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);   // ascending by id
    }
}


// =====================================================================================
// Sorting and reversing arrays
// =====================================================================================
class ArraySortingAndReversing {

    public static void main(String[] args) {

        // ---------- Sorting primitive / wrapper arrays ----------
        int[] intArray = {5, 2, 8, 1, 3};
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        // reverse an  Non-primitive / Custom Comparable Object
        Integer[] integerArray = {5, 2, 8, 1, 3};

        Arrays.sort(integerArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(integerArray));

        Integer[] sortedCopy = Arrays.stream(integerArray).sorted().toArray(Integer[]::new);   // original untouched
        System.out.println(Arrays.toString(sortedCopy));


        // ---------- Sorting custom objects ----------
        // Comparable  (inside the class, compareTo)  -> ONE natural order, class must be modified
        // Comparator  (outside the class, compare)   -> MANY orders, class not modified
        Student[] studentArray = {new Student(3, "Ravi"), new Student(1, "Amit"), new Student(2, "Neha")};

        Arrays.sort(studentArray);                                // natural order (compareTo -> id asc)
        Arrays.sort(studentArray, Collections.reverseOrder());    // reverse of natural order

        // Comparator - 1) anonymous class (old style, pre Java 8)
        // it should have method name and marhos implementation wrapper aroundcurly braces
        Arrays.sort(studentArray, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.id, s2.id);
            }
        });

        // 2) lambda
        // no method name & method implementation is simple , NO return statement needed
        Arrays.sort(studentArray, (s1, s2) -> Integer.compare(s1.id, s2.id));
        // (s1, s2) -> s1.id - s2.id also works but can OVERFLOW for large/negative numbers -> prefer Integer.compare

        // 3) Comparator helper methods (cleanest)
        Arrays.sort(studentArray, Comparator.comparingInt(Student::getId));
        Arrays.sort(studentArray, Comparator.comparingInt(Student::getId).reversed());
        // With a lambda + reversed() the type must be written: comparingInt((Student s) -> s.id).reversed()
        Arrays.sort(studentArray, Comparator.comparingInt((Student s) -> s.id).reversed());

        // Multi-level sorting: first by name, if same name then by id
        Arrays.sort(studentArray, Comparator.comparing(Student::getName).thenComparingInt(Student::getId));

        // reversed() at the END reverses the WHOLE chain built so far
        Arrays.sort(studentArray, Comparator.comparing(Student::getName).thenComparingInt(Student::getId).reversed());

        // reverse only the second level: id asc, then name desc
        Arrays.sort(studentArray, Comparator.comparingInt(Student::getId)
                .thenComparing(Comparator.comparing(Student::getName).reversed()));
        System.out.println(Arrays.toString(studentArray));


        // ---------- Arrays.asList is BACKED by the array ----------
        String[] stringArray = {"A", "G", "C"};
        List<String> backedList = Arrays.asList(stringArray);
        Collections.sort(backedList);      // in such scenarios sorting the list ALSO sorts the array
        System.out.println(Arrays.toString(stringArray) + " : " + backedList);   // [A, C, G] : [A, C, G]

        List<String> independentList = new ArrayList<>(Arrays.asList(stringArray));
        Collections.reverse(independentList);   // array NOT changed, it is a separate copy
        System.out.println(Arrays.toString(stringArray) + " : " + independentList);

        // Trap: Arrays.asList(char[]) gives List<char[]> with ONE element (the whole array)
        char[] charArray = {'f', 's', 'w', 's', 'k', 'p'};
        List<char[]> listChar = Arrays.asList(charArray);
        System.out.println("size of Arrays.asList(char[]) = " + listChar.size());   // 1


        // ---------- Reversing (no built-in reverse for arrays) ----------
        reverseDoubleArray();
        System.out.println(Arrays.toString(reverseStringArrayJava8(new String[]{"A", "B", "C"})));
        System.out.println(Arrays.toString(reverseCharArray(charArray)));

        // using a Stack (Last In First Out)
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            stack.push(c);
        }
        StringBuilder reversedByStack = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedByStack.append(stack.pop());
        }
        System.out.println("Stack reverse: " + reversedByStack);

        // shortest way for char[] : via StringBuilder
        char[] reversedChars = new StringBuilder(new String(charArray)).reverse().toString().toCharArray();
        System.out.println("StringBuilder reverse: " + Arrays.toString(reversedChars));
    }

    // Two-pointer swap: works for ANY array type (just change the temp variable type)
    public static void reverseDoubleArray() {
        double[] doubleArray = {1.1, 4.5, 2.6, 7, 3, 8, 9};
        System.out.println("Original : " + Arrays.toString(doubleArray));

        // way 1: while loop with start and end pointers
        int start = 0;
        int end = doubleArray.length - 1;
        while (start < end) {
            double temp = doubleArray[start];
            doubleArray[start] = doubleArray[end];
            doubleArray[end] = temp;
            start++;
            end--;
        }
        System.out.println("Reversed : " + Arrays.toString(doubleArray));

        // way 2: for loop till the middle (reverses it back to original)
        int n = doubleArray.length;
        for (int i = 0; i < n / 2; i++) {
            double temp = doubleArray[i];
            doubleArray[i] = doubleArray[n - 1 - i];
            doubleArray[n - 1 - i] = temp;
        }
        System.out.println("Reversed again : " + Arrays.toString(doubleArray));
    }

    // Java 8: build a NEW reversed array from indexes
    public static String[] reverseStringArrayJava8(String[] arr) {
        return IntStream.range(0, arr.length)            // 0, 1, 2 ...
                .mapToObj(i -> arr[arr.length - 1 - i])  // pick from the end
                .toArray(String[]::new);
    }

    // IntStream has no toCharArray(), so fill a new array by index
    public static char[] reverseCharArray(char[] arr) {
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }
}


// =====================================================================================
// Min and max of an array
// 1. sort and pick first/last          -> O(n log n)
// 2. assume first element, loop        -> O(n)  <- best answer in interviews
// 3. Java 8 streams
// =====================================================================================
class ArrayMinMax {
    public static void main(String[] args) {

        int[] array = {1, 4, 23, 5, 76, 13, 64, 23};

        // way 1 - sort (NOTE: this changes the original array)
        int[] sorted = array.clone();
        Arrays.sort(sorted);
        System.out.println("min-" + sorted[0] + " max-" + sorted[sorted.length - 1]);

        // way 2 - single loop
        int min = array[0];
        int max = array[0];
        for (int current : array) {
            if (current < min) min = current;
            if (current > max) max = current;
        }
        System.out.println("min-" + min + " max-" + max);

        // way 3 - Java 8, int[] -> IntStream.min() returns OptionalInt (empty if array is empty)
        int streamMin = Arrays.stream(array).min().getAsInt();
        int streamMax = Arrays.stream(array).max().orElse(0);   // safer than getAsInt()
        System.out.println("stream min-" + streamMin + " max-" + streamMax);

        OptionalInt optionalMin = Arrays.stream(anyArray).min();
        System.out.println(optionalMin.isPresent() ? optionalMin.getAsInt() : "Array is empty");

        // Integer[] -> Stream<Integer>.min(Comparator) returns Optional<Integer>
        Integer[] integerArray = {7, 3, 9};
        Integer integerMin = Arrays.stream(integerArray).min(Integer::compareTo).orElse(0);
        Integer integerMax = Arrays.stream(integerArray).max(Comparator.naturalOrder()).orElse(0);
        System.out.println("Integer[] min-" + integerMin + " max-" + integerMax);

        // very IMP
        // float[] has no stream -> go through indexes and use DoubleStream
        float[] floatArray = {10.5f, 5.2f, 20.8f, 3.1f, 15.6f};
        double floatMin = IntStream.range(0, floatArray.length).mapToDouble(i -> floatArray[i]).min().orElse(0.0);
        System.out.println("float min-" + floatMin);
    }
}


// =====================================================================================
// Kth / second highest and lowest
// =====================================================================================
class SecondHighestAndLowest {
    public static void main(String[] args) {

        // Kth smallest -> sort ascending, take array[k-1]
        // Kth largest  -> sort ascending, take array[length-k]
        Integer[] array = {1, 4, 23, 5, 76, 13, 64};
        Arrays.sort(array);
        int k = 2;
        System.out.println(k + "nd smallest: " + array[k - 1] + ", " + k + "nd largest: " + array[array.length - k]);

        String[] words = {"cc", "aa", "ww", "ff"};
        Arrays.sort(words, Comparator.reverseOrder());
        System.out.println(Arrays.toString(words));

        Arrays.sort(words, Comparator.naturalOrder());
        System.out.println(Arrays.toString(words));

        secondHighest();
        secondLowest();

        // Java 8 one-liner (distinct handles duplicates like 20, 20)
        int[] nums = {10, 5, 20, 8, 20, 3};
        Arrays.stream(nums).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()
                .ifPresent(v -> System.out.println("Second highest (stream): " + v));
    }

    // single pass O(n), no sorting
    public static void secondHighest() {
        int[] intArray = {10, 5, 20, 8, 20, 3};

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int current : intArray) {
            if (current > highest) {
                // old highest moves down to second place
                secondHighest = highest;
                highest = current;
            } else if (current > secondHighest && current < highest) {
                // between the two -> new second highest ("< highest" skips duplicates of highest)
                secondHighest = current;
            }
        }

        if (secondHighest == Integer.MIN_VALUE) {
            System.out.println("No second highest element exists.");
        } else {
            System.out.println("Second highest element: " + secondHighest);   // 10
        }
    }

    public static void secondLowest() {
        int[] arr = {10, 5, 20, 8, 20, 3};

        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;

        for (int current : arr) {
            if (current < lowest) {
                secondLowest = lowest;
                lowest = current;
            } else if (current < secondLowest && current > lowest) {
                secondLowest = current;
            }
        }

        if (secondLowest == Integer.MAX_VALUE) {
            System.out.println("No second lowest element exists.");
        } else {
            System.out.println("Second lowest element: " + secondLowest);   // 5
        }
    }
}


// =====================================================================================
// Remove duplicates: distinct() or LinkedHashSet
// =====================================================================================
class RemoveDuplicatesFromArray {
    public static void main(String[] args) {


        int[] intArray = {1, 4, 22, 14, 19, 9, 5, 7, 22, 0};
        int[] uniqueInts = new int[intArray.length];
        int uniqueCount = 0;

        for (int i = 0; i < intArray.length; i++) {
            boolean alreadyExists = false;
            // Check if current number is already in uniqueInts
            for (int j = 0; j < uniqueCount; j++) {
                if (intArray[i] == uniqueInts[j]) {
                    alreadyExists = true;
                    break;
                }
            }
            // If number doesn't exist, add it
            if (!alreadyExists) {
                uniqueInts[uniqueCount] = intArray[i];
                uniqueCount++;
            }
        }
        System.out.println(Arrays.toString(uniqueInts));

        // primitive stream -> toArray() gives a primitive array (int[])
        int[] intArray = {1, 4, 22, 14, 19, 9, 5, 7, 22, 0};
        int[] uniqueInts = Arrays.stream(intArray).distinct().toArray();
        System.out.println(Arrays.toString(uniqueInts));

        // LinkedHashSet removes duplicates AND keeps the original order
        Integer[] numbers = {1, 2, 2, 3, 1};
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(numbers));
        Integer[] uniqueNumbers = set.toArray(new Integer[0]);   // new Integer[0] just tells the TYPE
        System.out.println(Arrays.toString(uniqueNumbers));

        //     new Integer[0]  → give an array
        //     Integer[]::new  → give a function that creates an array   --   Create an array of the required size

        String[] names = {"Amit", "Ravi", "Amit", "Neha", "Ravi"};
        String[] uniqueNames = Arrays.stream(names).distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(uniqueNames));

        // distinct() uses equals()/hashCode() -> works here because Lombok @Data generates them.
        // Without equals/hashCode, two Student(1,"Amit") objects would both be kept.
        Student[] students = {new Student(1, "Amit"), new Student(2, "Ravi"), new Student(1, "Amit")};
        Student[] uniqueStudents = Arrays.stream(students).distinct().toArray(Student[]::new);
        System.out.println(Arrays.toString(uniqueStudents));
    }
}



// =====================================================================================
// Find duplicates + count how many times each element occurs
// =====================================================================================
class FindDuplicatesAndCountOccurrences {
    public static void main(String[] args) {
        duplicatesInArray();
        withoutCollectionObject();
        withCollectionObject();
    }

    public static void duplicatesInArray() {

        int[] intArray = {1, 2, 2, 3, 1, 2, 7, 3, 9, 12, 12};
        Set<Integer> duplicatesNested = new LinkedHashSet<>();
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    duplicatesNested.add(intArray[i]);
                }
            }
        }
        System.out.println("Duplicates (nested loop): " + duplicatesNested);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int value : intArray) {
            if (!seen.add(value)) {
                duplicates.add(value);
            }
        }
        System.out.println("Duplicates (HashSet)    : " + duplicates);
    }

    // Without any collection: boolean[] remembers which positions are already counted
    public static void withoutCollectionObject() {
        int[] arr = {1, 2, 2, 3, 1, 2};
        boolean[] counted = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (counted[i])
                continue;          // already counted as a duplicate of an earlier element

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    counted[j] = true;
                }
            }
            System.out.println(arr[i] + " occurs " + count + " times");
        }
    }

    public static void withCollectionObject() {
        // Generic method needs OBJECT arrays, so box primitive arrays first
        int[] nums = {1, 2, 2, 3, 1};
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        System.out.println("int[]: " + countOccurrences(boxedNums));

        char[] chars = {'a', 'b', 'a', 'c'};
        Character[] boxedChars = new String(chars).chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        System.out.println("char[]: " + countOccurrences(boxedChars));

        String[] names = {"Amit", "Ravi", "Amit", "Neha"};
        System.out.println("String[]: " + countOccurrences(names));

        Student[] students = {new Student(1, "Amit"), new Student(2, "Ravi"), new Student(1, "Amit")};
        System.out.println("Student[]: " + countOccurrences(students));

        // Java 8 one-liner
        Map<String, Long> countByStream = Arrays.stream(names)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Stream groupingBy: " + countByStream);

        groupingBy()
        Amit → [Amit, Amit]
        Ravi → [Ravi]
        Neha → [Neha]

        Function.identity() : Use the element itself as the key
        Collectors.counting() : Counts how many elements are in each group
    }

    // <T> makes this ONE method work for Integer[], Character[], String[], Student[] ...
    public static <T> Map<T, Integer> countOccurrences(T[] arr) {
        Map<T, Integer> countMap = new HashMap<>();
        for (T elem : arr) {
            countMap.put(elem, countMap.getOrDefault(elem, 0) + 1);
            // same thing: countMap.merge(elem, 1, Integer::sum);
        }
        return countMap;
    }
}


// =====================================================================================
// Pairs whose sum equals a target
// =====================================================================================
class PairsWithTargetSum {
    public static void main(String[] args) {

        int target = 22;
        int[] array = {1, 4, 22, 14, 19, 9, 5, 7, 22, 0};
        System.out.println(Arrays.toString(array));

        // way 1: nested loops O(n^2)
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    pairs.add("(" + array[i] + ", " + array[j] + ")");
                }
            }
        }
        System.out.println(pairs + " -> " + pairs.size() + " pairs");

        // way 2: O(n) - for each number, check if (target - number) was already seen
        Set<Integer> seen = new HashSet<>();
        List<String> fastPairs = new ArrayList<>();
        for (int number : array) {
            int needed = target - number;
            if (seen.contains(needed)) {
                fastPairs.add("(" + needed + ", " + number + ")");
            }
            seen.add(number);
        }
        System.out.println(fastPairs + " -> " + fastPairs.size() + " pairs");
    }
}


// =====================================================================================
// Reverse a sentence / reverse every word
// =====================================================================================
class ReverseSentenceAndWords {
    public static void main(String[] args) {

        String sentence = "Reverse a sentence";

        // 1) String + in a loop: WORST - String is immutable, every += creates a new String object
        String rev = "";
        for (int i = sentence.length() - 1; i >= 0; i--) {
            rev += sentence.charAt(i);
        }
        System.out.println(rev);

        // 2) StringBuffer: mutable + synchronized (thread-safe) -> slower
        StringBuffer rev2 = new StringBuffer();
        for (int i = sentence.length() - 1; i >= 0; i--) {
            rev2.append(sentence.charAt(i));
        }
        System.out.println(rev2);

        // 3) StringBuilder.reverse(): mutable, not synchronized -> fastest, use this
        // A String cannot be assigned to a StringBuilder (sb = "abc" is an error), pass it to the constructor
        String reversedSentence = new StringBuilder(sentence).reverse().toString();
        System.out.println(reversedSentence);


        // ---------- reverse EVERY WORD but keep word order ----------
        String sentence2 = "Reverse every word in this sentence";

        // old way
        StringBuilder result = new StringBuilder();
        for (String w : sentence2.split(" ")) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(new StringBuilder(w).reverse());
        }
        System.out.println(result);

        // Java 8
        String reversedWords = Arrays.stream(sentence2.split(" "))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(reversedWords);

        // reverse WORD ORDER: "a b c" -> "c b a"
        List<String> wordList = Arrays.asList(sentence2.split(" "));
        Collections.reverse(wordList);
        System.out.println(String.join(" ", wordList));
    }
}


// =====================================================================================
// Count which vowel occurs how many times
// =====================================================================================
class VowelCount {

    public static void main(String[] args) {
        withoutCollection();
        withCollection();
    }

    public static void withCollection() {
        String input = "shubham anil shende".toLowerCase();

        // LinkedHashMap keeps the order a, e, i, o, u in the output
        Map<Character, Integer> vowelCountMap = new LinkedHashMap<>();
        for (char v : "aeiou".toCharArray()) {
            vowelCountMap.put(v, 0);
        }

        for (char ch : input.toCharArray()) {
            if (vowelCountMap.containsKey(ch)) {
                vowelCountMap.put(ch, vowelCountMap.get(ch) + 1);
            }
        }
        System.out.println("Vowel counts : " + vowelCountMap);
    }

    public static void withoutCollection() {
        String input = "shubham anil shende".toLowerCase();

        String vowels = "aeiou";
        int[] counts = new int[5];   // counts[0] = a, counts[1] = e ...

        for (char ch : input.toCharArray()) {
            int index = vowels.indexOf(ch);   // -1 if not a vowel
            if (index != -1) {
                counts[index]++;
            }
        }
        for (int i = 0; i < vowels.length(); i++) {
            System.out.print(vowels.charAt(i) + "=" + counts[i] + " ");
        }
        System.out.println();
    }
}


// =====================================================================================
// Longest streak, longest consecutive sequence, first non-repeated char, sorted duplicates
// =====================================================================================
class StreakAndFrequencyPrograms {

    public static void main(String[] args) {
        int[] arrayOriginal = {87, 23, 7, 13, 25, 14, 3, 18, 15, 12, 30, 31, 32, 33, 34, 35, 24};

        longestStreakInOrder(arrayOriginal);
        longestConsecutiveSequence(arrayOriginal);
        firstNonRepeatedChar("abcgad iwsadadda");
        sortedDuplicates(new int[]{9, 9, 3, 3, 8, 5, 5, 7, 2});
    }

    // Longest run of consecutive numbers AS THEY APPEAR (30,31,32,33,34,35)
    static void longestStreakInOrder(int[] arr) {
        int bestLength = 1;
        int bestEnd = 0;
        int currentLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                currentLength++;          // streak continues
            } else {
                currentLength = 1;        // streak broken, start again from this element
            }

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestEnd = i;
            }
        }

        int bestStart = bestEnd - bestLength + 1;
        System.out.println("Longest streak: " + Arrays.toString(Arrays.copyOfRange(arr, bestStart, bestEnd + 1)));
    }

    // Longest consecutive sequence in ANY order (elements can be rearranged) - O(n) with a HashSet
    static void longestConsecutiveSequence(int[] arr) {
        // Arrays.asList(int[]) would give List<int[]>, so box with a stream
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        int longest = 0;
        for (int element : set) {
            // start counting only from the FIRST number of a sequence (no element-1 present)
            if (!set.contains(element - 1)) {
                int current = element;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        System.out.println("Longest consecutive sequence: " + longest);
    }

    static void firstNonRepeatedChar(String input) {
        // LinkedHashMap keeps insertion order, so the first entry with count 1 is the answer
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        Character firstNonRepeated = null;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                firstNonRepeated = entry.getKey();
                break;                              // stop at the FIRST one
            }
        }
        System.out.println("First non-repeated : " + firstNonRepeated);

        // Java 8
        Character firstNonRepeatedStream = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First non-repeated (stream) : " + firstNonRepeatedStream);
    }

    // Duplicate elements, sorted ascending
    static void sortedDuplicates(int[] arr) {
        List<Integer> duplicates = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted duplicates: " + duplicates);   // [3, 5, 9]
    }
}


// =====================================================================================
// String <-> primitive / wrapper conversions
// =====================================================================================
class StringConversions {
    public static void main(String[] args) {

        // anything -> String : String.valueOf(...)
        String s4 = String.valueOf(132453.34F);
        String s5 = String.valueOf(34625263L);
        String s6 = String.valueOf(true);
        System.out.println(s4 + " " + s5 + " " + s6);

        // String -> primitive : parseXxx()  returns int / float / ...
        int x = Integer.parseInt("1023");
        float ff = Float.parseFloat("12.4");
        System.out.println("int : " + x + ", float : " + ff);

        // String -> wrapper   : valueOf()   returns Integer / Float / ...
        Integer wrapped = Integer.valueOf("123");
        System.out.println(wrapped + " is Integer? " + (wrapped instanceof Integer));

        // Invalid text -> NumberFormatException (always handle it with user input)
        try {
            Integer.parseInt("12a");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }

        // Integer cache trap: valueOf caches -128..127, so == works there by luck only
        Integer a = 127, b = 127, c = 128, d = 128;
        System.out.println((a == b) + " " + (c == d) + " " + c.equals(d));   // true false true
    }
}


// =====================================================================================
// StringBuffer / StringBuilder
// =====================================================================================
class StringBufferAndBuilder {

    public static void main(String[] args) {

        StringBuffer sb1 = new StringBuffer("aaa");

        // MUTABLE: append changes the same object and returns it (so methods can be chained)
        StringBuffer sb2 = sb1.append("bbb");
        System.out.println(sb1 + " " + sb2);   // aaabbb aaabbb
        System.out.println(sb1 == sb2);        // true -> same object
        // StringBuffer does NOT override equals(), so equals() also compares references here.
        // To compare content: sb1.toString().equals(other.toString())  or  sb1.compareTo(other) (Java 11+)
        System.out.println(sb1.equals(sb2));   // true only because it is the same object

        sb1.insert(3, "ccc");                  // aaacccbbb
        System.out.println(sb1);

        sb1.delete(3, 6);                      // remove index 3..5 -> aaabbb
        System.out.println(sb1);

        sb1.deleteCharAt(3);                   // aaabb
        System.out.println(sb1);

        sb1.replace(0, 2, "ZZ");               // ZZabb
        sb1.reverse();                         // bbaZZ
        System.out.println(sb1);

        // CAPACITY: default 16. When full -> newCapacity = (old * 2) + 2
        StringBuffer sb4 = new StringBuffer();
        System.out.println(sb4.capacity());    // 16
        sb4.append("abcdeabcdeabcdea");        // exactly 16 chars, still fits
        System.out.println(sb4.capacity());    // 16
        sb4.append("x");                       // 17th char -> grows
        System.out.println(sb4.capacity());    // 34

        StringBuffer sb5 = new StringBuffer("bbbbb");
        System.out.println(sb5.capacity());    // 16 + length of initial text = 21

        /*
         *              String          StringBuilder     StringBuffer
         * Mutable      No              Yes               Yes
         * Thread-safe  Yes (immutable) No                Yes (synchronized)
         * Speed        slow for edits  fastest           slower
         * Since        1.0             1.5               1.0
         */
    }
}


// =====================================================================================
// Common String methods
// =====================================================================================
class StringMethods {

    public static void main(String[] args) {

        String spaces = "   ";
        System.out.println(spaces == null);        // false - it is an object with length 3
        System.out.println(spaces.isEmpty());      // false - isEmpty() is true only when length == 0
        System.out.println(spaces.trim().isEmpty()); // true
        // Java 11+: spaces.isBlank() -> true (only whitespace). strip() is the unicode-aware trim()

        String str = " Hello, World! ";
        System.out.println(str.length());          // 15
        System.out.println(str.trim());            // removes leading/trailing spaces

        String s = "shubham";
        String s1 = "shuBHaM";
        System.out.println(s.equals(s1));            // false - case sensitive
        System.out.println(s.equalsIgnoreCase(s1));  // true

        String str7 = "Hello, World!";
        System.out.println(str7.startsWith("Hello") + " " + str7.endsWith("World!") + " " + str7.contains("lo, W"));
        System.out.println(str7.indexOf(",") + " " + str7.lastIndexOf("o") + " " + str7.indexOf("zz"));   // 5 8 -1
        System.out.println(str7.charAt(1));                         // e
        System.out.println(str7.substring(0, 5));                   // Hello (end index EXCLUSIVE)
        System.out.println(str7.substring(7));                      // World!
        System.out.println(str7.toUpperCase() + " " + str7.toLowerCase());
        System.out.println(Arrays.toString(str7.toCharArray()));

        // String is IMMUTABLE: methods return a NEW String, the original never changes
        String replaced = str7.replace("Hello", "Hi");
        System.out.println(str7 + " -> " + replaced);
        String noSpaces = "a b c".replaceAll(" ", "");   // replaceAll takes a REGEX, replace takes plain text
        System.out.println(noSpaces);

        System.out.println(str7.concat(" Bye"));
        System.out.println(String.join("-", "a", "b", "c"));        // a-b-c
        String[] parts = "aa bb cc".split(" ");
        System.out.println(Arrays.toString(parts));

        // compareTo: lexicographic (dictionary) comparison using unicode values
        // 0 -> equal, negative -> first comes BEFORE, positive -> first comes AFTER
        String s9 = "apple";
        String s10 = "leapp";
        System.out.println("apple vs leapp: " + s9.compareTo(s10));             // 'a' - 'l' = -11
        System.out.println("apple vs AppLE: " + s9.compareToIgnoreCase("AppLE")); // 0

        // STRING POOL (String Constant Pool, inside heap)
        String str18 = new String("Hello");   // new object on heap (outside pool)
        String str19 = "Hello";               // literal -> taken from / put in the pool
        String str21 = str18.intern();        // returns the pooled copy
        System.out.println(str18 == str19);   // false - different objects
        System.out.println(str19 == str21);   // true  - both are the pooled object
        System.out.println(str18.equals(str19)); // true - equals compares CONTENT -> always use equals()

        char[] array = {'a', 'b', 'c'};
        System.out.println(String.valueOf(array) + " " + String.copyValueOf(array) + " " + String.valueOf(1234));

        // count occurrences of a char with streams
        String s99 = "sdgabdhdgaedbdae";
        System.out.println("count of 'a': " + s99.chars().filter(ch -> ch == 'a').count());   // 3
    }
}
