package com.core.constructor;

/*Same name as class
No return type
Runs automatically when object is created
Used to initialize object state
Provided by compiler only if none exists

If we provide para constructor then compiler don't provide even default one so
if we try to create object with default then we get compiler error
*/

public class Test {
    public static void main(String[] args) {

        System.out.println("----- Creating Object -----");
        C obj = new C();

        System.out.println("\n----- Final Values -----");
        System.out.println("x = " + obj.x);
        System.out.println("y = " + obj.y);
        System.out.println("z = " + obj.z);
    }
}
