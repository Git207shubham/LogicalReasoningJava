package com.logical.arrySringRelated;

import java.util.Arrays;
import java.util.Stack;

public class String_methods {

    public static void main(String[] args) {

        String s2 = "   ";
        System.out.println(s2 == null); // false becoz s2.length= 4

        String str = " Hello, World! ";
        int length = str.length(); // length is 13
        System.out.println(length);

        String str2 = "   \t\n";
        int length2 = str2.length(); // length is 1 ---measures blank spaces as well
        System.out.println(length2);

        //System.out.println(str2.isBlank()); // check if only blank spaces are there

        System.out.println(str2.isEmpty()); // has nothing--no char,spaces-- empty is blank ---blankc is not always
        // empty

        String s = "shubham";

        String s1 = "shuBHaM";

        System.out.println(s.equals(s1));
        System.out.println(s.equalsIgnoreCase(s1));

        String str7 = "Hello, World!";
        System.out.println(str7.startsWith("Hello")); // startsWith is true
        System.out.println(str7.endsWith("World!")); // endsWith is true

        String str8 = "Hello, World!";
        System.out.println(str8.indexOf(",")); // indexOfComma is 5
        System.out.println(str8.lastIndexOf(" ")); // lastIndexOfSpace is 7

        String str9 = "Hello, World!";
        // replace(CharSequence target, CharSequence replacement)
        String replaced = str.replace("Hello", "Hi");
        // replaced is "Hi, World!"

        char[] myarray = s1.toCharArray();
        System.out.println(Arrays.toString(myarray));

        System.out.println(s.concat(s1));

        String ss2 = "shu";
        System.out.println(s1.contains(ss2));

        // comparing strings lexicographically (based on their Unicode values).
        // apple and leapp --give 0 --output -ve value or +ve value
        String s9 = "aa";
        String ss = "ee";
        System.out.println(" lexographic diff " + ss.compareTo(s9));

        // apple and AppLE --gives zero
        System.out.println(s.compareToIgnoreCase(s1));

        String str3 = "  Hello, World!  ";
        String trimmed = str3.trim(); // trimmed is "Hello, World!"
        System.out.println(trimmed);

        String str4 = "Hello, World!";
        String sub = str4.substring(0, 5); // sub is "Hello"
        System.out.println(sub);

        // to get a string array
        String s5 = "aa bb cc dd aa ee bb bb";
        String[] ar5 = s5.split(" ");
        // List<String> aaa = Stream.of(ar5).collect(Collectors.toList());
        // System.out.println(aaa);

        String str5 = "Hello";
        char character = str5.charAt(1); // character is 'e'

        // intern----ADD THE STRING TO SCP
        String str18 = new String("Hello"); // Create a new string object
        String str19 = "Hello"; // This string is in the string pool

        // Use intern() to add str1 to the string pool
        String str21 = str18.intern();

        // Compare the references
        System.out.println(str18 == str19); // false (different references)
        System.out.println(str19 == str21); // true (both point to the string in the pool)

        System.out.println("use of valueOf on 1145 =" + String.valueOf("1145"));


        char[] array = {'a', 'b', 'c', 'd', 'e', 'f'};
        String string2 = String.copyValueOf(array);

        int n1 = 1234;
        System.out.println(String.valueOf(n1).length());


        //======
        String s99 = "sdgabdhdgaedbdae";
        System.out.println(s99.chars().filter(i -> i == 'a').skip(2).count());


        String sentence = "Reverse every word in this sentence";

        // DOESN'T MODIFY STRING...CREATES NEW ONE
        String neww = sentence.replaceAll(" ", "");
    }
}

// reverse a  string
class Test {
    public static void main(String args[]) {

        String sampleString = "Shubham Anil Shende";
        System.out.println("Sample String : " + sampleString.toString());

        StringBuffer stringBuffer1 = new StringBuffer(sampleString).reverse();
        System.out.println("Using stringBuffer1 : " + stringBuffer1.toString());

        StringBuilder stringBuilder1 = new StringBuilder(sampleString).reverse();
        System.out.println("Using stringBuilder1 : " + stringBuilder1.toString());

        char[] charArray = sampleString.toCharArray();

        // iterate and crate new using for loop

        Stack<Character> stack = new Stack<>();

        for (char character1 : charArray) {
            stack.push(character1);
        }

        StringBuilder stringBuilder2 = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder2.append(stack.pop());
        }

        // using steams is really lengthy for this

        // better to use St+ringBuilder reverse()


    }
}
