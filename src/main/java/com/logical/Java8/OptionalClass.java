package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

// Optional reminds us explicitly about object can be null also so provide preventive code

public class OptionalClass {
	public static void main(String[] args) {
		
		String string21 =  "String value";
		Optional<String> opt21 = Optional.of(string21);
		System.out.println( opt21.get()  );


		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(14);
		list.add(24);

//		list = null;
		
			
		// System.out.println(list.get(2));

		Optional<List<Integer>> oo = Optional.of(list);
		System.out.println(oo.get());
		
		Random random = new Random();

		Consumer<List<String>> c = list3->System.out.println((list3.get(random.nextInt(list3.size()))));
		
		
		Consumer<String> cc=s->System.out.println(s.length());
		
		Consumer<List<Integer>> ccc = list3->System.out.println((list3.get(random.nextInt(list3.size()))));
		
		
		oo.ifPresent( ccc );   //opt has List<String>
		
		
//		Optional<List<Integer>> opt = Optional.ofNullable(list);

//		//System.out.println(opt.filter((x) -> x.contains(112)).get());
//
//		System.out.println(opt.get());

//		System.out.println(oo.orElse(new ArrayList<Integer>()));
//============
		// Creating an Optional with a non-null value
		Optional<String> opp = Optional.ofNullable("Hello, World!");
		
		System.out.println(opp.orElse("default"));

		// Using map to transform the value inside the Optional
		Optional<Integer> transformedOptional = opp.map(s -> s.length());

		// Printing the result
		transformedOptional.ifPresent(length -> System.out.println("Length: " + length));

	
	}
}
