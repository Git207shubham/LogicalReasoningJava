package blocks;


public class B {
	int x;

	final int z;

	B() 
	{
		this(3.3f);
		x = 11;
		// this is present by default---this.x=11;
		System.out.println("constructor b");
	}

	{
		System.out.println("instanc block 1");
		x = 121;
		z = 33;
	}
	{
		System.out.println("instanc block 2");
		// below value overrides first insance block
		x = 12;
	}

	B(float s) 
	{
		System.out.println("par--aa "+s);
		
		B bb = this.instance();  // or  instance();
		
	}

	public B instance() {
		System.out.println("welcome to instance  method");
		return this;
	}
	public static void main(String[] args) {
		B a = new B();

		System.out.println("x : " + a.x);
		System.out.println("z : " + a.z);
	}

}
