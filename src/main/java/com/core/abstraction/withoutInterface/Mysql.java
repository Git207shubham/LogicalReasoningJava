package com.core.abstraction.withoutInterface;

import com.core.abstraction.withoutInterface.Database;

public class Mysql  extends Database
{
	public void commitMysql ()
	  {
		  System.out.println("Mysql  COMMIT");
	  }
	public void rollbackOracle()
	  {
		  System.out.println("Mysql  COMMIT");
	  }
	public void getOracle()
	  {
		  System.out.println("Mysql  get");
	  }
	public void giveOracle()
	  {
		  System.out.println("Mysql  give");
	  }
	public void takeOracle()
	  {
		  System.out.println("Mysql  take");
	  }
}
