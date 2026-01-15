package superANDthis_constructor;

public class B extends A {

	public B() {
		System.out.println("no-arg-constructor-B");
	}

	public B(String x) {
		super(10);
		System.out.println("arg-constructor-B");
	}

	public static void main(String[] args) {

		B b = new B();

		B b1 = new B("cjc");
	}
}

class A {

	public A() {
		// this(10.5f);
		System.out.println("No-arg-constructor-A");
	}

	public A(int x) {
		// this();
		System.out.println("int-arg-const=A");
	}

	public A(double x) {
		System.out.println("double-arg-const-A");
	}
}
