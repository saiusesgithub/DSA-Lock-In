import java.util.Scanner;

public class ThingsToKnowInJava {
    public static void main(String[] args) {
        
        // Input and Output in Java
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("You entered: " + num); // System.out.print to stay on the same line
        sc.close();

        // Arrays in Java
        int[] arr = new int[5];
        int[] arr2 = {1, 2, 3, 4, 5};
        // Access time = O(1)
        // Direct index → if position is known
        // Linear Search → check one by one
        // Binary Search → for sorted arrays

        // ✔ Insertion
        // End → O(1)
        // Middle/Start → requires shifting
        // ✔ Deletion
        // Remove element → shift remaining elements

        // Strings in Java
        String s = "striver";
        char ch = s.charAt(0);
        int length = s.length();
        
        String a = "Hello";
        String b = "World";
        String combined = a + " " + b; // Concatenation

        // For better performance, use StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        sb.append("World");

        a.equals(b); // == checks reference, equals() checks content
        // Strings are immutable in Java, Every modification creates a new object
        // Use StringBuilder for frequent changes

        String substring = s.substring(0, 3);
        boolean contains = s.contains("rive"); // true
        // String methods: length(), charAt(), substring(), contains(), equals(), indexOf(), toUpperCase(), toLowerCase(), trim(), etc.

        // Switch Case in Java
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // Loops in Java
        // For Loop
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // While Loop
        int j = 0;
        while (j < 5) {
            System.out.println(j);
            j++;
        }
        // Do-While Loop
        int k = 0;
        do {
            System.out.println(k);
            k++;
        } while (k < 5);

        // nested for loop
        for (int i = 0; i < 3; i++) {
            for (int m = 0; m < 2; m++) {
                System.out.println("i: " + i + ", m: " + m);
            }
        }

        // custom increment
        for (int i = 1; i <= 25; i += 5) {
            System.out.println(i);
        }

        // Functions in Java

        // Java is ALWAYS pass-by-value ,For objects, the reference is passed by value.

        // 👉 Java passes:
        // ❌ object itself → NO
        // ❌ reference itself → NO
        // ✔ copy of reference
        // BUT…
        // 👉 That copy still points to SAME object
        // ➡️ So changes are visible

        // pass by value = copy of the variable is passed to the function (original variable is not modified, function works with the copy)
        // pass by value → primitive types (int, char, etc.)

        //         public class Main {
        //              static void modify(int a) {
        //              a = a + 10;
        //          }
        //         public static void main(String[] args) {
        //              int x = 5;
        //              modify(x);
        //              System.out.println(x); // 5
        //          }
        //          }

        // pass by reference = reference to the original variable is passed to the function (function can modify the original variable)
        // pass by reference → objects (arrays, strings, etc.)
        // In Java, when we pass an object to a function, we are passing a reference to that object. This means that if we modify the object inside the function, it will affect the original object outside the function.
        // class Wrapper {
        //     int value = 5;
        // }

        // public class Main {
        //     static void modify(Wrapper obj) {
        //         obj.value += 10;
        //     }

        //     public static void main(String[] args) {
        //         Wrapper w = new Wrapper();
        //         modify(w);
        //         System.out.println(w.value); // Output: 15
        //     }
        // }   
}

static int factorial(int n) {  // without recursion
            int result = 1;
            while (n > 0) {
                result = result * n;
                n--;
            }
            return result;
        }