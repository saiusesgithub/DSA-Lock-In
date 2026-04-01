public class Day4 {
    // Recursion - solving big problem by using smaller versions of same problems
    // Structure - 1) Base case - where the recursion stops
    //             2) Recursive case - where the method calls itself

    int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Dry Run
//        fact(5)
//                = 5 * fact(4)
//                = 5 * 4 * fact(3)
//                = 5 * 4 * 3 * fact(2)
//                = 5 * 4 * 3 * 2 * fact(1)
//                = 5 * 4 * 3 * 2 * 1

    // Fibonacci
//    fib(0) = 0
//    fib(1) = 1
//    fib(n) = fib(n-1) + fib(n-2)
// ex - 0 , 1 , 1 , 2 , 3 , 5, 8 ... (n = sum of previous 2 numbers)
    //  f(4) = sum of elements until index 4 (starts from 0 index)
    // so f(4) = 3

    //Recursion Tree -
//              fib(5)
//         /              \
//      fib(4)           fib(3)
//       /   \           /   \
//    fib(3) fib(2) fib(2) fib(1)

// PROBLEM - Fibonacci is VERY slow
// fib(3),fib(2) is calculated multiple times
// leads to Dynamic Programming (later)



    // Linked List
    // Arrays Problem - Fixed Size + Insertion in middle = shifting elements in the array

    // Linked List - Stores elements anywhere in the memory + connect them using pointers
    // Each element = node -> (data , next)


    // Reverse Linked List
    // before - 10 → 31 → 21 → null ,, after - 21 → 31 → 10 → null

    // we need THREE pointers -> (prev,current,next)

//    Step 1:
//    prev = null
//    current = head
//
//    Step 2:
//    save next
//    reverse link
//    move forward

    // DRY RUN -
//    Iteration 1:
//    current = 10
//    next = 31
//    10.next = null

//    prev = 10
//    current = 31
//
//    Iteration 2:
//    current = 31
//    next = 21
//    31.next = 10

//    prev = 31
//    current = 21
//
//    Iteration 3:
//    current = 21
//    next = null
//    21.next = 31

//    prev = 21
//    current = null

    // FINAL -> prev = new head


    // Middle of Linked List (in one traversal)

//    slow → moves 1 step
//    fast → moves 2 steps
    // When fast reaches end , slow will be at middle

}
