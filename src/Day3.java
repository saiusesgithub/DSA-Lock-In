public class Day3 {
    public static void main(String[] args) {
//        Student s = new Student();
//        s.name = "Student Name";
//        s.age = 19;

        // After Constructor
        Student s = new Student("Sai" , 19);
//        s.age = 20; // if just int age; , then this is allowed , anyone can change data / invalid values possible (see encapsulation below)
        // after encapsulation , to read and modify values -
        s.setAge(49);
        System.out.println(s.getAge());

        Dog d = new Dog("Snoopy");
        d.sound();  // inherited (after @override , dog's sound method will be called)
        d.bark();

//        Animal2 a2 = new Animal2(); - object of an abstract class cannot be created
        Animal2 d2 = new Dog2();
        d2.sound();

        // related to static variable , look below
        new Counter();
        new Counter();
        System.out.println(Counter.count);

        // Exceptions
        try {
            int[] arr = new int[5];
            arr[10] = 10;
            int a = 10/0;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds Exception");
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        } catch(Exception e) {
            System.out.println("General Exception : " + e);
        } finally {
            System.out.println("Always Runs");
        }

        int age = 19;
        if (age < 18) {
            throw new RuntimeException("Minor - Cannot Drive");
        }

//        void divide() throws Exception { - I might cause an error, whoever calls me should handle it
//            int a = 10 / 0;
//        }
//        try {
//            divide();
//        } catch (Exception e) {
//            System.out.println("Handled");
//        }

    }
}

//    Class = blueprint
//    Object = instance
//    Fields = variables
//    Methods = behavior

class Student {
    String name;
    private int age;

    void display() {
        System.out.println(name + " " + age);
    }

    // Constructor
    Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    // Default Constructor
    Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Encapsulation
//    s.age = -10;  right now this is allowed , anyone can change data / invalid values possible

    // Solution - instead of int age;
    // we use private int age;  --> this variable can only be accessed from inside the class
    // so s.age = -19 in the main class becomes invalid
    // to access it , we use controlled access methods

//    Encapsulation used for -> input validation , read only objects (don't use setter) , flexibility
//    suppose we change private int age; to private Date birthDate; the original getter will still return age
//    so we dont need to change any main class code

    // Getter (Reader)
    int getAge() {
        return age;
    }

    // Setter (Modify)
    void setAge(int age) {
//        this.age = age;
        // REAL POWER - now we can control values
        if (age >= 0) {
            this.age = age;    // s.setAge(-100) will be invalid
        }
    }


}

class Animal {
    void sound() {
        System.out.println("Animal Making Sound");
    }
    String name;
    Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is Barking");
    }
    Dog(String name) {
        super(name);  // calls parent constructor -> If parent has constructor → child MUST call it
    }

//    Overriding rules -
//    Same method name
//    Same parameters
//    Child version runs

    @Override   // Method Overriding
    void sound() {
        System.out.println("Dog Making Sound");
    }
}

// Polymorphism -> Poly = many , morphism = forms
// Method Overloading (Compile time) - Same method name, different parameters
// Method Overriding (Run time)

// Method Overloading - java decides based on parameters - Compiler decides → compile time
class Calculator {
    int add(int a, int b) {
        return a+b;
    }
    int add(int a, int b,int c) {
        return a+b+c;
    }
    double add(double a, double b) {
        return a+b;
    }

//    int add(int a, int b)
//    double add(int a, int b)  // ❌ only return type changed → NOT allowed

// Method Overriding -
// Parent vs Child → same method → different behavior
// Animal → eat()
// Dog → eat() (different logic)

    // DIFFERENCE
//    Feature	     Overloading	        Overriding
//    Class	         Same class	            Parent + Child
//    Method name	 Same	                Same
//    Parameters	 Different	            Same
//    Decision	     Compile time	        Runtime
//    Polymorphism 	 Compile-time	        Runtime
}


// Abstraction
// Hide implementation → show only what’s needed ,,, You don’t tell HOW, only WHAT

// WHY ABSTRACTION? - Force structure (what methods must exist)
// Every Animal MUST have sound()

abstract class Animal2 {   // abstract class - cannot create an object
    abstract void sound(); // abstract method - no body
    void eat() {
        System.out.println("Animal Eating");
    }
}

class Dog2 extends Animal2 {
    void sound() {
        System.out.println("Bark");
    }
}


// Interfaces (100% abstraction)
// uses implements , methods must be public, no constructors
interface Animal3 {
    void sound();      // abstract by default
}

class Dog3 implements Animal3 {
    public void sound() {
        System.out.println("Bark");
    }
}

// Multiple Inheritance (Java supports multiple interhitance only using interfaces , not natively)
interface A {
    void aMethod();
}

interface B {
    void bMethod();
}

class AB implements A,B {
    public void aMethod() {}
    public void bMethod() {}
}

// Difference between AbstractClass and Interface
// Feature	        Abstract Class	         Interface
// Methods	        abstract + normal	     mostly abstract
// Inheritance	    single	                 multiple
// Keyword	        extends	                 implements


// Static Keyword (belongs to class, not object)

// generally (object based) -

// class Student {
//    String name;
// }
// Student s1 = new Student();
// Student s2 = new Student();
// each object has its own name

class Student3 {
    static String college = "VJIT";
}

// System.out.println(Student.college);  (Same for all objects)

// Static Variable (One Variable/Copy Shared) -
class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}

// new Counter();
// new Counter();
// System.out.println(Counter.count);   // Result - 2

// Static Method (belongs to class , not method)
// you need an object, to use methods in normal method -

class A1 {
    void test(){System.out.println("Hello");}
}
// A1 a = new A1();
// a.test();

// Static Method -
class A11 {
    static void test(){System.out.println("Hello");}
}

// A11.test();   - static method is attached to class itself

// IMPORTANT - Static method CANNOT use non-static variables directly
class A12 {
    int x;
//    static void test() {x++;}  -  error  (because No object → no instance variables)
}

// Fix
class A13 {
    int x;
    static void test() {
        A13 obj = new A13();
        obj.x++;
    }
}

// Real use case - Math.sqrt(25) -> (no object because it's static)