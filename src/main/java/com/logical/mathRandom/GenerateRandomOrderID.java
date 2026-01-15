package pack1;
import java.util.Random;

public class GenerateRandomOrderID {

	public static void main(String[] args) {

		Random random = new Random();

		// generate 8 digit random policy number
		long longPolicyNumber2 = random.nextLong();
		System.out.println(longPolicyNumber2);

		String s1 = "fhfd wesk hjsn ddjd poen";
		char[] array2 = { '@', '_', '-', '#' };
		String s2 = "a2z...A2Z...0123456789";

		// Valid password : "ddjd#33e8dy"

		String[] arrayOfWords = s1.split(" ");

		String sb = "POLICY-"+arrayOfWords[random.nextInt(4)] + array2[random.nextInt(4)] + random.nextInt(9) + random.nextInt(9);

		System.out.println(sb);
	}
}
