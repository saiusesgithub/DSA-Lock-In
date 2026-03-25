import java.util.Scanner;

public class Day1 {
    public static void main(String[] args){

        // Scanner Class (INPUT)
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String s = sc.next();           // stops at space
        String line = sc.nextLine();    // full line

        // Scanner Bug
        int y = sc.nextInt();
        String line1 = sc.nextLine(); // ❌ will skip

        // Scanner Bug Fix
        int z = sc.nextInt();
        sc.nextLine();        // consume leftover newline
        String line2 = sc.nextLine();

        // String Comparison
        s.equals(line);      // correct
        // s == line;        // WRONG (checks reference)

        // Arrays
        int[] arr = new int[5];
        int[] arr1 = {1,2,3,4,5};

        // Array Input
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }

        // Array Traversal
        for (int i = 0; i < arr.length; i++) {}
        for (int i : arr) {}  // You cannot modify array using this safely

        // Reverse Pattern

        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // 2D Arrays

        int[][] grid = new int[3][3]; // Usage - grid[i][j]

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // code
            }
        }

        // Common Patterns
        int sum = 0;
        for (int i : arr) sum += i;

        int max = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
        }

        // Functions - pass by value (always)
//        returnType methodName(parameters) {
//          // logic
//        return value;
//        }

        // Method Overloading (Same name, different params)
//        int add(int a, int b) {}
//        double add(double a, double b) {}

        // Strings
        String str = "hello";                      // immutable
        char[] array = {'h','e','l','l','o'};      // mutable

        str.concat("world");
        System.out.println(s);         // output - "hello"
        // Correct Way -
        str = str.concat("world");

        // String Methods -

        // s.length()
        //s.charAt(i)
        //s.substring(start, end)
        //s.equals(other)
        //s.toLowerCase()
        //s.toUpperCase()

        // IMPORTANT -
//        s1 == s2   ❌
//        s1.equals(s2) ✅

        // String Traversal

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
        }

        // String Builder (Important for performance, use when modifying string frequently)
        StringBuilder sb = new StringBuilder("hello");
        sb.append("world");
    }
}
