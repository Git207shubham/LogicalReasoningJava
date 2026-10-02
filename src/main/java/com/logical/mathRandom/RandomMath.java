package pack1;
import java.util.Random;

public class RandomMath {

	public static void main(String[] args) {

		Random random = new Random();

		// exactly 8 digits: 10,000,000 .. 99,999,999
		int eightDigit = 10_000_000 + random.nextInt(90_000_000);

		String[] words = "fhfd wesk hjsn ddjd poen".split(" ");
		char[] symbols = {'@', '_', '-', '#'};

		// use .length instead of hard-coded numbers -> never off-by-one, survives adding items
		String policyId = "POLICY-"
				+ words[random.nextInt(words.length)]
				+ symbols[random.nextInt(symbols.length)]
				+ random.nextInt(10)
				+ random.nextInt(10);

		System.out.println(eightDigit);
		System.out.println(policyId);    // e.g. POLICY-poen#47


//		Method							Returns			Range
//		nextInt()						int				full int range
//		nextInt(n)						int				0 .. n-1
//		nextInt(a, b) 					(Java 17)		int	a .. b-1
//		nextLong()						long			full long range
//		nextDouble() / nextFloat()		double / float	0.0 .. <1.0
//		nextBoolean()					boolean			true / false


		// Math.PI;  --- value of PI == 3.141
		// Math.sqrt(x);  --- square root of positive number
		// Math.max(a, b); --- max among two numbers
		// Math.min(a, b); --- min among two numbers
		// Math.abs(x);    --- absolute value ir remove negative sign
	}
}
