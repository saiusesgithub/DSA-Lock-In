// 12-04-2026 (did 10 patterns)

public class BuildUpLogicalThinking {
    // Pattern 1
    // *****
    // *****
    // *****
    // *****
    // *****
    static void Pattern1(int n) {         // my initial implementation = optimal
        for (int i =0;i<n;i++) {
            for (int j =0;j<n;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // Time Complexity = O(n^2)
    // Space Complexity = O(1)

    // -----------------------------------------------------------------------------------------------------

    // Pattern 2
    // *
    // **
    // ***
    // ****
    // *****
    static void Pattern2(int n) {       // my initial implementation = optimal
        for (int i =1;i<=n;i++) {
            for (int j =1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // Time Complexity = O(n^2)
    // Space Complexity = O(1)

    // -----------------------------------------------------------------------------------------------------

    // Pattern 3
    // 1
    // 12
    // 123
    // 1234
    // 12345
    static void Pattern3(int n) {       // my initial implementation = optimal
        for (int i =1;i<=n;i++) {
            for (int j =1;j<=i;j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    // Time Complexity = O(n^2)
    // Space Complexity = O(1)


    // -----------------------------------------------------------------------------------------------------

    // Pattern 4
    // 1
    // 22
    // 333
    // 4444
    // 55555
    static void Pattern4(int n) {       // my initial implementation = optimal
        for (int i =1;i<=n;i++) {
            for (int j =1;j<=i;j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    // Time Complexity = O(n^2)
    // Space Complexity = O(1)

    // -----------------------------------------------------------------------------------------------------

    // Pattern 5
    // *****
    // ****
    // ***
    // **
    // *
    static void Pattern5(int n) {       // thier approach - i = 0 to N-1 , j=N;j>i;j--
        for (int i =n;i>=0;i--) {
            for (int j =1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // Time Complexity = O(n^2)
    // Space Complexity = O(1)


    // -----------------------------------------------------------------------------------------------------

    // Pattern 6 
    // 12345
    // 1234
    // 123
    // 12
    // 1
    static void Pattern6(int n) {       // thier approach - i = 0 to N-1 , j = N to i+1 ; Print  1 to N - i using (N - j + 1)
        for (int i =n;i>=0;i--) {
            for (int j =1;j<=i;j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    // Time Complexity = O(n^2)
    // Space Complexity = O(1)

    // -----------------------------------------------------------------------------------------------------

    // Pattern 7
    //     *
    //    ***
    //   *****

    // assume -> 
    //   --*--    - => 2 to 0 (1 to n-i dashes)
    //   -***-    * => 1,3,5... (2i-1 stars)
    //   *****
    static void Pattern7(int n) {             // completely on my own , no hints :D
        for (int i =1;i<=n;i++) {
            for (int j = 1 ; j <= n-i;j++) {
                System.out.print(" ");
            }
            for (int z = 1 ; z <= 2*i - 1 ; z++) {
                System.out.print("*");
            }
            for (int k = 1 ; k <= n-i;k++) {  // I DONT EVEN NEED TO PRINT THESE SPACES (Invisible anyway)
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // thier appraoch - 
    // Print N - i - 1 spaces before the stars.
    // Print 2 * i + 1 stars.
    // Print N - i - 1 spaces again (optional, only for symmetry in visualization).

    // i dont even need to print spaces after the loop mannn

    // Initially -> 
    // Time Complexity = O(n^3) // BRO NO, its still O(n^2) - i was counting no of loops = time complex.
    // O(n) for rows,  for each row -> (n-1) * (2i-1) * (n-1) = 2n-1 = O(n) each row so still O(n^2)
    // Space Complexity = O(1)

    // After Optimization
    // Time Complexity = O(n^2)
    // Space Complexity = O(1)

    // -----------------------------------------------------------------------------------------------------
    
    // Pattern 8 - 
    
    //   *****  
    //    ***
    //     *

    static void Pattern8(int n) {     
        for (int i =n;i>=0;i--) {                  // just reversed i traversal
            for (int j = 1 ; j <= n-i;j++) {
                System.out.print(" ");
            }
            for (int z = 1 ; z <= 2*i - 1 ; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Time Complexity = O(n^2)
    // Space Complexity = O(1)

    // -----------------------------------------------------------------------------------------------------
   
   // Pattern 9 - 

    //     *
    //    ***
    //   *****
    //  *******
    // *********
    // *********
    //  *******
    //   *****
    //    ***
    //     *

    static void Pattern9(int n) {             // just joined pattern 8 and 9 (optimal solution)
        for (int i =1;i<=n;i++) {
            for (int j = 1 ; j <= n-i;j++) {
                System.out.print(" ");
            }
            for (int k = 1 ; k <= 2*i - 1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for ( int l =n;l>=0;l--) {              
            for ( int m = 1 ; m <= n-l;m++) {
                System.out.print(" ");
            }
            for ( int o = 1 ; o <= 2*l - 1 ; o++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Time Complexity = O(n^2)
    // Space Complexity = O(1)
    // O(n) for rows , each row -> (i-1) * (2n-1) * (i-1) => O(n) so O(n^2)

    // -----------------------------------------------------------------------------------------------------
   
   // Pattern 10

    // *
    // **
    // ***
    // ****
    // *****
    // ****
    // ***
    // **
    // *

    static void Pattern10(int n) {           // just mofidied above one to print * in place of " "
        for (int i =1;i<=n;i++) {
            for (int j = 1 ; j <= i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for ( int l =n-1;l>=0;l--) {              
            for (int m = 1 ; m <= l;m++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Time Complexity = O(n^2)
    // Space Complexity = O(1)
    // O(2n-1) for rows , each row -> O(n)  => so O(n^2)

    // -----------------------------------------------------------------------------------------------------




    public static void main(String[] args) {
        Pattern19(5);
    }
    
}