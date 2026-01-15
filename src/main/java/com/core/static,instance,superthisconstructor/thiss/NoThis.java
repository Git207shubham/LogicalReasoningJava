package thiss;

public class NoThis {
	int x;
	int y;
	int z;
	int aa;

	public NoThis(int x, int y, int ss) {
		System.out.println("inside constructor");
		x = x; // this-- is used to identify instance
		y = y;
		z = x + y;
		// will give local values ie inside argument of this constructor
		System.out.println("local variable default x =" + x);
		System.out.println("local variable default y =" + y);
		System.out
				.println("sum of local variables z ( but z is considere das gloabal as its in locally present ) =" + z);

		// will give global values instantiated for this object using par constructor
		System.out.println("global variable default x =" + this.x);
		System.out.println("global variable default y =" + this.y);
		System.out.println("sum of local variables z =" + this.z);

		// since z not present locally so without using this ..compiler considers it as
		// global variable
		// but x and y are loaclly present so this tell compiler differentiate between
		// globala nd local we need to write --this

		this.aa = ss; // variable and then to initialise global variables fro that instance
	}

	public void print() {
		System.out.println("inside method");
		System.out.println("global variable default x =" + x);
		System.out.println("global variable default y =" + y);

		System.out.println("sum of local variables z =" + z);
		System.out.println("global variable aa =" + aa);
	}

	public static void main(String args[]) {

		NoThis a = new NoThis(10, 20, 99);
		a.print();
	}
}
