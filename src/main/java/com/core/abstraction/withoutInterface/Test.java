package com.core.abstraction.withoutInterface;

import com.core.abstraction.withoutInterface.Oracle;

public class Test {
	public static void main(String[] args) {
		Oracle o = new Oracle();
		o.getOracle();
		o.commitOracle();
		o.giveOracle();
		o.takeOracle();
		o.rollbackOracle();

	}
}
