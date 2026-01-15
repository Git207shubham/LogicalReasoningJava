package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMapExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");

        // Using map to transform each word into its length
        List<Integer> mappedResult = words.stream()
                .map(word -> word.length())
                .collect(Collectors.toList());

        // Using flatMap to transform each word into a stream of characters
        List<Character> flatMappedResult = words.stream()
                .flatMap(word -> word.chars().mapToObj(ch -> (char) ch))
                .collect(Collectors.toList());
        
        
        //List<List<Long>> = stream().map(customer->customers.getAllPhoneNumbersForThisCustomer()).collect(Collectors.toList());

        // if want all phone numbers in a single list not List<List>
        
        //List<Long> = stream().flatMap(customer->customers.getAllPhoneNumbersForThisCustomer().stream()).collect(Collectors.toList());
        
        System.out.println("Mapped result: " + mappedResult); // Lengths of words
        System.out.println("FlatMapped result: " + flatMappedResult); // Characters from all words
    }
}

