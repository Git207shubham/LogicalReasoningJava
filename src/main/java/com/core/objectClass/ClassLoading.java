package com.core.objectClass;

public class ClassLoading {
    public ClassLoading() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("welcome");
        String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classpath);
    }
}

class Student {
    public Student() {
        System.out.println("obj Student created");
    }

    protected void finalize() throws Throwable {
        System.out.println("object closed");
        super.finalize();
    }
}

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
        System.out.println(t1);
        System.out.println("hashcode : " + t1.hashCode());
        System.out.println(t1.toString());
        System.out.println(t1 == t1);
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

    public boolean equals(Object obj) {
        Test1 tt = (Test1)obj;
        return tt.x == this.x;
    }
}

class Test2 {
    public Test2() {
    }

    public static void main(String[] args) {
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
