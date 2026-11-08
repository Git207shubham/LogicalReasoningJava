package com.core.objectClass;

public class ClassLoading {
    public ClassLoading() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("welcome");
        // classpath = folders/jars the JVM's class loader searches to find .class files
        String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classpath);
    }
}

class Student {
    public Student() {
        System.out.println("obj Student created");
    }

    // finalize() is called by the garbage collector before the object is removed
    // there is no guarantee WHEN or even IF it runs; deprecated since Java 9
    protected void finalize() throws Throwable {
        System.out.println("object closed");
        super.finalize();
    }
}

// Object class methods: toString(), hashCode(), equals(), getClass(), clone()
// Cloneable must be implemented, otherwise clone() throws CloneNotSupportedException
class Test1 implements Cloneable {
    int x;

    public Test1() {
    }

    public static void main(String[] args) {
        System.out.println("print test--1");
        Test1 t1 = new Test1();
        t1.x = 20;
        new Test1();
        Test1 t3 = new Test1();
        t3.x = 20;
        // default toString() = ClassName@hexHashCode, e.g. com.core.objectClass.Test1@1b6d3586
        System.out.println(t1);
        System.out.println("hashcode : " + t1.hashCode());
        System.out.println(t1.toString());
        System.out.println(t1 == t1);
        // equals() is overridden to compare x -> true; == compares references -> false
        System.out.println(t1.equals(t3));
        System.out.println(t1 == t3);
        System.out.println(t1.getClass());

        try {
            Test1 t4 = (Test1)t1.clone();
            System.out.println(t4);
        } catch (CloneNotSupportedException var5) {
            var5.printStackTrace();
        }

        System.out.println(t1.getClass());
    }

    // NOTE: when equals() is overridden, hashCode() should be overridden too,
    // otherwise equal objects can land in different HashMap/HashSet buckets
    public boolean equals(Object obj) {
        Test1 tt = (Test1)obj;
        return tt.x == this.x;
    }
}

class Test2 {
    public Test2() {
    }

    public static void main(String[] args) {
        // objects with no reference are eligible for garbage collection right away
        // "object closed" may or may not print, because GC may never run in a short program
        // (System.gc() only requests it)
        new Student();
        new Student();
        new Student();
        new Student();
        new Student();
        Student st1 = null;
        System.out.println("aa");
        System.out.println("aaaa");
    }
}
