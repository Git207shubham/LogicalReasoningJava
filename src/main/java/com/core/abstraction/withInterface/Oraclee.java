package withInterface;

import withInterface.Database;

public class Oraclee implements Database {
	@Override
	public void rollback() {
		System.out.println("ORACLE ROLLBACK");
	}

	@Override
	public void commit() {
		System.out.println("ORACLE COMMIT");
	}

	@Override
	public void get() {
		System.out.println("ORACLE get");
	}

	@Override
	public void give() {
		System.out.println("ORACLE give");
	}

	@Override
	public void take() {
		System.out.println("ORACLE take");
	}

	public void gain() {
		System.out.println("Oracle gain");
	}

}
