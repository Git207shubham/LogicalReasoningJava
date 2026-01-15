package withInterface;

import withInterface.Database;

public class Mysqll implements Database {
	@Override
	public void commit() {
		System.out.println("Mysql  COMMIT");
	}

	@Override
	public void rollback() {
		System.out.println("Mysql  COMMIT");
	}

	@Override
	public void get() {
		System.out.println("Mysql  get");
	}

	@Override
	public void give() {
		System.out.println("Mysql  give");
	}

	@Override
	public void take() {
		System.out.println("Mysql  take");
	}
}
