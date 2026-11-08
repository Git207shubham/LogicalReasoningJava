# ☕ Java Interview Answers — Core Java Q1–Q100 (Easy Version)

> **How to read this file**
>
> - 🧠 **Easy to remember:** a real-life example so you don't have to memorise words.
> - 💻 **Code:** a small example. You understand it; you don't need to memorise it.
> - ⭐ **Bonus:** extra points. Say them only if you feel confident.
>
> No comparisons with other languages. Everything is explained using Java only.

---

## 📑 Table of Contents

| # | Section | Questions (original numbers) |
|---|---|---|
| 1 | [Java Basics and Setup](#-java-basics-and-setup) | 1, 4, 2, 3, 5, 6 |
| 2 | [Data Types](#-data-types) | 7, 8, 9 |
| 3 | [Packages and Access Modifiers](#-packages-and-access-modifiers) | 10, 11, 12 |
| 4 | [Classes, Objects and Constructors](#-classes-objects-and-constructors) | 17, 18, 19, 20, 21, 39, 40, 41, 42, 44 |
| 5 | [Encapsulation and Abstraction](#-encapsulation-and-abstraction) | 22, 23 |
| 6 | [Inheritance and Relationships](#-inheritance-and-relationships) | 24, 25, 26, 27, 45, 43, 28, 29, 30, 31, 32 |
| 7 | [static Keyword and Blocks](#-static-keyword-and-blocks) | 58, 59, 56, 57, 55 |
| 8 | [final Keyword](#-final-keyword) | 60, 61, 62 |
| 9 | [Polymorphism and Overriding Rules](#-polymorphism-and-overriding-rules) | 33, 34, 35, 36, 37, 38 |
| 10 | [Interface and Abstract Class](#-interface-and-abstract-class) | 46, 47, 48, 49, 50, 51, 52, 53, 54 |
| 11 | [Object Class, equals and hashCode](#-object-class-equals-and-hashcode) | 64, 14, 65, 15, 66, 67, 68, 69, 70, 71 |
| 12 | [String](#-string) | 72, 76, 77, 78, 79, 80, 81, 82, 83, 73, 74, 75 |
| 13 | [Immutability, Records and Enums](#-immutability-records-and-enums) | 84, 63, 85, 86, 87, 88, 89, 13 |
| 14 | [Exception Handling](#-exception-handling) | 90, 91, 92, 93, 94, 16, 100, 95, 96, 97, 98, 99 |

> 🔀 **All questions 1–100 are grouped by topic**, so each answer leads into the next one. The original question numbers are kept, so they match the questions file.

---

# 🟦 Java Basics and Setup

> 🔗 **Why together:** What Java is and why it's used, then how it runs (JDK/JRE/JVM, platform independence), then the main method.

## 1. Features of Java?

> Java is **simple, object-oriented, platform independent, secure and robust**. 
It also supports **multithreading**. 
Its main idea is *"Write Once, Run Anywhere"*.

| Feature | Simple meaning |
|---|---|
| **Simple** | Easy to read and write. Java handles memory for you |
| **Object-Oriented** | We write code using classes and objects |
| **Platform Independent** | Same code runs on Windows, Linux, Mac |
| **Secure** | JVM checks that the bytecode is valid and safe
| **Robust** (strong) | Automatic memory cleanup (Garbage Collector) + exception handling = fewer crashes |
| **Multithreaded** | Can do many tasks at the same time |
| **High Performance** | The JVM turns frequently used code into fast machine code while the program runs |

> 💬 **Your question:** How is Java secure?
>
> ✅ **Answer:** Java has several safety checks built in:
> 1. **Bytecode verifier** — before running a `.class` file, the JVM checks that the bytecode is valid and safe (no broken or tampered code).
> 2. **No pointers** — we can't read or write a memory address directly, so a program can't access another program's memory.
> 3. **Array bounds are checked** — `arr[10]` on a 5-element array throws `ArrayIndexOutOfBoundsException` instead of quietly reading random memory.
> 4. **Class loaders protect core classes** — nobody can replace Java's own classes like `java.lang.String` with a fake one.
> 5. **Security libraries** — encryption, SSL/TLS, and frameworks like Spring Security.
>
> 🧠 Think of the JVM as a **security guard**: it checks every class at the door and doesn't let code touch memory directly.

> 💬 **Your question:** Why and how is Java high performance?
>
> ✅ **Answer:**
> - **Why it's a question at all:** Java runs bytecode, not machine code. Reading bytecode line by line (interpreting) is slower than running machine code directly.
> - **How Java becomes fast — the JIT compiler (Just-In-Time):** the JVM watches which methods run **again and again** ("hot" code). 
    It converts those methods into **native machine code** once, while the program is running, and reuses that fast version every time after.
> - **Other reasons:** a smart Garbage Collector cleans memory efficiently, and multithreading uses all CPU cores.


---

## 4. Why is Java mostly used for enterprise-level applications?

> Because Java is **stable, secure and scalable**, and it has a very strong set of frameworks like **Spring Boot and Hibernate**. 
Old Java code also keeps working on new Java versions, so companies feel safe using it for long-term projects.

Simple points:
- ✅ **Runs anywhere** — any server, any cloud, Docker.
- ✅ **Spring Boot, Hibernate, Kafka** — ready-made frameworks save time.
- ✅ **Secure** — good for banking and payment apps.
- ✅ **Handles heavy load** — multithreading.
- ✅ **Easy to maintain** — strong typing and OOP help big teams.
- ✅ **Long-term support (LTS) versions** — Java 8, 11, 17, 21, 25.
- ✅ **Big community** — easy to find developers and solutions.

---

## 2. What is JDK, JRE, JVM?

> - **JVM** (Java Virtual Machine) — **runs** the Java program.
> - **JRE** (Java Runtime Environment) — JVM + libraries. Needed to **run** a Java program.
> - **JDK** (Java Development Kit) — JRE + tools like the compiler (`javac`). Needed to **write and run** Java programs.

```
JDK  =  JRE  +  Development tools (javac, jar, debugger)
JRE  =  JVM  +  Libraries (java.lang, java.util ...)
JVM  =  The engine that runs the .class file
```

---

## 3. Why is Java platform independent?

> When we compile Java code, it does not become machine code. It becomes **bytecode** (a `.class` file). This bytecode can run on **any computer that has a JVM**. So the **bytecode is platform independent**, but the **JVM is platform dependent** (Windows has its own JVM, Linux has its own JVM).

```
Hello.java  --javac-->  Hello.class (bytecode)  -->  JVM on Windows → runs
                                                -->  JVM on Linux   → runs
                                                -->  JVM on Mac     → runs
```
---

## 5. How is the main method triggered in a Java project? Current updates?

> When we run `java MyClass`, the JVM **loads the class** into memory and calls the **`main` method**. That is the starting point of the program. It runs on a thread called the **main thread**.

```java
public static void main(String[] args) { }
```

| Word | Why it's needed (simple) |
|---|---|
| `public` | So the JVM can call it from outside |
| `static` | So the JVM can call it **without creating an object** |
| `void` | It doesn't return anything |
| `main` | Fixed name the JVM looks for |
| `String[] args` | Values we pass from the command line |

**In a Spring Boot project:**
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);   // starts Spring + Tomcat server
    }
}
```

**Current updates (easy version):**
- **Java 11:** You can run a file directly: `java Hello.java` (no separate compile step).
- **Java 25:** You can write a very short main method, without `public static` or `String[] args`:

```java
void main() {
    IO.println("Hello");
}
```

---

## 6. Can we overload the main() method?

> **Yes**, we can overload `main()` (same name, different parameters). 
But the **JVM always calls only `main(String[] args)`**. 
Other `main` methods behave like normal methods.

---

# 🟩 Data Types

## 7. What data types does Java support?

> Java has two types of data types:
> 1. **Primitive** — 8 basic types that store simple values: `byte, short, int, long, float, double, char, boolean`.
> 2. **Non-primitive (reference)** — store objects: `String`, arrays, classes, interfaces.

| | Primitive | Non-primitive |
|---|---|---|
| Example | `int age = 25;` | `String name = "Ram";` |
| Stores | The value itself | Address of the object |
| Default value | `0`, `false` | `null` |
| Has methods? | ❌ No | ✅ Yes (`name.length()`) |


---

## 8. Primitive data types, their range and how to use?

> There are 8 primitives. 4 are for whole numbers (`byte, short, int, long`), 2 are for decimals (`float, double`), 1 is for a character (`char`), and 1 is for true/false (`boolean`).

| Type | Size | Use it for | Example |
|---|---|---|---|
| `byte` | 1 byte | Very small numbers (-128 to 127) | `byte b = 10;` |
| `short` | 2 bytes | Small numbers | `short s = 1000;` |
| `int` | 4 bytes | **Normal numbers (most used)** — about ±2 billion | `int age = 25;` |
| `long` | 8 bytes | Very big numbers, IDs, time | `long id = 123456789L;` |
| `float` | 4 bytes | Decimals (less precise) | `float f = 3.5f;` |
| `double` | 8 bytes | **Decimals (most used)** | `double price = 99.99;` |
| `char` | 2 bytes | A single character | `char grade = 'A';` |
| `boolean` | — | true / false | `boolean active = true;` |

**Tips:**
- Put `L` after long numbers, `f` after float numbers.
- For **money**, use `BigDecimal`, not `double`, because `double` can give small rounding errors.

---

## 9. Autoboxing and Unboxing (automatically) ?

> **Autoboxing** means Java automatically converts a primitive into its wrapper object, like `int` → `Integer`.
> **Unboxing** is the reverse: `Integer` → `int`. 
> ✅ **Answer:** **Yes.** Java unboxes automatically whenever a primitive is needed — we never have to call `intValue()` ourselves.

| Primitive | Wrapper class |
|---|---|
| `int` | `Integer` |
| `char` | `Character` |
| all others | Same name with a capital letter: `byte→Byte`, `long→Long`, `double→Double`, `boolean→Boolean` ... |

---

# 🟨 Packages and Access Modifiers

> 🔗 **Why together:** Access modifiers depend on packages, so packages come first.

## 10. What is a package?
> A package is like a **folder** that groups related classes together. 
> It keeps code organised and avoids name conflicts, for example two classes with the same name in different packages.

| Type | Example |
|---|---|
| Built-in packages | `java.lang` (imported automatically), `java.util`, `java.io` |
| Our own packages | `com.company.controller`, `com.company.service`, `com.company.repository` |

---

## 11. Access modifiers?

> Access modifiers decide **who can use** a class, method or variable. 
Java has 4 Access Modifiers :

| Modifier | Who can access | Example from life |
|---|---|---|
| `private` | Only the **same class**
| *default* (no keyword) | Only the **same package** 
| `protected` | Same package + **child classes**
| `public` | Everywhere in the project

---

### 11.1 Can we use access modifiers on a class or interface?

It depends on whether the class or interface is **top-level** (on its own in the file) or **nested** (written inside another class).

**1️⃣ Top-level class / interface → only `public` or default**

public class Employee { }      // ✅ anyone can use it
class Helper { }               // ✅ default: only the same package can use it

**Why not private or protected?**
- **private** means only usable inside its own class. A top-level class isn't inside anything, so nobody could use it. That's pointless.
- **protected** is about child classes accessing parent **members**. A top-level class isn't a member of anything, so it doesn't apply.

**Rule to remember:** a `.java` file can have **only one `public` class**, and the file name must match it. `public class Employee` must be in `Employee.java`.

**Nested (inner) class / interface → all 4 allowed**


**Members inside an interface (often asked next)**

| Inside an interface | What's allowed |
|---|---|
| Methods | **`public`** by default; **`private`** allowed from Java 9. ❌ No `protected` |
| Variables | Always **`public static final`** (constants).



🧠 **Easy to remember:** **Outside = only 2 (public, default). Inside = all 4.**

> ⭐ **Bonus:** A top-level class can also use **non-access** modifiers: `abstract`, `final`, and `sealed` (Java 17). These aren't access modifiers, but interviewers sometimes mix them up.


---

# 🟧 Classes, Objects and Constructors

> 🔗 **Why together:** A class is the blueprint, an object is built from it, and the constructor (with `this`) is what builds it.

## 17. What is the Object-Oriented Programming concept?

> OOP is a way of writing programs using **objects**. Each object has **data (variables)** and **behaviour (methods)**. OOP has **4 pillars: Encapsulation, Abstraction, Inheritance, and Polymorphism.**

🧠 **Easy to remember the 4 pillars —

| Letter | Pillar | One line | Real-life example |
|---|---|---|---|
| **A** | Abstraction | Show only what's needed, hide details | You drive a car without knowing how the engine works |
| **P** | Polymorphism | One thing, many forms | A person is a son at home, an employee at office |
| **I** | Inheritance | Child gets parent's features | You get features from your parents |
| **E** | Encapsulation | Hide data, give controlled access | A medicine capsule hides the medicine inside |

**Why OOP?** Code reuse, easy to maintain, easy to understand, more secure.

---

## 18. Why is Java not a fully Object-Oriented language?

> Because Java has **primitive data types** like `int`, `char`, `boolean`, which are **not objects**. 
**static** methods and variables can be used without creating any object.

In a **pure** OOP language, the rule is: **everything happens through objects** — every value is an object, and every action is a method called **on an object**.
> `static` breaks that rule, because a static method or variable belongs to the **class**, not to any object. We can use it **without any object at all**:

MathUtil.square(5);    
Math.max(3, 7);  


## 19. What is a Class?

> A class is a **blueprint or template** for creating objects. 
It defines which **data** (variables) and **behaviour** (methods) the objects will have.

---

## 20. What is an Object?

> An object is a **real instance of a class**....not just blueprint like class but actual real thing ex. Completely built House using the the House Architecture Plan

It is created using the `new` keyword and is stored in memory (heap). 
It has **state** (actual values), **behaviour** (methods , which will be used to perform operations on the variables)

---

## 21. What is a method?

> A method is a **block of code that does a specific task or functionality**. 
Methods help us **reuse code** instead of writing it again and again , we just call the method.

```java
//  access   return  name   input-parameters
    public   int     add   (int a, int b) {
        return a + b;
    }
```
---

## 39. Constructor in Java and its use ?

> A constructor is a feature that is **called automatically/used when we create an object** using `new`.
It is used to **give initial values** to the fields object. 
It has the **same name as the class** and **no return type**.


**Constructor vs Method:**

| Constructor | Method |
|---|---|
| Same name as class | Any name |
| No return type | Has a return type (or `void`) |
| Runs automatically with `new` | We call it ourselves |

> 💬 **Your question:** Can we create a method with the same name as the class?
>
> ✅ **Answer:** **Yes, it compiles.** If it has a **return type** (even `void`), Java treats it as a **normal method**, not a constructor. 

---

## 40. Types of constructors?

> There are mainly two types: **default (no-argument) constructor** and **parameterized constructor**. If we don't write any constructor, Java gives a default one automatically.

| Type | Meaning |
|---|---|
| **Default constructor** | Java creates it automatically **only if we write no constructor** |
| **No-arg constructor** | We write it ourselves, with no parameters |
| **Parameterized constructor** | Takes values as parameters |
| **Copy constructor** | Takes another object of the same class and copies its values (we write it ourselves) |


> ⭐ **Bonus:** JPA/Hibernate entity classes **must have a no-arg constructor**.

> 💬 **Your question:** Why does a JPA entity need a no-arg constructor?
>
> ✅ **Answer:** When Hibernate reads a row from the database, it has to create the Java object itself. It does this in 2 steps:
> 1. Create an **empty object** using the no-arg constructor (through reflection). 
Hibernate doesn't know which of our constructors to call or what values to pass, so it needs one with **no parameters**.
> 2. **Fill the fields** one by one with the column values.
> 🧠 Hibernate is like a builder who gets an **empty box first** and then puts the items in one by one.

---

## 41. Can a constructor be private? Where is it used?

> **Yes.** A private constructor means **no one outside the class can create its object**.
It is used in the **Singleton pattern** (only one object) and in **utility classes** (only static methods, like `Math`).


```java
public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() { }              // no one else can do new AppConfig()

    public static AppConfig getInstance() {
        return INSTANCE;                 // everyone gets the same object
    }
}
```

---

## 42. Can a constructor be final / static?

> **No.** A constructor can't be `final`, `static` or `abstract`. It gives a compile error.

| Word | Why not? (simple) |
|---|---|
| `final` | `final` stops overriding, but constructors are **never inherited**, so there's nothing to stop |
| `static` | A constructor creates an **object**. `static` means "no object", so they don't match |
| `abstract` | `abstract` means "no body", but a constructor must have a body |

🧠 **Easy to remember:** A constructor can only have **access modifiers**: `public`, `protected`, default, `private for implmenting SingleTon`.

---

## 44. Use of `this`, `this()` keyword?

> - `this` means **the current object**. It is mainly used when the variable name and the parameter name are the same.
> - `this()` is used to **call another constructor of the same class**....pass parameters if we want to call parameterised constructor 

```java
public class User {
    String name;
    int age;

    User() {
        this("Guest", 18);          // this() → calls the other constructor
    }

    User(String name, int age) {
        this.name = name;           // this.name = object's variable, name = parameter
        this.age = age;
    }
}
```

**Common uses of `this`:**IMP IMP IMP IMP
1. To separate the object's variable from the parameter: `this.name = name;`
2. To call another constructor: `this(...)`
3. To pass the current object to a method: `save(this);`
4. To return the current object: `return this;`

🧠 **Easy to remember:** `this` = **"me / myself"**.

> ❌ `this` can't be used in a `static` method (static has no object).

---

# 🟪 Encapsulation and Abstraction

> 🔗 **Why together:** The two 'hiding' pillars of OOP, usually asked together.

## 22. What is Encapsulation in Java?

> Encapsulation means **keeping data and methods together in one class** and **hiding the data** from direct access. 
We make variables `private` and give access through **public getter and setter methods**.

**Easy to remember:** An **ATM**. You can't open the machine and take money. You must use the **buttons** (methods) not the hard cash, and the ATM checks your request first.

---

## 23. What is Abstraction, what is its use?

> Abstraction means **showing only the important things and hiding the implementation details**. 
In Java we achieve it using **abstract classes and interfaces**.

```java
interface Payment {
    void pay(double amount);    
}

class UpiPayment implements Payment {
    public void pay(double amount) {    // HOW to do — hidden from the user
        System.out.println("Paid " + amount + " using UPI");
    }
}

Payment p = new UpiPayment();
p.pay(500);                     // user just calls pay(), doesn't know the details
```

🧠 **Easy to remember:** When you press the **TV remote button**, the channel changes. You don't know (or care) how it works inside.

**Use:** reduces complexity, and we can change the implementation without changing the calling code.

**Encapsulation vs Abstraction (often asked together):**

| Encapsulation | Abstraction |
|---|---|
| Hides **data** | Hides **how it works** |
| Using `private` + getters/setters | Using interface / abstract class |
| ATM machine protects the money | Remote hides the circuit/ ATM screen/buttons are examples of Abstraction |

---

# 🟫 Inheritance and Relationships

> 🔗 **Why together:** Inheritance, then `super` and constructor chaining (which only make sense with a parent class), then IS-A vs HAS-A.

## 24. What is Inheritance?

> Inheritance means **one class (child) gets the variables and methods of another class (parent) ** using the `extends` keyword. 
It helps in **code reuse**. It represents an **IS-A** relationship.

```java
class Vehicle {
    void start() { System.out.println("Vehicle started"); }
}

class Car extends Vehicle {         // Car IS-A Vehicle
    void playMusic() { System.out.println("Playing music"); }
}

Car c = new Car();
c.start();       // got from parent
c.playMusic();   // its own
```

🧠 **Easy to remember:** A child gets features from their parents, like eye colour, and can also have new features of their own.

**Types supported in Java:**

| Type | Picture | Allowed? |
|---|---|---|
| Single | A → B | ✅ |
| Multilevel | A → B → C | ✅ |
| Hierarchical | A → B, A → C | ✅ |
| Multiple | A + B → C | ❌ with classes (✅ with interfaces) |

---

## 25. What are the rules to inherit and how is it achieved in Java?

> We achieve inheritance using `extends` (class to class) and `implements` (class to interface).

**Main rules (easy):**
1. A class can extend **only one class**, but can implement **many interfaces**.
2. **Private** members of the parent are **not accessible** in the child.
3. **Constructors are not inherited**. The child calls the parent constructor using `super() -- explicitly/implicitly`.
4. A **final class can't be extended**. A **final method can't be overridden**.
5. Every class automatically extends the **`Object`** class.

---

## 26. Restrictions while implementing inheritance? (like final class)

> We can't extend a `final` class, we can't override a `final` method, private members are not accessible, and Java doesn't allow one class to extend two classes.

| Restriction | Meaning | Example |
|---|---|---|
| `final` class | No one can extend it | `String` is final |
| `final` method | Child can't override it | |
| `private` members | Child can't access them | |
| `private` constructor | No one can create a child class from outside -- Child class default constructor will try to call parent constructor which is inaccessible , Compilation erro in class heading  
| `static` method | Can't be overridden | |
| Only one parent class | `class C extends A, B` ❌ | |

> ⭐ **Bonus (Java 17):** A `sealed` class lets you choose **exactly which classes** can extend it.

---

## 27. `extends` vs `implements`?

> `extends` is used to inherit from a **class** (only one). `implements` is used to implement an **interface** (can be many).

| | `extends` | `implements` |
|---|---|---|
| Used with | Class → Class (or Interface → Interface) | Class → Interface |
| How many? | Only **one** class | **Many** interfaces |
| What we get | Ready code from the parent | A list of methods we must write implementation for |


---

## 45. Use of `super`, `super()` keyword?

> - `super` refers to the **parent class**. We use it to call a parent's method or variable.
> - `super()` is used to **call the parent class constructors **.


---

## 43. What is constructor chaining?

> Constructor chaining means **calling one constructor from another constructor** using super() , this() keywords whenever required

**Easy rules:**
- `this()` or `super()` must be the **first line** of the constructor.
- You can't use both in the same constructor.
- If we don't write `super()`, Java adds it automatically - The **parent constructor always runs first**, then the child's.

---

## 28. What is an IS-A relationship?

> IS-A means **inheritance**. When a class extends another class (or implements an interface), we say the child **IS-A** type of the parent. 
A child object can be used anywhere the parent type is expected.
ex.Animal a = new Dog();                // ✅ allowed, because a Dog IS-A Animal
System.out.println(a instanceof Animal);  // true
System.out.println(a instanceof Dog);  // true

> ⭐ **Bonus:** We can check IS-A with the `instanceof` keyword.

---

## 29. What is a HAS-A relationship?

> HAS-A means **one class has an object of another class as a variable**. 
It is also called **composition** or **aggregation**.

---

## 32. Association vs Aggregation vs Composition?

> - **Association** — two classes are simply **connected** (they use each other).
> - **Aggregation** — HAS-A where the part **can live alone** (weak relationship).
> - **Composition** — HAS-A where the part **can't live without the whole** (strong relationship).


// Aggregation — Professor created outside and passed in
class Department {
    List<Professor> professors;
    Department(List<Professor> professors) { this.professors = professors; }
}

// Composition — Room created inside, dies with House
class House {
    List<Room> rooms = new ArrayList<>();
    House() { rooms.add(new Room()); }
}

---

# 🟦 static Keyword and Blocks

> 🔗 **Why together:** What `static` means, then static and instance blocks, then the order everything runs in.

## 58. Static variable vs instance variable?

> A **static variable** belongs to the **class**. Only **one copy** exists and it's **shared by all objects** , Created when | Class is loaded
> An **instance variable** belongs to the **object**. **Every object gets its own copy.**

---

## 59. Can we access a non-static member from a static method?
> **Not directly.** A static method belongs to the class and can run **without any object**.

## 60. Can we access a static member from a non-static method?
> Instance method has visibility of class level methods, variables

---

## 56. What is a static block? When does it run?

> A static block is a block of code with the `static` keyword. It runs **only once**, when the **class is loaded** into memory, even **before the `main` method**. 
It's used to **initialise static variables** like establish database connection

> ⭐ **Bonus:** A class can have many static blocks; they run from top to bottom.

---

## 57. What is an instance block? When does it run?

> An instance block is a block `{ }` inside a class **without** the `static` keyword. 
It runs **every time an object is created**, **before the constructor body**. 
It's used for common setup code that every constructor needs.

---

## 55. Order of loading a class in the JVM — instance block, constructor, static block?

Parent object is created using new keyword
```
1. Static block        ← only once
2. Instance block      ← object 1
3. Constructor
2. Instance block      ← object 2
3. Constructor
```

Child object is created using new keyword
```
1. Parent static block
2. Child static block       ← all static blocks first (only once)
3. Parent instance block
4. Parent constructor       ← parent object part is built first
5. Child instance block
6. Child constructor
```

---

## 60. What is a final variable?

> A final variable is a variable whose **value can't be changed** once it is assigned. 
It is used to create **constants**.
Value should be assigned during declaration

```java
final int MAX_USERS = 100;
// MAX_USERS = 200;          // ❌ compile error

public static final double PI = 3.14159;   // common way to write a constant
```

**`final` can be used in 3 places:**

| Used on | Meaning |
|---|---|
| Variable | Value can't be changed |
| Method | Child class can't override it |
| Class | No one can extend it |

---

## 61. What is a blank final variable?

> A blank final variable is a final variable that is **not given a value when declared**.
It **must be assigned exactly once**, in the **constructor** (or an instance block).


- If we forget to assign it in a constructor → **compile error**.
- A **static** blank final must be assigned in a **static block**.

---

## 62. What is effectively final?

> A variable is **effectively final** if it is **not declared `final`, but its value is never changed** after it is assigned. Java treats it as final.
This matters because **lambdas and anonymous classes can only use final or effectively final local variables**.

```java
String name = "Ram";    // not marked final, but never changed → effectively final
Runnable r = () -> System.out.println(name);   // ✅ allowed

int count = 0;
count++;                      // value changed → NOT effectively final
// Runnable r2 = () -> System.out.println(count);   // ❌ compile error
```

---

## 33. What is Polymorphism, how is it achieved in Java?

> Polymorphism means **"one name, many forms"**. The same method can behave differently. In Java we achieve it in two ways:
> 1. **Method Overloading** — same method name, **different parameters**, in the same class (compile time).
> 2. **Method Overriding** — child class gives its **own version** of a parent method (runtime).

```java
// 1. Overloading — same name, different inputs
class Calculator {
    int add(int a, int b)        { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}

// 2. Overriding — child changes parent's method
class Animal {
    void sound() { System.out.println("Some sound"); }
}
class Dog extends Animal {
    @Override
    void sound() { System.out.println("Bark"); }
}

Animal a = new Dog();
a.sound();      // "Bark" → decided at runtime
```


> 💬 **Your question:** In overloading, what about the return type — must it be the same, or can it be a lower (child) type?
>
> ✅ **Answer:** In **overloading, the return type doesn't matter at all**. It can be the same or completely different. What **must** change is the **parameter list** (number, type, or order of parameters). Changing **only** the return type is a **compile error**, because Java decides which method to call by looking at the arguments, not the return type.
>
> ```java
> class Calculator {
>     int add(int a, int b)          { return a + b; }
>     double add(double a, double b) { return a + b; }   // ✅ different params, different return type
>     long add(int a, int b, int c)  { return a + b + c; } // ✅ different number of params
>
>     // double add(int a, int b) { ... }   // ❌ compile error: only return type differs
> }
> ```
>
> **"Same or lower (child) return type"** is the rule for **overriding**, not overloading. There the return type must be the same or a child type (covariant return type, see Q38).
>
> | | Overloading | Overriding |
> |---|---|---|
> | Parameters | **Must be different** | Must be the same |
> | Return type | **Anything** (doesn't matter) | Same or child type |

---

## 34. Runtime vs Compile-time polymorphism in Java?

> **Compile-time polymorphism** is **method overloading** — the compiler decides which method to call based on the parameters.
> **Runtime polymorphism** is **method overriding** — the JVM decides at runtime based on the **actual object**.

| | Compile-time | Runtime |
|---|---|---|
| Also called | Static / early binding | Dynamic / late binding |
| Achieved by | **Overloading** | **Overriding** |
| Who decides | Compiler | JVM (while running) |
| Needs inheritance? | ❌ No | ✅ Yes |
| Method parameters | Must be different | Must be the same |

---

## 35. Can we override a static method?

> **No.** Static methods belong to the **class**, not to the object. If we write the same static method in the child class, it is called **method hiding**, not overriding.

```java
class Parent { static void show() { System.out.println("Parent"); } }
class Child extends Parent { static void show() { System.out.println("Child"); } }

Parent p = new Child();
p.show();       // prints "Parent" → it doesn't look at the object
```

---

## 36. Can we override a private method?

> **No.** Private methods are **not visible** to the child class, so the child can't override them. If the child writes a method with the same name, it's a **completely new method**.

🧠 **Easy to remember:** You can't change something you **can't even see**.

> ⭐ **Bonus:** A `final` method also can't be overridden.

---

## 37. What is method hiding?

> When a child class has a **static method with the same name and parameters** as a static method in the parent class, the child method **hides** the parent method. Which method runs depends on the **reference type**, not the object.

> 💬 **Your question:** Why is it called method *hiding*?
>
> ✅ **Answer:** Because the parent's method is **not replaced**, it's only **hidden behind** the child's method.
> - With **overriding**, the child's version **replaces** the parent's version for that object. Even with a `Parent` reference, the child's version runs.
> - With **hiding**, **both versions still exist** side by side. When we use the child's name, the parent's version is simply "out of sight". When we use the parent's name (or a `Parent` reference), the parent's version runs again.
>
> ```java
> class Parent { static void show() { System.out.println("Parent show"); } }
> class Child extends Parent { static void show() { System.out.println("Child show"); } }
>
> Child.show();               // "Child show"   ← parent's version is hidden here
> Parent.show();              // "Parent show"  ← still there, not replaced
>
> Parent p = new Child();
> p.show();                   // "Parent show"  ← decided by the reference type
> ```
>
> 🧠 It's like **standing in front of** someone: they're **hidden**, not gone. Step aside (use the `Parent` name) and you see them again. Overriding is **replacing** the person.

---

## 38. What is covariant return type?

> When overriding a method, the child method can return a **child type** instead of the parent type. This is called covariant return type. 

```java
class Animal {
    Animal get() { return new Animal(); }
}

class Dog extends Animal {
    @Override
    Dog get() { return new Dog(); }    // returns Dog instead of Animal ✅
}

Dog d = new Dog().get();   // no casting needed   --cast ing needed when rceiver's type is different or higher 
```

---

# 🟥 Interface and Abstract Class

> 🔗 **Why together:** Interface vs abstract class, then everything that can go inside an interface, then special kinds of interfaces.

## 46. Interface vs Abstract class usage? Why were they developed?

> - An **abstract class** is used when classes are **closely related** and share **common code**. It can have both normal methods and abstract methods (methods without a body), plus variables and constructors.
> - An **interface** is used to define **what a class must do** (a contract). A class can implement **many interfaces**, but can extend only one class.

| | Abstract Class | Interface |
|---|---|---|
| Keyword | `abstract class` + `extends` | `interface` + `implements` |
| Methods | Normal + abstract | Abstract (+ `default`, `static`, `private` with a body) |
| Variables | Any type | Only constants (`public static final`) |
| Constructor | ✅ Yes | ❌ No |
| How many can a class use? | Only **one** | **Many** |
| When to use | Related classes sharing common code | Defining a rule/ability for any class |

🧠 **Easy to remember:**
- **Abstract class** = an **incomplete house** — walls are built (common code), you finish the rest.
- **Interface** = a **job description** — it says *what* to do, not *how*.

**Why were they developed?**
- **Abstract class** → to **share common code** among related classes and force them to write some methods themselves.
- **Interface** → to achieve **full abstraction**, **loose coupling**, and **multiple inheritance** (a class can implement many interfaces).

```java
abstract class Animal {                 // common code
    void eat() { System.out.println("Eating"); }
    abstract void sound();               // child must write this
}

interface Pet {                          // ability / rule
    void play();
}

class Dog extends Animal implements Pet {
    void sound() { System.out.println("Bark"); }
    public void play() { System.out.println("Playing fetch"); }
}
```

> ⭐ **Bonus:** In Spring projects we write `UserService` as an interface and `UserServiceImpl` as the class. That's an interface used for loose coupling.

---

## 47. What is a default method in an interface?

> A default method is a method **with a body inside an interface**, using the `default` keyword (from Java 8). 
Classes that implement the interface **get it automatically**, and they can override it if they want.

```java
interface Vehicle {
    void start();                       // normal abstract method

    default void horn() {               // default method — has a body
        System.out.println("Beep beep");
    }
}

class Car implements Vehicle {
    public void start() { System.out.println("Car started"); }
    // no need to write horn()
}

new Car().horn();   // Beep beep
```

🧠 **Easy to remember:** **Default** = "if you don't write your own, use **this one by default**".

---

## 48. Why were default methods introduced?

> To add **new methods to old interfaces without breaking existing code**. 
In Java 8, methods like `forEach()` and `stream()` were added to collection interfaces. Without default methods, every class that implemented those interfaces would have to be changed.

**In short:** backward compatibility + support for lambdas and streams.

---

## 49. What is a static method in an interface?

> A static method in an interface (from Java 8) **belongs to the interface itself**. 
We call it using the **interface name**. 
Implementing classes **don't get** this method and can't override it. 
It's used for **helper/utility methods**.

```java
interface MathUtil {
    static int square(int x) {
        return x * x;
    }
}

MathUtil.square(5);    // ✅ 25 — call using the interface name
```

**Examples from Java:** `List.of()`, `Map.of()`, `Comparator.comparing()`.

**Default vs Static method:**

| Default method | Static method |
|---|---|
| Called using an object | Called using the interface name |
| Class gets it and can override it | Class doesn't get it becoz it belongs to interface(same idea as static in a class) , can't override |

---

## 50. What is a private method in an interface (Java 9)?

> From Java 9, an interface can have **private methods**. They are used to **share common code between default methods** inside the interface. Since they are private, classes that implement the interface **can't see or use** them.

```java
interface Logger {

    default void info(String msg)  { print("INFO", msg); }
    default void error(String msg) { print("ERROR", msg); }

    private void print(String level, String msg) {    // helper — hidden
        System.out.println("[" + level + "] " + msg);
    }
}
```

🧠 **Easy to remember:** `info()` and `error()` both need the same printing code, so we write it **once** in a private method and reuse it. **No duplicate code.**

**How interfaces grew (only if asked):**

| Java version | What interfaces can have |
|---|---|
| Before Java 8 | Only abstract methods + constants |
| Java 8 | + `default` methods, + `static` methods |
| Java 9 | + `private` methods |

---

## 51. Diamond problem — how does Java solve it with default methods?

> The diamond problem happens when a class gets the **same default method from two parents** and Java doesn't know which one to use. Java doesn't allow a class to extend two classes, so it can't happen with classes. But with **default methods**, two interfaces can have the same method. In that case Java **forces the class to override the method** and choose which one to call, using `InterfaceName.super.method()`.

```
        A
       / \
      B   C        B and C both have hello()
       \ /
        D          D gets hello() from both → which one? 🤔
```

```java
interface B { default void hello() { System.out.println("Hello from B"); } }
interface C { default void hello() { System.out.println("Hello from C"); } }

class D implements B, C {
    @Override
    public void hello() {          // ✅ must override, otherwise compile error
        B.super.hello();           // choose B's version (or C's, or write your own)
    }
}
```

**3 simple rules Java follows:**
1. **Class wins** — if a parent *class* has the method, it's used over the interface's default method.
2. **Child interface wins** — if one interface extends the other, the more specific (child) one is used.
3. **Still confused?** → the class **must override** the method itself.

🧠 **Easy to remember:** Two parents give different instructions. The child must **decide** and say clearly which one to follow.

---

## 52. What is a marker interface? Examples?

> A marker interface is an **empty interface** (no methods). It is used to **mark** a class so Java or a framework treats it specially.

| Marker interface | What it tells Java |
|---|---|
| `Serializable` | Objects of this class **can be saved/converted** to bytes |
| `Cloneable` | Objects of this class **can be copied** with `clone()` |
| `RandomAccess` | This list supports **fast access by index** (like `ArrayList`) |

```java
public class Employee implements Serializable {   // just marking it
    private String name;
}
```

🧠 **Easy to remember:** It's like a **"FRAGILE" sticker** on a box. The sticker does nothing itself, but people handle the box differently because of it.

> ⭐ **Bonus:** Today **annotations** (like `@Entity`, `@Component`) do same job as of marker interfaces.

---

## 53. What is a functional interface?

> A functional interface is an interface with **exactly one method which is abstract**. We can write its implementation using a **lambda expression**. 
We usually mark it with `@FunctionalInterface`.

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);     // only ONE abstract method
}

Calculator add = (a, b) -> a + b;    // lambda
Calculator multiply = (a, b) -> a * b;

System.out.println(add.calculate(2, 3));       // 5
System.out.println(multiply.calculate(2, 3));  // 6
```

**Examples from Java:**

| Interface | Its one method |
|---|---|
| `Runnable` | `run()` |
| `Comparator` | `compare()` |
| `Callable` | `call()` |
| `Predicate`, `Function`, `Consumer`, `Supplier` | `test()`, `apply()`, `accept()`, `get()` |

> ⭐ **Bonus:** `@FunctionalInterface` is optional, but if you add a second abstract method in a interfface marked @FunctionalInterface by mistake, the compiler shows an error.

---

## 54. Can a functional interface have default and static methods ?

> **Yes.** A functional interface can have **any number of default and static methods**. The only rule is that it must have **exactly one abstract method**.

```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);                    // the one abstract method

    default void sayBye() { System.out.println("Bye"); }       // ✅ allowed
    static void info() { System.out.println("Greeting interface"); }  // ✅ allowed
}
```

**Real example:** `Comparator` is a functional interface, but it has many default methods like `reversed()` and `thenComparing()`.

---

# 🟧 Object Class, equals and hashCode

> 🔗 **Why together:** `==` vs `equals()` and `instanceof`/`getClass()` moved here, because they are used when writing `equals()`.

## 64. Object class and its methods in Java?

> `Object` is the **parent of every class** in Java. 
Every class extends `Object` automatically, so every object gets its methods. 
The most important ones are **`equals()`, `hashCode()` and `toString()`**.

| Method | What it does |
|---|---|
| `equals(Object o)` | Checks if two objects are equal |
| `hashCode()` | Returns a number (hash) used by `HashMap` / `HashSet` |
| `toString()` | Returns the object as string value |
| `getClass()` | Returns the exact class of the object |
| `clone()` | Makes a copy of the object |
| `wait()`, `notify()`, `notifyAll()` | Used in multithreading |
| `finalize()` | Old cleanup method — deprecated, don't use |

🧠 **Easy to remember:** The 3 we override most often: **equals, hashCode, toString**.

> ⭐ **Bonus:** Lombok's @Data , @EqualsAndHashCode`, or Java **records**, generate these methods for us.

---

## 14. Difference between `==` and `equals()`?

> `==` checks whether **two references point to the same object** (same memory location).
> `equals()` checks whether **two objects have the same content/value**.

```java
String a = new String("java");
String b = new String("java");

System.out.println(a == b);       // false → two different objects
System.out.println(a.equals(b));  // true  → same content
```

---

## 65. equals() implementation — how and why?

> **Why:** By default, `equals()` behaves like `==` and only checks if both references point to the **same object**. We override it to compare objects by their **values** (for example, two employees with the same id are equal).
> **How:** check if it's the same object, check for null and class, then compare the important fields.

```java
public class Employee {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                                 // 1. same object?
        if (o == null || getClass() != o.getClass()) return false;  // 2. null or different class?
        Employee other = (Employee) o;                              // 3. cast
        return id == other.id && Objects.equals(name, other.name);  // 4. compare fields
    }
}
```

🧠 **Easy to remember the 4 steps:** **Same? → Null/Class? → Cast → Compare.**

---

## 15. `instanceof`, `getClass()` in Java — where do they belong?

> - `instanceof` is an operator which checks if an object **is of a type or its child type**.
> - `getClass()` is a **method of the `Object` class**. It gives the **exact class** of the object.......Student.class


```java
Animal a = new Dog();     // Dog extends Animal

a instanceof Animal        // true  → Dog is an Animal
a instanceof Dog           // true
a.getClass() == Dog.class  // true  → exact class is Dog
a.getClass() == Animal.class // false
```

---

## 66. hashCode() implementation — how and why?

> **Why:** `HashMap` and `HashSet` use `hashCode()` to decide **which bucket** to store an object in, so they can find it fast. If two objects are equal, they must give the same hash code.
> **How:** use **the same fields that are used in `equals()`**. The easiest way is `Objects.hash(...)`.

```java
@Override
public int hashCode() {
    return Objects.hash(id, name);     // same fields as equals()
}
```

---

## 67. What is the equals–hashCode contract?

> 1. If two objects are **equal** (`equals()` is true), they **must have the same hashCode**.
> 2. If two objects have the **same hashCode**, they are **not necessarily equal**.
> 3. If you override `equals()`, you **must also override `hashCode()`**.

---

## 68. What happens if we override equals but not hashCode?

> `HashMap` and `HashSet` **stop working correctly**. 
Two equal objects get **different hash codes**, so they go into **different buckets**. 
Result: a `HashSet` stores **duplicates**, and `HashMap.get()` returns **null** even though the key is there.

```java
// Employee overrides equals() but NOT hashCode() 
Set<Employee> set = new HashSet<>();
set.add(new Employee(1, "Ram"));
set.add(new Employee(1, "Ram"));    // equal object

System.out.println(set.size());     // 2 ❌ (should be 1)
```

---

## 69. What happens if we override hashCode but not equals?

> Equal objects go into the **same bucket**, but `equals()` still uses `==`, which compares memory addresses. 
So Java thinks they are **different objects**. 
Result : still **duplicates** in a `HashSet`, and `get()` with a new but equal key object returns **null**.

```java
// Employee overrides hashCode() but NOT equals()
Set<Employee> set = new HashSet<>();
set.add(new Employee(1, "Ram"));
set.add(new Employee(1, "Ram"));
System.out.println(set.size());     // 2 ❌
```

---

## 70. Can two unequal objects have the same hashCode?

> **Yes.** This is called a **hash collision**. 
`HashMap` handles it by keeping both in the same bucket and using `equals()` to tell them apart.

```java
System.out.println("Aa".hashCode());   // 2112
System.out.println("BB".hashCode());   // 2112  ← same hash, different strings
```

---

## 71. What if hashCode uses mutable fields?

> If we put an object in a `HashMap`/`HashSet` and **then change a field used in hashCode**, its hash code changes. 
The map now looks in the **wrong bucket**, so the object is **"lost"** — `get()` and `contains()` can't find it, even though it's still inside.

```java
Set<Employee> set = new HashSet<>();
Employee e = new Employee(1, "Ram");
set.add(e);

e.setId(2);                          // hashCode changes!
System.out.println(set.contains(e)); // false ❌ — lost in the set
```

**Solution:** use **immutable** objects as keys (like `String`, `Integer`), or don't change key fields after adding them.

> 💬 **Your request:** Explain with code.
>
> ✅ **Answer — full example, step by step:**
>
> ```java
> class Employee {
>     private int id;                         // ❗ mutable: has a setter
>     private String name;
>
>     Employee(int id, String name) { this.id = id; this.name = name; }
>     void setId(int id) { this.id = id; }
>
>     @Override
>     public boolean equals(Object o) {
>         if (this == o) return true;
>         if (o == null || getClass() != o.getClass()) return false;
>         return id == ((Employee) o).id;
>     }
>
>     @Override
>     public int hashCode() { return Objects.hash(id); }   // uses id
> }
>
> Set<Employee> set = new HashSet<>();
> Employee ram = new Employee(1, "Ram");
>
> set.add(ram);                           // Step 1: hashCode from id=1 → stored in bucket A
> System.out.println(set.contains(ram));  // true ✅ looks in bucket A
>
> ram.setId(2);                           // Step 2: id changes → hashCode changes
>
> System.out.println(set.contains(ram));  // false ❌ looks in bucket B (for id=2), but ram is in bucket A
> System.out.println(set.size());         // 1    ← ram is still inside, just can't be found
>
> set.add(ram);                           // Step 3: added again, now in bucket B
> System.out.println(set.size());         // 2 ❌ the SAME object is in the set twice!
> ```
>
> **What happened:**
>
> | Step | id | hashCode points to | Result |
> |---|---|---|---|
> | `add(ram)` | 1 | bucket A | stored in A |
> | `setId(2)` | 2 | bucket B | object is still sitting in A |
> | `contains(ram)` | 2 | bucket B | looks in B → **not found** |
> | `add(ram)` again | 2 | bucket B | stored again → **duplicate** |
>
> **✅ Fix 1 — make the key immutable** (no setter, `final` fields):
>
> ```java
> final class Employee {
>     private final int id;               // can never change
>     private final String name;
>     Employee(int id, String name) { this.id = id; this.name = name; }
>     // equals() and hashCode() using id, but NO setId()
> }
> // or simply: record Employee(int id, String name) { }
> ```
>
> **✅ Fix 2 — if you must change it:** remove it first, change it, then add it back.
>
> ```java
> set.remove(ram);    // remove while hashCode is still the old one
> ram.setId(2);
> set.add(ram);       // add again → goes to the correct bucket
> ```

---

# 🟪 String

> 🔗 **Why together:** String basics, why it's immutable and the String pool, then StringBuilder/StringBuffer, which solve String's limits.

## 72. String class, its use and its methods?

> `String` is a class used to store **text** (a sequence of characters). 
It is **immutable**, which means once created, its value can't change. 
Every method that seems to "change" a String actually returns a **new String**.

```java
String s1 = "Java";                 // literal (stored in the String pool)
String s2 = new String("Java");     // new object in heap
```

**Most used methods:**

| Method | Example | Result |
|---|---|---|
| `length()` | `"Java".length()` | `4` |
| `charAt(i)` | `"Java".charAt(0)` | `'J'` |
| `substring(a, b)` | `"Java".substring(1, 3)` | `"av"` |
| `indexOf()` | `"Java".indexOf("a")` | `1` |
| `contains()` | `"Java".contains("av")` | `true` |
| `equals()` / `equalsIgnoreCase()` | `"java".equalsIgnoreCase("JAVA")` | `true` |
| `toUpperCase()` / `toLowerCase()` | `"Java".toUpperCase()` | `"JAVA"` |
| `trim()` / `strip()` | `" Hi ".trim()` | `"Hi"` |
| `replace()` | `"Java".replace("a", "o")` | `"Jovo"` |
| `split()` | `"a,b,c".split(",")` | `["a","b","c"]` |
| `isEmpty()` / `isBlank()` | `"  ".isBlank()` | `true` |
| `startsWith()` / `endsWith()` | `"Java".startsWith("Ja")` | `true` |
| `String.join()` | `String.join("-", "a", "b")` | `"a-b"` |
| `String.valueOf()` | `String.valueOf(10)` | `"10"` |

```java
String s = "hello";
s.toUpperCase();            // creates "HELLO" but s is still "hello"
s = s.toUpperCase();        // now s points to "HELLO"
```

---

## 76. Why is String immutable?

> String is immutable for **4 main reasons**:
> 1. **String pool** — many variables share the same String object. If one could change it, all the others would change too.
> 2. **Security** — Strings are used for passwords, URLs, file paths and DB connections. They must not change after being checked.
> 3. **Thread safety** — immutable objects can be shared between threads safely.
> 4. **Fast HashMap keys** — the hash code is calculated once and cached.

```java
String a = "Java";
String b = "Java";      // a and b share the same object in the pool

a = a + " 17";          // a new object is created; b is still "Java" ✅
```

---

## 77. What is the String pool?

> The String pool is a **special memory area** where Java stores **String literals**. 
When we create a String literal, Java first checks the pool.
If the same value already exists, it **reuses** it instead of creating a new object. This **saves memory**.

```java
String a = "Java";              // created in the pool
String b = "Java";              // reused from the pool
String c = new String("Java");  // new object outside the pool

System.out.println(a == b);     // true  → same pool object
System.out.println(a == c);     // false → different objects
```

---

## 78. Where is the String pool stored?

> From **Java 7 onwards**, the String pool is stored in the **heap memory**. Before Java 7 it was in a small fixed area called **PermGen**, which often ran out of space.

🧠 **Easy to remember:** **Now = Heap.** (Moved to the heap in Java 7 so unused Strings can be garbage collected.)

---

## 79. `new String("abc")` creates how many objects?

> **Up to 2 objects.**
> 1. The literal `"abc"` is put in the **String pool** (only if it's not already there).
> 2. `new` always creates **one more object in the heap**.
> So it's **2 objects** if "abc" isn't in the pool yet, and **1 object** if it already is.

🧠 **Easy to remember:** `new` = **always a new object in heap**. The literal = **pool object in scp, only if missing**.

---

## 80. What does intern() do?

> `intern()` returns the **String from the pool**. If the value is already in the pool, it returns that object. If not, it **adds it to the pool** and returns it.

```java
String a = new String("Java");  // heap object
String b = a.intern();          // pool object
String c = "Java";              // pool object

System.out.println(a == c);     // false
System.out.println(b == c);     // true ✅
```

> 💬 **Your question:** Why is `a == c` false? Is it because one points to the pool and the other to the heap?
>
> ✅ **Answer:** **Yes, exactly right.** `==` compares **addresses**, not text.
> - `a` was created with `new`, so it points to a **separate object in the heap**.
> - `c` is a literal, so it points to the object **in the String pool**.
> - Same text, but **two different objects** at two different addresses → `==` is `false`.
> - `b = a.intern()` returns the **pool** object, the same one `c` points to → `b == c` is `true`.
>
> ```
>  HEAP (normal area)            STRING POOL
>  ┌─────────────┐               ┌─────────────┐
>  │  "Java"     │ ◄── a         │  "Java"     │ ◄── b, c
>  └─────────────┘               └─────────────┘
>    object #1                     object #2
>
>  a == c  → object #1 vs object #2 → false
>  b == c  → object #2 vs object #2 → true
>  a.equals(c) → compares text → true
> ```
>
> 🧠 Use `==` only to ask "same object?". To compare text, always use `equals()`.

---

## 81. Why is String good as a HashMap key?

> Because String is **immutable**. Its value can't change, so its **hashCode never changes** and the key is never "lost" in the map (see Q71). String also **caches its hashCode**, so lookups are fast, and it already overrides `equals()` and `hashCode()` correctly.

🧠 **Easy to remember:** A good key must **never change** — String never changes.

Map<String, Integer> map = new HashMap<>();
map.put("Ram", 100);
String key = new String("Ram");          // different object, same text
System.out.println(map.get(key));        // 100 ✅
System.out.println(map.get("Ram"));      // 100 ✅


Map<StringBuilder, Integer> map = new HashMap<>();
map.put(new StringBuilder("Ram"), 100);
StringBuilder key = new StringBuilder("Ram");   // same text, different object
System.out.println(map.get(key));               // null ❌

---

## 82. Why is char[] preferred over String for passwords?

> Because a String is **immutable** and may stay in the **String pool / memory for a long time**, until garbage collection. 
Anyone who can dump the memory could read it. 
A `char[]` can be **cleared immediately** after use by filling it with zeros. 
Also, a String can accidentally get **printed in logs**, while printing a `char[]` shows only an address.

```java
char[] password = {'s', 'e', 'c', 'r', 'e', 't'};
// ... use the password ...
Arrays.fill(password, '0');     // ✅ wiped from memory
```

---

## 83. How does `+` concatenation work internally?

> Since String is immutable, `+` **creates a new String object** every time. Java optimises this internally (it uses `StringBuilder`-like logic behind the scenes). If both sides are **constants**, the compiler joins them at compile time. But **inside a loop**, `+` creates many temporary objects, so we should use **`StringBuilder`** instead.

```java
String s = "Hello" + " World";   // joined at compile time → "Hello World"

// ❌ Slow — creates a new String in every loop
String result = "";
for (int i = 0; i < 1000; i++) {
    result = result + i;
}

// ✅ Fast — one object, keeps adding to it
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String result2 = sb.toString();
```

🧠 **Easy to remember:** `+` once or twice → fine. `+` **in a loop** → use `StringBuilder`.

---

## 73. StringBuilder, its use and its methods?

> `StringBuilder` is a **mutable** (changeable) version of String. We can add, insert, delete or reverse text **without creating new objects**, so it's **fast**. It is **not thread-safe**, which is fine for most code.

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");       // Hello World
sb.insert(0, "Hi ");       // Hi Hello World
sb.replace(0, 2, "Hey");   // Hey Hello World
sb.delete(0, 4);           // Hello World
sb.reverse();              // dlroW olleH
String result = sb.toString();
```

| Method | What it does |
|---|---|
| `append()` | Add at the end |
| `insert(i, x)` | Add at a position |
| `delete(a, b)` / `deleteCharAt(i)` | Remove characters |
| `replace(a, b, x)` | Replace part of the text |
| `reverse()` | Reverse the text |
| `length()` | Number of characters |
| `toString()` | Convert to a String |

🧠 **Easy to remember:** String = **printed paper** (can't edit). StringBuilder = **whiteboard** (edit anytime).

> ⭐ **Bonus:** A very common interview program — reverse a string: `new StringBuilder(s).reverse().toString()`.

---

## 74. StringBuffer, its use and its methods?

> `StringBuffer` is also a **mutable** String, with the **same methods** as `StringBuilder`. The only difference is that StringBuffer is **thread-safe** (its methods are `synchronized`), so it is **slower**. It's the older class; `StringBuilder` came later as the faster option.

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" 17");          // same methods: append, insert, delete, reverse...
```

🧠 **Easy to remember:** StringBuffer = StringBuilder **+ a lock** 🔒 → safe for many threads, but slower.

---

## 75. String vs StringBuilder vs StringBuffer — when to use which?

> - Use **String** when the text **doesn't change**.
> - Use **StringBuilder** when the text **changes a lot**, in a single thread. (**Most common choice.**)
> - Use **StringBuffer** when the text changes and **many threads** use the same object.

| | String | StringBuilder | StringBuffer |
|---|---|---|---|
| Can change? | ❌ Immutable | ✅ Mutable | ✅ Mutable |
| Thread-safe? | ✅ Yes (because immutable) | ❌ No | ✅ Yes (synchronized) |
| Speed | Slow for many changes | **Fastest** | Slower than StringBuilder |
| Use when | Fixed text | Many changes, one thread | Many changes, many threads |

🧠 **Easy to remember:** **Fixed → String. Changing → StringBuilder. Changing + many threads → StringBuffer.**

---

# 🟫 Immutability, Records and Enums

> 🔗 **Why together:** final reference vs immutable first, then building immutable classes, then records and enums (special classes that are immutable).

## 84. What is an immutable class?

> An immutable class is a class whose objects **can't be changed after they are created**. To "change" something, you must create a **new object**. Example: `String`.

**Benefits:**
- ✅ **Thread-safe** — no thread can change it, so no locking is needed.
- ✅ **Safe HashMap keys** — the hashCode never changes.
- ✅ **Easy to understand** — the value is always the same.
- ✅ Can be **cached and shared** safely.

---

## 63. final reference vs immutable object?

> - **final reference** means the variable **can't point to another object**, but the **object itself can still change**.
> - **Immutable object** means the **object's data can't change** at all.

```java
final List<String> list = new ArrayList<>();
list.add("Java");             // ✅ allowed — the object changed
// list = new ArrayList<>();  // ❌ not allowed — can't point to a new object

String s = "Java";            // immutable object
s.toUpperCase();              // s is still "Java" — the object never changes
```

| | final reference | Immutable object |
|---|---|---|
| Can the variable point to a new object? | ❌ No | ✅ Yes (if not final) |
| Can the object's data change? | ✅ Yes | ❌ No |

---

## 85. Steps to create an immutable class?

> 1. Make the class **`final`** (so no one can extend it and change behaviour).
> 2. Make all fields **`private final`**.
> 3. **No setter methods.**
> 4. Set all fields **in the constructor**.
> 5. For mutable fields (like `List` or `Date`), **make a copy** in the constructor and in the getter.

```java
public final class Employee {                      // 1. final class
    private final int id;                          // 2. private final fields
    private final String name;
    private final List<String> skills;

    public Employee(int id, String name, List<String> skills) {   // 4. constructor
        this.id = id;
        this.name = name;
        this.skills = List.copyOf(skills);         // 5. copy of mutable field
    }

    public int getId() { return id; }              // 3. only getters, no setters
    public String getName() { return name; }
    public List<String> getSkills() { return skills; }   // List.copyOf is already unmodifiable
}
```

---

## 86. How to handle mutable fields (Date, List) in an immutable class?

> Use **defensive copies**. **Copy the object when it comes in** (constructor) and **return a copy when it goes out** (getter). 
This way, no one outside can change the data inside our object.

```java
public final class Order {
    private final List<String> items;
    private final Date orderDate;

    public Order(List<String> items, Date orderDate) {
        this.items = new ArrayList<>(items);              // copy IN
        this.orderDate = new Date(orderDate.getTime());   // copy IN
    }

    public List<String> getItems() {
        return new ArrayList<>(items);                    // copy OUT
    }

    public Date getOrderDate() {
        return new Date(orderDate.getTime());             // copy OUT
    }
}
```

**Even easier:**
- Use `List.copyOf(items)` → gives an unmodifiable copy (no need to copy in the getter).
- Use **`LocalDate`** instead of `Date` → `LocalDate` is already immutable.

🧠 **Easy to remember:** **Copy in, copy out.** Give people a **photocopy**, never the original document.

---

## 87. Examples of immutable classes in the JDK?

> `String`, all **wrapper classes** (`Integer`, `Long`, `Double`, `Boolean`...), `BigDecimal`, `BigInteger`, the **Date-Time classes** (`LocalDate`, `LocalDateTime`, `Instant`), and lists created with `List.of()`.

| Category | Examples |
|---|---|
| Text | `String` |
| Wrappers | `Integer`, `Long`, `Double`, `Boolean`, `Character` |
| Numbers | `BigDecimal`, `BigInteger` |
| Date/Time | `LocalDate`, `LocalDateTime`, `Instant`, `Duration` |
| Collections | `List.of()`, `Set.of()`, `Map.of()` |
| Others | `UUID`, enums, records |

---

## 88. What are records (Java 16)?

> A record is a short way to create a **data class**. In one line, Java automatically creates the **constructor, getters, `equals()`, `hashCode()` and `toString()`**. All fields are **private final**. They're great for **DTOs** and API responses.

```java
public record Employee(int id, String name) { }

Employee e = new Employee(1, "Ram");
System.out.println(e.name());      // "Ram"  ← getter is name(), not getName()
System.out.println(e);             // Employee[id=1, name=Ram]
```

**This one line replaces around 40 lines of a normal class.**

**Adding validation (compact constructor):**
```java
public record Employee(int id, String name) {
    public Employee {
        if (id <= 0) throw new IllegalArgumentException("Invalid id");
    }
}
```

**Simple rules:**
- A record **can't extend** another class, but **can implement** interfaces.
- No setters; fields can't be changed.
- Can have static fields and extra methods.

🧠 **Easy to remember:** Record = a **data class in one line**.

---

## 89. Are records immutable?

> **Mostly yes, but only "shallowly".** Record fields are `final`, so they can't point to another object. 
But if a field is a **mutable object** like a `List`, the **contents of that list can still be changed**. To make it fully immutable, copy the list in the compact constructor.

```java
public record Team(String name, List<String> members) { }

List<String> list = new ArrayList<>(List.of("Ram"));
Team t = new Team("Dev", list);
list.add("Shyam");                  // ❌ the team's members changed too!

// ✅ Fix — make a copy
public record Team(String name, List<String> members) {
    public Team {
        members = List.copyOf(members);
    }
}
```

---

## 13. enum in Java?

> An `enum` is used to define a **fixed set of constant values**, for example days of the week or order status. 
It's safer than using plain strings because you can't pass a wrong value , we will have to select one of the value present with us.

```java
public enum OrderStatus {
    CREATED, SHIPPED, DELIVERED, CANCELLED
}

OrderStatus status = OrderStatus.SHIPPED;

if (status == OrderStatus.SHIPPED) {
    System.out.println("Your order is on the way");
}
```

---

# 🟥 Exception Handling

> 🔗 **Why together:** Basics, then try-catch-finally, then final/finally/finalize and try-with-resources (both about cleanup), then catch rules, then throw/throws.

## 90. What is an Exception?

> An exception is an **unexpected problem that happens while the program is running**, which stops the normal flow. For example, dividing by zero or reading a file that doesn't exist. We can **handle** exceptions using try-catch, so the program doesn't crash.

```java
try {
    int result = 10 / 0;              // ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Can't divide by zero");
}
System.out.println("Program continues");   // ✅ program doesn't crash
```

**Common exceptions:** `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`, `NumberFormatException`, `IOException`, `SQLException`.

🧠 **Easy to remember:** While driving, a **flat tyre** is an exception. You handle it (change the tyre) and continue the journey.

---

## 91. What is an Error?

> An Error is a **serious problem**, usually related to the **JVM or system**, that the program **should not try to handle**. For example, the JVM running out of memory.

| Error | When it happens |
|---|---|
| `OutOfMemoryError` | JVM has no more memory |
| `StackOverflowError` | Endless recursion (a method keeps calling itself) |

**Exception vs Error:**

| Exception | Error |
|---|---|
| Problem in **our code / input** | Problem in the **JVM / system** |
| **Can be handled** (try-catch) | **Should not be handled** |
| Example: `NullPointerException` | Example: `OutOfMemoryError` |

🧠 **Easy to remember:** Exception = **flat tyre** (you can fix it). Error = **engine blew up** (you can't fix it on the road).

---

## 92. Hierarchy of exceptions?

> At the top is **`Throwable`**. It has two children: **`Exception`** and **`Error`**. Under `Exception` there is **`RuntimeException`**, which is the parent of all **unchecked** exceptions. The other exceptions are **checked**.

```
                    Throwable
                   /         \
            Exception          Error
           /         \           ├── OutOfMemoryError
   IOException     RuntimeException   └── StackOverflowError
   SQLException       ├── NullPointerException
   (checked)          ├── ArithmeticException
                      ├── ArrayIndexOutOfBoundsException
                      ├── IllegalArgumentException
                      │      └── NumberFormatException
                      (unchecked)
```

🧠 **Easy to remember:** **Throwable → Exception / Error. RuntimeException = unchecked. The rest of Exception = checked.**

---

## 93. Checked vs Unchecked exception?

> - **Checked exceptions** are checked by the **compiler**. We **must** handle them with try-catch or declare them with `throws`, otherwise the code won't compile. Example: `IOException`, `SQLException`.
> - **Unchecked exceptions** happen at **runtime**, and the compiler doesn't force us to handle them. They usually come from **mistakes in our code**. Example: `NullPointerException`.

| | Checked | Unchecked |
|---|---|---|
| Checked by | Compiler (compile time) | Not checked (runtime) |
| Must handle? | ✅ Yes | ❌ No (optional) |
| Parent class | `Exception` | `RuntimeException` |
| Usually caused by | Outside things (file, DB, network) | Bugs in our code |
| Examples | `IOException`, `SQLException`, `FileNotFoundException` | `NullPointerException`, `ArithmeticException`, `IllegalArgumentException` |

```java
// Checked — compiler forces us to handle it
try {
    FileReader fr = new FileReader("data.txt");
} catch (FileNotFoundException e) {
    System.out.println("File not found");
}

// Unchecked — compiler doesn't complain
String s = null;
s.length();     // NullPointerException at runtime
```

🧠 **Easy to remember:** **Checked = the compiler checks it. Unchecked = our mistake, found at runtime.**

---

## 94. try-catch-finally block?

> - **try** — put the code that might throw an exception here.
> - **catch** — handle the exception if it happens.
> - **finally** — this **always runs**, whether an exception happens or not. It's used for **cleanup**, like closing files or DB connections.

```java
try {
    System.out.println("Opening file");
    int x = 10 / 0;                       // exception here
    System.out.println("Never printed");
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("Closing file");   // always runs
}
```

```
Opening file
Error: / by zero
Closing file
```

**Simple rules:**
- `try` must be followed by `catch`, `finally`, or both.
- `finally` runs **even if there's a `return`** in try.
- `finally` does **not** run only if `System.exit()` is called or the JVM crashes.

🧠 **Easy to remember:** try = **attempt**, catch = **handle the problem**, finally = **clean up no matter what** (like washing the dishes after cooking, whether the food came out good or bad).

---

## 16. final, finally, finalize — difference?

> - `final` is a **keyword** used to **stop changes**: a final variable can't be changed, a final method can't be overridden, a final class can't be extended.
> - `finally` is a **block** used with try-catch. It **always runs**, so it's used for cleanup like closing connections.
> - `finalize()` is an **old method** called by the Garbage Collector before deleting an object. It's **deprecated** now, so we don't use it.

---

## 100. What is try-with-resources?

> Try-with-resources (Java 7) **closes resources automatically**, like files, DB connections and streams. We declare the resource inside `try ( )`, and Java closes it at the end, even if an exception happens. We **don't need a finally block** to close it. The resource must implement `AutoCloseable`.

```java
// ❌ Old way — close manually in finally
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("data.txt"));
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (br != null) {
        try { br.close(); } catch (IOException e) { }
    }
}

// ✅ New way — closed automatically
try (BufferedReader br2 = new BufferedReader(new FileReader("data.txt"))) {
    System.out.println(br2.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

**Simple points:**
- You can open **many resources** in one try, separated by `;`. They are closed in **reverse order**.
- Less code, and no risk of forgetting to close the resource.

🧠 **Easy to remember:** It's like an **automatic door** — it closes by itself after you walk through.

---

## 95. Exception hierarchy in catch blocks?

> When we use multiple catch blocks, we must catch the **child (specific) exception first** and the **parent (general) exception last**. If the parent comes first, it catches everything and the child catch block can never be reached, so the compiler gives an **error**.

```java
// ✅ Correct — child first, parent last
try {
    int[] arr = new int[2];
    arr[5] = 10;
} catch (ArrayIndexOutOfBoundsException e) {    // specific
    System.out.println("Wrong index");
} catch (RuntimeException e) {                   // more general
    System.out.println("Runtime problem");
} catch (Exception e) {                          // most general
    System.out.println("Something went wrong");
}

// ❌ Wrong — compile error
try { ... }
catch (Exception e) { }
catch (ArithmeticException e) { }   // error: already caught by Exception
```

🧠 **Easy to remember:** Like a **sieve** — the small holes (specific) go first and the big net (general) goes last.

---

## 96. Catching multiple exceptions at once?

> From Java 7, we can catch **many exceptions in one catch block** using the **pipe `|` symbol**. It's useful when the handling code is the same for all of them.

```java
try {
    String s = null;
    s.length();
} catch (NullPointerException | ArithmeticException e) {
    System.out.println("Problem: " + e.getMessage());
}
```

**Rules:**
- The exceptions **must not be parent and child** of each other (e.g. `IOException | Exception` ❌ is a compile error).
- The variable `e` is **final**; we can't assign a new value to it.

🧠 **Easy to remember:** One catch, many exceptions → join them with `|`.

---

## 97, 98, 99. throw vs throws — where and how to use them?

> 🔀 Q97, Q98 and Q99 are answered together, because they're about the same two keywords.

> - **`throw`** is used **inside a method** to **actually throw** an exception object.
> - **`throws`** is used in the **method signature** to **declare** that the method *might* throw an exception, so the caller method must handle it.

| | `throw` | `throws` |
|---|---|---|
| Where | **Inside** the method body | In the method **signature** |
| Followed by | An exception **object** (`new ...`) | Exception **class names** |
| How many | One exception at a time | Many, comma-separated |
| Purpose | **Throw** an exception now | **Warn** the caller |
| Example | `throw new IllegalArgumentException("...");` | `void read() throws IOException, SQLException` |

### Q98. Where and how to use `throw`?

Use `throw` when **you find a problem yourself**, for example invalid input, and want to stop and report it.

**Common uses:** input validation, business rules (e.g. `throw new InsufficientBalanceException()`), throwing custom exceptions in a Spring service (e.g. `UserNotFoundException`).

### Q99. Where and how to use `throws`?

Use `throws` when your method **can't or shouldn't handle** a checked exception itself and wants the **caller** to decide what to do.

```java
public String readFile(String path) throws IOException {   // warn the caller
    return Files.readString(Path.of(path));
}

// The caller must handle it
try {
    String data = readFile("data.txt");
} catch (IOException e) {
    System.out.println("Could not read file");
}
```

**Simple points:**
- Mostly needed for **checked** exceptions. Unchecked exceptions don't need `throws`.
- Both can be used together: the method declares `throws`, and somewhere inside it uses `throw`.

🧠 **Easy to remember:**
- **`throw`** = actually **throwing the ball** 🏐 (an action, inside the method).
- **`throws`** = a **warning board**: "Balls may be thrown here" ⚠️ (in the signature).

---

> ✅ **End of Q1–Q100.** Next batch starts at Q101 (AutoCloseable).
