package com.logical.arrySringRelated;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ArrayMethodsDemo {

    public static void main(String[] args) {

        int[] baseArr = {10, 20, 30};
        // length is NOT a method, it's a variable of type: int
        // returns number of elements the array contains
        System.out.println("length: " + baseArr.length);

        // 2D array --- length provie -- number of rows
        int[][] arr = {
                {1, 2, 3},       // 3 elements
                {4, 5, 6, 7}     // 4 elements
        };
        // arr.length      // 2 → number of rows
        // arr[0].length   // 3 → first row has 3 elements
        // arr[1].length   // 4 → second row has 4 elements

        /* =========================
         toString() is an inbuilt method in Arrays class Converts 1D array to readable String
         and returns that readable String
        iterates an array and binds all elements using comma and wraps in []
        ========================== */
        int[] arr = {5, 2, 9, 1};
        System.out.println("toString(): " + Arrays.toString(arr));


        /* =========================
           sort() is an inbuilt method in Arrays class
           Sorts primitive , Sting , Wrapper , Custom Comparable arrrays
         */
        ========================== */
        Arrays.sort(arr);
        System.out.println("sort(): " + Arrays.toString(arr));
        //line : 577


        /* =========================
           3. binarySearch() is an inbuilt method in Arrays class
           Searches element and returns index of the element
           and gaurantees correct result in a sorted array only
           Breaks array in half and compare the number to middle number
           then again so iterations arevery leass for 100000 data
           but should be sorted
           Return type: int (index or negative value)

           For normal search , we need to use for loop and
           start searching one by one
           for 10000 , we repeat 10000 times
        ========================== */
        int index = Arrays.binarySearch(arr, 5);
        System.out.println("binarySearch(5): " + index);


        /* =========================
          equals() is an inbuilt method in Arrays classs
          which checks whether exact content of two arrays is same or not
          For non-primitive it compares hashcode/reference
          returns boolean value
         */
        ========================== */
        int[] arr2 = {1, 2, 5, 9};
        System.out.println("equals(): " + Arrays.equals(arr, arr2));


        /* =========================
           fill() is an inbuilt method in Arrays classs which
           Fills every index of a given array with given value
           Modifies the array and returns nothing
        ========================== */
        int[] charArray = new char[5];
        Arrays.fill(fillArr, '8');
        System.out.println("fill(): " + Arrays.toString(fillArr));


        /* =========================
           copyOf() is an inbuilt method in Arrays classs which
           creates and returns a new array of provided size
           and copies all posible elements from the input array to this newly created array  ,

           originalArray, newLength

           if original array length is larger and size we provided is
           smaller then then create new array by trimming the extra elements
           same as with larger the fills with default value of datatypes
           Return type: same as array type (int[])
        ========================== */

        int[] copyArr = Arrays.copyOf(arr, 6);
        System.out.println("copyOf(): " + Arrays.toString(copyArr));


        /* =========================
           copyOfRange() is an inbuilt method in Arrays classs which
           creates and returns a new array of size as per index range provided
           is used to copy a specific portion (range) of an array into a new array

         Arrays.copyOfRange(originalArray, from, to);
         -- from-inclusive --to excluded
        ========================== */
        int[] rangeArr = Arrays.copyOfRange(arr, 1, 3);
        System.out.println("copyOfRange(): " + Arrays.toString(rangeArr));


        /* =========================
           stream() is an inbuilt method in Arrays class
           which Converts array to Stream as per the datatype of the array elements
           Return type: IntStream (for int[]) , stream of ints
           then we can run aggregate functions on it and other java 8 features on it
        ========================== */
        int[] intArray = {5, 2, 9, 1};
        IntStream stream = Arrays.stream(intArray);

        int sum = stream.sum();
        System.out.println("stream().sum(): " + sum);

        double[] doubleArray = {1.5, 2.7, 3.14};
        DoubleStream doubleStream = Arrays.stream(doubleArray);

        double  average = Arrays.stream(arr).average().orElse(0.0);
        System.out.println("average().average(): " + average);

        long[] longArray = {100L, 200L, 300L};
        LongStream longStream = Arrays.stream(longArray);
        // for remaining primitive no inbuilt method provided

        // Stream of String , Wrapper , Custom Objects
        String[] stringArray = {"apple", "banana", "cherry"};
        Stream<String> stringStream = Arrays.stream(stringArray);

        Integer[] boxedIntArray,integerArray = {5, 2, 9, 1};
        Stream<Integer> boxedIntStream = Arrays.stream(boxedIntArray);

        Stream<User> userStream = Arrays.stream(userArray):

        // applies to every non-primitive datatype
        int sum2 = Arrays.stream(integerArray)   // Stream<Integer>
                    .mapToInt(Integer::intValue)  // IntStream
                    .sum();
        System.out.println(Arrays.toString(integerArray)+"stream().sum(): " + sum2);


        // toArray -- converts a  stream to an Array of Objects
        int[] arr3 = list.stream()
                        .mapToInt(Integer::intValue) // Stream<Integer>
                        .toArray();
        Object[] arr1 = list.stream().toArray();

        List<Integer> listOfInteger = Arrays.stream(integerArray)   // Stream<Integer>
                .collect(Collectors.toList());


        // toArray -- converts a  List to an Array of given datatype by converting to stream first
        Integer[] arr2 = list.stream()
                        .toArray(Integer[]::new);

        int[] intArray = {5, 2, 9, 1};
        Stream<Integer> boxedStream = Arrays.stream(intArray)
                                            .boxed();

        int[] intArray = {5, 2, 9, 1};
        Integer[] boxedArray = Arrays.stream(intArray)
                                .boxed()
                                .toArray(Integer[]::new);

        /* =========================
           setAll() is an inbuilt method in Arrays class with return type void
           which Resets values in the array using index-based logic
           for every index in the array,
           calculate a new value using that index only and put the result at that index.
        ========================== */
        long[] longArray = new long[5];
        logicArr[0]=12L;
        logicArr[1]=10L;
        logicArr[2]=8L;

        Arrays.setAll(logicArr, i -> i * 10);
        System.out.println("setAll(): " + Arrays.toString(logicArr));

        //Stream<Integer> stream1 , and i have applied strem() on List<Integer>

        //If we want to modify the array and do some operation using values then use Stream
        //and use toArray / collect as per the return object required

        List<Long> result = Arrays.stream(longArray) // we got LongStream now , stream , now we can do any operation
                .map(element -> element * 5)
                .boxed()                             // we got Stream<Long>
                .collect(Collectors.toList());

        long[] result = Arrays.stream(longArray)
                .map(element -> element * 5)
                .toArray();


        /* =========================
           parallelSort() is an inbuilt method in Arrays class with return type void
           which does Multi-threaded sorting not really needed for small arrays
        ========================== */
        int[] bigArr = {9, 3, 7, 1, 6};
        Arrays.parallelSort(bigArr);
        System.out.println("parallelSort(): " + Arrays.toString(bigArr));


        /* =========================
           parallelPrefix() is an inbuilt method in Arrays
           ReBuilds the array with cumulative results
           as per the lambda expression we have provided
           Return type: void
           (x, y) -> x + y mean?
           This is a lambda that tells Java how to combine the values
           It means each position contains the result accumulated so far
        ========================== */
        int[] prefixArr = {1, 2, 3, 4};
        Arrays.parallelPrefix(prefixArr, (x, y) -> x + y);
        System.out.println("parallelPrefix(): " + Arrays.toString(prefixArr));


        /* =========================
           clone()
           Creates shallow copy of array of primitive datatypes automatically create a
           deep copy because primitive types hold raw values
         */
           Return type: same as array type (int[])
        ========================== */
        int[] clonedArr = arr.clone();
        System.out.println("clone(): " + Arrays.toString(clonedArr));
        //Because int is a primitive type, the values themselves are copied
        //So practically, you can think of this as a completely independent copy
        //Changing one doesn't affect the other because they are totally seperate elements
        clonedArr[0] = 99;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(clonedArr));
        [10, 20, 30]
        [99, 20, 30]

        Person[] originalPersonArray = new Person[2];
        arr[0] = new Person("John");
        arr[1] = new Person("Mike");
        Person[] clonedPersonArray = originalPersonArray.clone();

        Notice that both arrays contain references pointing to the same Person objects.
        That's called a shallow copy.

        Deep copy
        Changing the object through one array
        doesn't change the corresponding object in the other array


        // Using Java 8 Streams
        Person[] deepCopy = Arrays.stream(originalPersonArray)
                .map(Person::new)       // maps data to new object
                .toArray(Person[]::new);

        /* =========================
           deepToString() converts and returns a multi-dimensional arrays as a String
        ========================== */
        int[][] matrix = {{1, 2}, {3, 4,5,6,7}};
        System.out.println("deepToString(): " + Arrays.deepToString(matrix));
        System.out.println(matrix.length);      // rows = 2
        System.out.println(matrix[0].length);   // columns in row 0 = 2
        System.out.println(matrix[1].length);

        /* =========================
           deepEquals()
           Compares two multi-dimensional arrays
           and returns a boolean value
        ========================== */
        int[][] matrix2 = {{1, 2}, {3, 4}};
        System.out.println("deepEquals(): " + Arrays.deepEquals(matrix, matrix2));


        //convertArrayToListAndSet();
        String[] stringArray = {"A", "B", "C", "A"};

        /* =====================================================
           1. Arrays.asList(array)
           Only works with Non-primitive , Wrapper , Custom objects
           RETURN TYPE: List<T>
           fixed-size List of same datatype as of the input array
           Its not an Arraylist or any other , its special list
        ===================================================== */
        List<String> list1 = Arrays.asList(stringArray);

        String[] names = {"Amit", "Rohit", "Virat"};
        List<String> nameList = Arrays.asList(names);
        System.out.println("asList(): " + nameList);

        // ADVANTAGES:
        // - Simple and fast
        // - Backed by original array (changes reflect)

        // ISSUES:
        // - Fixed size list (add/remove throws exception)
        // list1.add("D"); // ❌ UnsupportedOperationException
        System.out.println("Arrays.asList(): " + list1);


        /* =====================================================
           2. new ArrayList<>(Arrays.asList(array))
           Only works with Non-primitive , Wrapper , Custom objects
           RETURN TYPE: ArrayList<T>
        ===================================================== */
        List<String> list2 = new ArrayList<>(Arrays.asList(stringArray));

        // ADVANTAGES:
        // - Fully modifiable list
        // - Most commonly used in real projects

        // ISSUES:
        // - Slight extra memory (copy happens)

        list2.add("D"); // ✅ Allowed
        System.out.println("ArrayList from asList(): " + list2);


        /* =====================================================
           3. Collections.addAll(list, nonPrimitiveWrapperStringCustomArrays)
           Only works with Non-primitive , Wrapper , Custom objects
           RETURN TYPE: ArrayList<T>
        ===================================================== */
        List<String> list3 = new ArrayList<>();
        Collections.addAll(list3, arr);

        // ADVANTAGES:
        // - Clean & readable
        // - Modifiable list

        // ISSUES:
        // - Slightly verbose

        System.out.println("Collections.addAll(): " + list3);


        /* =====================================================
           4. Stream API → List
           RETURN TYPE: List<T>
        ===================================================== */
        List<String> list4 = Arrays.stream(stringArray).
                collect(Collectors.toList());

        int[]--> boxed().collect(Colectiors.toList());
        Arrays.stream(integerArray).collect(Collectors.toList());
        System.out.println("Stream toList(): " + list4);

        /* =====================================================
           5. List.of(array)  (Java 9+)
           RETURN TYPE: Immutable List<T> - Cannot add/remove/update  -- Throws UnsupportedOperationException
        ===================================================== */
        List<String> list5 = List.of(stringArray);
        System.out.println("List.of(): " + list5);

        /* =====================================================
           6. Array → Set using HashSet
           RETURN TYPE: Set<T>
           Removes duplicates
           Does not guarantee insertion order
        ===================================================== */
        Set<String> set1 = new HashSet<>(Arrays.asList(arr));
        System.out.println("HashSet: " + set1);

        /* =====================================================
           7. Array → Set using Stream
           RETURN TYPE: Set<T>
           Removes duplicates
           Does not guarantee insertion order
           No control over Set implementation used like earlier way of getting a Set
        ===================================================== */
        Set<String> set2 = Arrays.stream(arr).collect(Collectors.toSet());
        System.out.println("Stream toSet(): " + set2);

        /* =====================================================
           8. Array → LinkedHashSet
           RETURN TYPE: LinkedHashSet<T>
           Removes duplicates
           Maintains insertion order
        ===================================================== */
        Set<String> set3 = new LinkedHashSet<>(Arrays.asList(arr));
        System.out.println("LinkedHashSet: " + set3);

        /* =====================================================
           9. Array → TreeSet (sorted set)
           RETURN TYPE: TreeSet<T>
           - Removes duplicates
           - Sorted output
        ===================================================== */
        Set<String> set4 = new TreeSet<>(Arrays.asList(arr));
        System.out.println("TreeSet: " + set4);
    }
}



// 5 types of array in java
class Array11 {
    public static void main(String[] args) {

        //ways to create an array
        //#######################################################################

        float[] floatArray = new float[4];
        floatArray[0] = 10f;
        floatArray[1] = 20.4f;
        floatArray[2] = 30.0f;
        System.out.println("Float Array = " + floatArray.toString());

        char[] charArray1 = new char[]{'a', 's', 'w', 's', 'k', 'p'};
        System.out.println("Size/capacity = " + charArray1);
        System.out.println("length = " + charArray1.length);

        // now size auto taken as 7 ,
        // manually declaring size is now allowed as ,
        // then we can declare size 4 and add 7 elements
        //---either declare or initialise --not both

        char[] charArray = {'1','4','v','w','9','p','1'};
        System.out.println("Char Array = " + charArray.toString());

        String ss1 = "shubham shende";
        char[] ar4 = ss1.toCharArray();
        // since string is a is collection of characters we can get collection of characters ie array from a String
        System.out.println("Char Array = " + charArray.toString());

        // not char[5] array = new char[];
        // not char[5] array = new char[5];
        // yes char[] array = new char[5];
        // yes char[] array = new char[]{'v','w','9','p'};


        // data types can be stored in an array
        //#######################################################################

        /*
           Primitive Arrays
        */

        // stores one character
        // 0 to 65,535  --multilingual and english and symbols special chars
        char[] charArray = {'a', 'b'};
        System.out.println("charArray = " + Arrays.toString(charArray));

        // small whole number  -128 to 127
        byte[] byteArray = {1, 2};
        System.out.println("byteArray = " + Arrays.toString(byteArray));

        // big whole number -32,768 to 32,767
        short[] shortArray = {10};
        System.out.println("shortArray = " + Arrays.toString(shortArray));

        // large whole number -2,147,483,648 2,147,483,647
        // −214.75 crore
        int[] intArray = {1, 4, 23, 5, 76, 13, 64};
        String stringFromArray  = Arrays.toString(intArray);
        System.out.println("intArray = " + stringFromArray);

        // explicitly f is needed , otherwise it will be assumed as Double
        // −3.4 × 10³⁸
        float[] floatArray = {1.2f};
        System.out.println("floatArray = " + Arrays.toString(floatArray));

        double[] doubleArray = {1.1, 2.2};
        // d is not needed
        // −1.8 × 10³⁰⁸
        System.out.println("doubleArray = " + Arrays.toString(doubleArray));

        // −9.22 × 10¹⁸
        // ading L is needed
        long[] longArray = {100L};
        System.out.println("longArray = " + Arrays.toString(longArray));

        boolean[] booleanArray = {true, false};
        System.out.println("booleanArray = " + Arrays.toString(booleanArray));

        /* =======================
           2️⃣ String Array ie Non-primitive array
        ======================= */

        String[] nameArray = {"A", "B"};
        System.out.println("nameArray = " + Arrays.toString(nameArray));

        /* =======================
           3️⃣ Wrapper Class Array ie Non-primitive array
        ======================= */

        Integer[] integerWrapperArray = {1, 2};
        System.out.println(
                "integerWrapperArray[0] = " + integerWrapperArray[0] +
                        " | instanceof Integer = " +
                        (integerWrapperArray[0] instanceof Integer)
        );

        /* =======================
           4️⃣ Custom Class Array ie Non-primitive array
        ======================= */

        Student[] studentArray = new Student[5];
        studentArray[0] = new Student(1, "Rahul");
        studentArray[1] = new Student(2, "Neha");

        System.out.println("studentArray = " + Arrays.toString(studentArray));

        /* =======================
           5️⃣ Object Array (Mixed Types) ie Non-primitive array
        ======================= */

        Object[] objectArray = new Object[4];
        objectArray[0] = "Hello";
        objectArray[1] = 100; // autoboxed int to Integer and stores
        objectArray[2] = new Student(3, "Asha");

        System.out.println("objectArray = " + Arrays.toString(objectArray));
    }
}


@AllArgsConstructor
@Data
class Student implements Comparable<Student>{
    int id;
    String name;

    @Override
    public int compareTo(Student other)
    {
        return Integer.compare(this.id, other.id);
        // ascending order by id
    }
}


//sorting and reversing array
class Array3 {
public static void main(String[] args) {

        // reverse the existing array of int/string/char  -- manual way only , no shortcut
        int[] intArray = {1, 2, 3, 4, 5};
        reverseDoubleArray();
        System.out.println(Arrays.toString(intArray));

        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        Integer[] integerArray = {5, 2, 8, 1, 3};
        Arrays.sort(integerArray);
        System.out.println(Arrays.toString(integerArray));

        Integer[] sortedIntegerArray = Arrays.stream(integerArray).sorted().toArray(Integer[]::new);
        System.out.println(Arrays.toString(sortedIntegerArray));

        /*
           Can be used with
           Primitive datatype
           Objects
           Custom Comparable objects as per inbuilt compareTo method implemented in the class we need to modify existing class to implement Comparable interface
           Wrappers ie Integer
           String
         */


         /*
            use of Comparator to sort
            to reverse an array
            Custom Comparable objects as per inbuilt compareTo method implemented in the class we need to modify existing class to implement Comparable interface
            Wrappers ie Integer
            String
         */

        Integer[] arr = {5, 2, 8, 1, 3};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));


        Student[] studentArray = new Student[] {
                new Student(3, "Ravi"),
                new Student(1, "Amit"),
                new Student(2, "Neha")
        };


        //works with only comparable objects
        Arrays.sort(studentArray);

        // Collections.reverseOrder() → reverses the natural Comparable order if it exists
        Arrays.sort(studentArray,Collections.reverseOrder());


        //Anonymous Comparator (Old but valid)
        //Semicolon and curly braces needed with return statement
        Arrays.sort(studentArray, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.id, s2.id);
            }
        });
        Arrays.sort(studentArray, (e1, e2) -> Integer.compare(e1.id, e2.id));
        Arrays.sort(studentArray, (e1, e2) -> e1.id - e2.id);


        Arrays.sort(studentArray, Comparator.comparingInt(e -> e.id));
        Arrays.sort(studentArray, Comparator.comparingInt(Student::getId));

        Arrays.sort(studentArray, Comparator.comparingInt(e -> e.id).reversed());

        Arrays.sort(
                studentArray,
                Comparator.comparingInt(Student::getId).reversed()
        );

        //multilevel sorting , reversing

        Arrays.sort(
                studentArray,
                Comparator.comparingInt(Student::getId)
                        .thenComparing(Student::getName)
        );

        Arrays.sort(
                studentArray,
                Comparator.comparingInt(Student::getId)
                        .thenComparing(Student::getName)
                              .reversed()
        );


        String[] stringArray = {"A", "G", "C"};

        String[] stringArray1 =reverseStringArrayJava8(stringArray);
        System.out.println(Arrays.toString(stringArray)+" : "+Arrays.toString(stringArray1));


        List<String> listString2 = Arrays.asList(stringArray);
        Collections.sort(listString2);
        System.out.println("bbbb "+Arrays.toString(stringArray)+" : "+listString2);

        Collections.reverse(listString2);
        System.out.println("cc "+Arrays.toString(stringArray)+" : "+listString2);

        List<String> listString3 = new ArrayList<>(Arrays.asList(stringArray));
        Collections.reverse(listString3);
        // list is revered and array unaffected
        System.out.println("dd "+Arrays.toString(stringArray)+" : "+listString3);

        char[] charArray = new char[]{'f','s','w','s','k','p'};
        System.out.println(Arrays.toString(charArray));
        // becoz for primitive array is stored as one list element

        List<char[]> listChar = Arrays.asList(charArray);
        Collections.reverse(listChar);
        System.out.println(Arrays.toString(charArray) + " : " + listChar);

        char[] charArray1 = reverseCharArray(charArray);
        System.out.println(Arrays.toString(charArray1) + " : " + listChar);

        char[] charArray2 = reverseCharArrayJava8(charArray);
        System.out.println(Arrays.toString(charArray2) + " : " + listChar);

    }


    // reverse any array -- primitive , non-primitive , object
    public static void reverseDoubleArray() {

        double[] doubleArray = {1.1,4.5,2.6,7,3,8,9};

        int startIndex = 0;
        int endIndex = doubleArray.length - 1;
        System.out.println("Original : "+Arrays.toString(doubleArray));
        while (startIndex < endIndex) {
            int temp = doubleArray[startIndex];
            doubleArray[startIndex] = doubleArray[endIndex];
            doubleArray[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
        System.out.println("Reversed : "+Arrays.toString(doubleArray));


        startIndex = 0;
        endIndex = doubleArray.length - 1;
        do{
            int temp = doubleArray[startIndex];
            doubleArray[startIndex] = doubleArray[endIndex];
            doubleArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }while (startIndex < endIndex);
        System.out.println("Reversed : "+Arrays.toString(doubleArray));


        for(int i=0; i< doubleArray.length/2 ; i++)
        {
            int temp = doubleArray[i];
            doubleArray[i] = arr[doubleArray.length-1 - i];
            doubleArray[arr.length-1 - i] = temp;
        }
        System.out.println("Reversed : "+Arrays.toString(arr));

        int endIndex1 = doubleArray.length -1 ;
        for(int i=0; i< doubleArray.length/2 ; i++)
        {
            int temp = doubleArray[i];
            doubleArray[i] = arr[endIndex1];
            doubleArray[endIndex1] = temp;
            endIndex1--;
        }
        System.out.println("Reversed : "+Arrays.toString(arr));
    }

    public static String[] reverseStringArrayJava8(String[] arr) {
        return IntStream.range(0, arr.length)
                .mapToObj(i -> arr[arr.length - 1 - i])
                .toArray(String[]::new);
    }

    char[] reversedCharArray = new StringBuilder(new String(arr))
                                .reverse()
                                .toString()
                                .toCharArray();

    public static char[] reverseCharArrayJava8(char[] arr) {
        return IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString()
                .toCharArray();
    }

}

// get min and max int/long/double/float/integer from int array
// 1. sort and find
// 2. assume First element As Min/Max and iterate to find if any element is still smaller/greater
// 3. stream
class Array2 {
    public static void main(String[] args) {


        int[] array = {1, 4, 23, 5, 76, 13, 64,23};
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("min-" + array[0] + " max-" + array[array.length - 1]);

        // method -- 2
        int minDefault = array[0];
        for (int currentElement : array) {
            if (currentElement < minDefault) {
                minDefault = currentElement;
            }
        }

        int maxDefault = array[0];
        for (int currentElement : array) {
            if (currentElement > maxDefault)
                maxDefault = currentElement;
        }
        System.out.println("min-" + minDefault + " max-" + maxDefault);


        //java 8  -- // Integer[]
        Arrays.stream(arr).min(Integer::compareTo).get().orElse(0);
        Arrays.stream(arr).max(Integer::compareTo).get().orElse(0);


        // int[]
        Arrays.stream(arr).min().getAsInt();  // -- getAsLong()
        Arrays.stream(arr).max().getAsInt();  //  -- getAsLong()

        OptionalInt min = Arrays.stream(arr).min();
        if (min.isPresent()) {
            System.out.println(min.getAsInt());
        } else {
            System.out.println("Array is empty");
        }

        //--------------------
        float[] floatArray = {10.5f, 5.2f, 20.8f, 3.1f, 15.6f};
        float min = (float) IntStream.range(0, floatArray.length)
                .mapToDouble(i -> floatArray[i])
                .min()
                .orElse(0.0);

    }
}

class Array4 {
    public static void main(String[] args) {

        /*
           Kth smallest and Kth larget ---first sort asc/desc then get array[n-1] and array[0]
        */

        Integer[] array = {1, 4, 23, 5, 76, 13, 64};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        String[] array1 = {"cc", "aa", "ww", "ff"};
        Arrays.sort(array1, Comparator.reverseOrder());
        System.out.println(Arrays.toString(array1));

        secondHighest();
        secondLowest();

    }


    public static void secondHighest() {

        int[] intArray = {10, 5, 20, 8, 20, 3};

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int current : intArray) {

            if (current > highest) {

                // store earlier highest as secondHighest and  reassign the highest as current
                secondHighest = highest;
                highest = current;

            } else if (current > secondHighest && current < highest) {

                // Current number is between highest and second highest so current need to be assigned to secondhighest
                secondHighest = current;

            }
        }

        if (secondHighest == Integer.MIN_VALUE) {
            System.out.println("No second highest element exists.");
        } else {
            System.out.println("Second highest element: " + secondHighest);
        }
    }



    public static void secondLowest() {

        int[] arr = {10, 5, 20, 8, 20, 3};

        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;

        for (int current : arr) {

            if (current < lowest) {
                // New lowest found
                secondLowest = lowest;
                lowest = current;

            } else if (current < secondLowest && current > lowest) {
                // Current value is between lowest and second lowest
                secondLowest = current;
            }
        }

        if (secondLowest == Integer.MAX_VALUE) {
            System.out.println("No second lowest element exists.");
        } else {
            System.out.println("Second lowest element: " + secondLowest);
        }
    }
}

class Array41 {
    public static void main(String[] args) {

        //#############################   distinct in an array  --  use of distinct() , hashSet()

        int[] intArray = {1, 4, 22, 14, 19, 9, 5, 7, 22, 0};
        Arrays.stream(intArray).distinct().toArray();
        // toArray() aplied on primitive Stream ie int, long, double gives primitive array ,
        // if applied on non-primitive stream without implementation then returns object array
        // if applied on Collections then returns as per the Implementation

        Integer[] numbers = {1, 2, 2, 3, 1};
        LinkedHashSet<Integer> set = new LinkedHashSet<>(Arrays.asList(numbers));
        Integer[] uniqueNumbers = set.toArray(new Integer[0]);
        // equivalent to (Integer[]: new)

        String[] namesStringArray = {"Amit", "Ravi", "Amit", "Neha", "Ravi"};
        String[] uniqueNamesStringArray
                = new LinkedHashSet<>(Arrays.asList(namesStringArray))
                .toArray(new String[0]);

        System.out.println(Arrays.toString(uniqueNamesStringArray));

        // For Strings
        String[] uniqueNamesStream = Arrays.stream(namesStringArray)
                .distinct()
                .toArray(String[]::new);

        // For Integers
        Integer[] uniqueNumbersStream = Arrays.stream(numbers)
                .distinct()
                .toArray(Integer[]::new);

        Student[] students = {
                new Student(1, "Amit"),
                new Student(2, "Ravi"),
                new Student(1, "Amit"),
                new Student(3, "Neha")
        };

        Student[] uniqueStudentsStream = Arrays.stream(students)
                .distinct()   // distinct hash
                .toArray(Student[]::new);

    }
}

class Array42 {
    public static void main(String[] args) {

        duplicatesInArray();

        // to count how many time int, char, String , Integer occured
        withoutArrayCollectionObject();
        withCollectionObject();

    }

    public static void duplicatesInArray()
    {
        int[] intArray = {1, 2, 2, 3, 1, 2,7,3,9,12,12};

        Set<Integer> setOfInts= new HashSet<>();

        for(int i=0 ; i <= intArray.length-1 ; i++)
        {
            // inner for loop starting with i+1 is important
            for(int j=i+1 ; j <= intArray.length-1 ; j++) {
                if (intArray[i] == intArray[j]) {
                    // we can add to any collection but list will store 1  times
                    setOfInts.add(intArray[i]);
                } else {

                }
            }
        }
        System.out.println("List : "+listOfInt);
        System.out.println("Set : "+setOfInts);
    }


    public static void withoutArrayCollectionObject()
    {
        int[] arr = {1, 2, 2, 3, 1, 2};

        boolean[] counted = new boolean[arr.length];
        //marks the index as "true"
        // first for loop iteration
        // [true,2,2,3,true,2]
        // so when outer for loop iterates for 5th times then it does not count 4th index value = 1 once more

        for (int i = 0; i < arr.length; i++) {
            if (counted[i]) continue;

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
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println("int[]: " + countOccurrences(nums));

        // char[]
        char[] chars = {'a', 'b', 'a', 'c'};
        System.out.println("char[]: " + countOccurrences(chars));

        // String[]
        String[] names = {"Amit", "Ravi", "Amit", "Neha"};
        System.out.println("String[]: " + countOccurrences(names));

        // Integer[]
        Integer[] numsObj = {1, 2, 2, 3, 1};
        System.out.println("Integer[]: " + countOccurrences(numsObj));

        // Student[]
        Student[] students = {
                new Student(1, "Amit"),
                new Student(2, "Ravi"),
                new Student(1, "Amit"),
                new Student(3, "Neha")
        };
        System.out.println("Student[]: " + countOccurrences(students));
    }

    // int[] to Integer[]
    // char[] to Character[]
    public static <T> Map<T, Integer> countOccurrences(T[] arr) {
        Map<T, Integer> countMap = new HashMap<>();
        for (T elem : arr) {
            countMap.put(elem, countMap.getOrDefault(elem, 0) + 1);
        }
        return countMap;
    }
}

class Array5 {
    public static void main(String[] args) {

        // give pairs
        // give count

        int sum = 22;

        int[] array1 = {1, 4, 22, 14, 19, 9, 5, 7, 22, 0};

        System.out.println(Arrays.toString(array1));

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                if (array1[i] + array1[j] == sum && !map.containsKey(map) && !map.containsValue(map)) {
                    {
                        map.put(array1[i], array1[j]);
                    }
                }
            }
        }
        System.out.println(map);
        System.out.println(map.size() + "  times ");

    }
}

class Array6 {
    public static void main(String[] args) {

        //reverse a word
        String word="word";

        StringBuilder reversedWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord.append(word.charAt(i));
        }
        System.out.println(reversedWord);


        String sentence = "Reverse a sentence";
        String rev = "";
        char[] ch1 = sentence.toCharArray();
        for (int i = sentence.length() - 1; i >= 0; i--) {
            rev += ch1[i];
        }
        System.out.println(rev);

        StringBuffer rev2 = new StringBuffer();
        for (int i = sentence.length() - 1; i >= 0; i--) {
            rev2.append(sentence.charAt(i));
        }
        System.out.println(rev2);

        StringBuilder sb = new StringBuilder(sentence);
        // or create blank "" sb and then sb.append(stringObject); -- same result
        System.out.println(sb.reverse());
        String s2 = sb.reverse().toString();


        String sentence2 = "Reverse every word in this sentence";
        String reversed2 = Arrays.stream(sentence2.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(reversed2);


        String[] words = sentence2.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            result.append(reversedWord.reverse()).append(" ");
        }
        System.out.println(reversed2);

    }
}

// count which vowel how many times
class WhichVowelHowManyTimes {

    public static void main(String[] args) {

        withInitialisedCount();
        withoutCollection();
        withCollection();
    }

    public static void withInitialisedCount()
    {
        String string = "shubham anil shende";

        String input = string.toLowerCase();
        // Convert to lowercase for simplicity

        Map<Character, Integer> vowelCountMap = new HashMap<>();
        vowelCountMap.put('a', 0);
        vowelCountMap.put('e', 0);
        vowelCountMap.put('i', 0);
        vowelCountMap.put('o', 0);
        vowelCountMap.put('u', 0);

        for (char vowelElement : input.toCharArray()) {
            if (vowelCountMap.containsKey(vowelElement)) {
                vowelCountMap.put(vowelElement, vowelCountMap.getOrDefault(vowelElement,0) + 1);
            }
        }
        System.out.println("Vowel counts : "+vowelCountMap.entrySet());

    }

    public static void withoutCollection()
    {
        String string = "shubham anil shende";


        string = string.toLowerCase();

        // Array to store counts for vowels: a, e, i, o, u
        int[] counts = new int[5];

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            switch (ch) {
                case 'a':
                    counts[0]++;
                    break;
                case 'e':
                    counts[1]++;
                    break;
                case 'i':
                    counts[2]++;
                    break;
                case 'o':
                    counts[3]++;
                    break;
                case 'u':
                    counts[4]++;
                    break;
            }
        }
        System.out.println(counts[0]+" : "+counts[1]+" : "+counts[2]+" : "+counts[3]+" : "+counts[4]);
    }

}


class ConsSequenceOfInts {

    public static void main(String[] args)
    {
        System.out.println("hello...");

        int[] arrayOriginal = {87,23,7,13,25,14,3,18,15,12,30,31,32,33,34,35,24};

        for(int i=0 ; i<= arrayOriginal.length-1 ;i++)
        {
            for(int j=1 ; j<= arrayOriginal.length-1 ;j++)
            {
                /*if(arrayOriginal[j] > arrayOriginal[j-1])
                {
                    int temp = arrayOriginal[j];
                    arrayOriginal[j]=arrayOriginal[j-1];
                    arrayOriginal[j-1]=temp;
                }*/

                if(arrayOriginal[j] < arrayOriginal[j-1])
                {
                    int temp = arrayOriginal[j];
                    arrayOriginal[j]=arrayOriginal[j-1];
                    arrayOriginal[j-1]=temp;
                }
            }
        }

        System.out.println("New array : "+ Arrays.toString(arrayOriginal));

        int maxStreakOut=1;
        int endIndexOut=0;

        int maxStreak=1;
        int endIndex=0;

        for(int i=1 ; i < arrayOriginal.length ; i++)
        {
            if(arrayOriginal[i]==arrayOriginal[i-1])
            {
                continue;
            }

            if(arrayOriginal[i] == arrayOriginal[i-1]+1)
            {
                maxStreak++;
                endIndex=i;
                System.out.println("maxStreak : "+ maxStreak+" : "+arrayOriginal[i]);
            }else
            {
                maxStreak=1;
                //endIndex=i;
            }

            if(maxStreak>maxStreakOut  && arrayOriginal[i] == arrayOriginal[i-1]+1)
            {
                maxStreakOut=maxStreak;
                endIndexOut = endIndex;
                System.out.println("maxStreak : "+ maxStreak+" : "+endIndex+" : "+maxStreakOut+" : "+endIndexOut);
            }
        }

        System.out.println("maxStreak Last: "+ maxStreakOut+" : "+endIndexOut);


        // longest consecutive sequence , u can rearrage
        int[] arr = {100, 4, 200, 1, 3, 2};

        Set<Integer> set = new HashSet<>();

        for (int element : arr) {
            set.add(element);
        }

        int longestSequence = 0;

        for (int element : set) {

            // Start checking only if this is the beginning of a sequence
            if (!set.contains(element - 1)) {

                int currentElement = element;
                int currentSequence = 1;

                while (set.contains(currentElement + 1)) {
                    currentElement++;
                    currentSequence++;
                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        System.out.println("Longest consecutive sequence: " + longestSequence);


        String stringInput ="abcgad iwsadadda";
        Character firstNonRepeated = null;

        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count frequency of each character
        for (char ch : stringInput.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // LinkedHashMap maintains insertion order
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                firstNonRepeated = entry.getKey();
            }
        }
        System.out.println("First Non0-repeated : " + firstNonRepeated);

        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        firstNonRepeated = charCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);


        //duplicate elelment and arrange dublicate element in assending
        int[] arr = {9, 9, 3, 3, 8, 5, 5, 7, 2};

        List<Integer> duplicates = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        n -> n,
                        Collectors.counting()
                 ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(duplicates);


    }

    }
}
