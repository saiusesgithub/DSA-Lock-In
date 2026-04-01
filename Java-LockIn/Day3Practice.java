public class Day3Practice {
    public static void main(String[] args) {
//        Student1 s = new Student1();
//        s.name = "Sai";
//        s.age = 19;
        Student1 s1 = new Student1("Sai",19);
        Student1 s2 = new Student1();
        s1.display();
        System.out.println("Is Adult: " + s1.isAdult());

        Dog1 d = new Dog1("Snoopy");
        d.eat();
        d.bark();

        Animal1 d1 = new Dog1("Rocky"); // Animal1 - reference type , Dog1 - actual object
        d1.eat(); // runs based on object which is Dog1

        // BUT , if we do - d1.bark(); , then error because Animal1 doesnt know bark method
        // so basically, we can only call methods which are common to both reference type and object
        // and the object version of that method will be run

//        You can only call methods defined in the REFERENCE TYPE,
//        but the implementation that runs is from the OBJECT (if overridden).
         // During compile time - java checks - Does Animal1 have this method?
//        d1.eat();   // ✔ Animal1 has eat() → allowed
//        d1.bark();  // ❌ Animal1 doesn’t → compile error
        // During runtime , java checks - Which version should I run?
        // d1.eat(); → Dog1’s eat() runs (since object = Dog1())

        // Reference → decides WHAT you can call
        // Object → decides WHICH version runs
    }
}

class Student1 {
    private int age;
    private String name;

    // Default Constructor
    Student1 () {
        this.name = "Unknown";
        age = 0;
    }
    Student1 (String name , int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " : " + age);
    }
    boolean isAdult() {
        if (age >= 18) {
            return true;
        }
        else{
            return false;
        }
        // simplified - return age >= 18;
    }

    int getAge() {
        return this.age;
    }
    void setAge(int age) {
        if (age>=0) {
            this.age = age;
        }
    }

    String getName() {
        return this.name;
    }
    void setName(String name) {
        this.name = name;
    }


}

class Animal1 {
    void eat() {
        System.out.println(name + " animal is Eating");
    }
    String name;
    Animal1(String name) {
        this.name = name;
    }
}

class Dog1 extends Animal1 {
    void bark() {
        System.out.println("Barking");
    }
    Dog1(String name) {
        super(name);
    }

    @Override // not required, automatically overridden if d.eat() is called
    void eat() {
        System.out.println(name + " dog is Eating");
    }
}

// Overloading
class MathUtils {
    int multiply(int a , int b) {
        return a*b;
    }
    int multiply(int a , int b,int c) {
        return a*b*c;
    }
    double multiply(double a , double b) {
        return a*b;
    }
}

// Abstraction

abstract class Vehicle {
    abstract void start();
    void stop() {
        System.out.println("Stopped");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Started");
    }
}

// Interfaces
interface Shape {
    void area();
}

class Circle implements Shape {
    public void area() {}
}

class Rectangle implements Shape {
    public void area() {}
}

// Static

class BankAccount {
    static int totalAccounts;
    String name;

    BankAccount(String name) {
        this.name = name;
        totalAccounts++;
    }
}