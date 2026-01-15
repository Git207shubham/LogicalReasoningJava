package if_else;

import java.util.Scanner;
public class B
{
   public static void main(String args[])
   {
    A aa=new A();
    Scanner sc=new Scanner(System.in);
    System.out.println("enter 1 or 2 or 3 or 4");
    int ss=sc.nextInt();
    switch(ss)
    {
     case 1 : aa.table2();
                 break;
     case 2 : aa.even();
                 break;
     case 3 : aa.odd();
                 break;
     case 4 : aa.reverse();
                 break;
                                                                                                                                                                                                                                                               default : System.out.println("ENTER VALID INPUT");
  }
  }
}
