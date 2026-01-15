package if_else;

public class A
{
   public void table2()
   {
     int i;
     for(i=1;i<=10;i++)
     {
       System.out.println(2*i);
     }
   }
   
   public void odd()
   {
      int n=20;
      do
      {
      {if(n%2!=0)
       {
       System.out.println(n);
       }
      }
      n++;
      }while(n<=40);
    }
    
   public void even()
    {
     int n=1;
     while(n<=20)
     {
       {if(n%2==0)
       {   
    	 System.out.println(n);
         
       } }
       n++;
     }
   }
   public void reverse()
   {
       int n=10;
       do{
       System.out.println(4*n);
       n--;
      }while(n>=1);
    }
}
