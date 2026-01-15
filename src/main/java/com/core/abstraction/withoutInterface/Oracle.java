package com.core.abstraction.withoutInterface;

import com.core.abstraction.withoutInterface.Database;


public class Oracle extends Database
{
  public void rollbackOracle()
  {
	  System.out.println("ORACLE ROLLBACK");
  }
  public void commitOracle()
  {
	  System.out.println("ORACLE COMMIT");
  }
  public void getOracle()
  {
	  System.out.println("ORACLE get");
  }
  public void giveOracle()
  {
	  System.out.println("ORACLE give");
  }
  public void takeOracle()
  {
	  System.out.println("ORACLE take");
  }
  
}
