package com.core.accessModifiers;

/*
private
Accessible only within the same class
NOT accessible outside the class whatsoever the condition is
So of course NOT inherited

Default (Package-private)
Accessible within the same package only
Not accessible outside the package
so ok to get Inherited only inside same package

protected
Accessible Within same class
Accessible Within same package
In subclass (child) even in different package
So of course Not accessible using object reference in different package

public
Accessible from anywhere
No restriction

*/

public class Test {
}
