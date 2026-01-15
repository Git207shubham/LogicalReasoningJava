package thiss;

public class Test {

	float x;
	float y;
	float z; // variable global declaration is required
	float w; // if we are using them as them not as new variable in other methods
	float p;
	float q;

	public Test(float x, float y) {
		this.x = x;
		this.y = y;
		float z = x + y;
		float w = x - y;
		float p = x * y;
		float q = x / y;
		// doing sum of global varibale and savig in new local variables
		System.out.println("SUM :" + z);
		System.out.println("SUB :" + y);
		System.out.println("MULT :" + p);
		System.out.println("DIV :" + q);

		print();
	}

	public void print() {
		// printing default global variblas so will give null
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("SUM=" + z);
		System.out.println("SUB=" + w);
		System.out.println("PRODUCT=" + p);
		System.out.println("DIVISION=" + q);
	}

	public static void main(String args[]) {
		Test a = new Test(20f, 3.2f);

	}
}
