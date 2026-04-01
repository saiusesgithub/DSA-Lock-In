public class Day5 {
    // Cycle Detection (Floyd's Algorithm)
    // 10 → 31 → 21 → 45
    //           ↑     ↓
    //           ← ← ← ←

    // NAIVE WAY
    // Use HashSet → store visited nodes
    // Works BUT not optimal

    // Floyd’s Cycle Detection (Tortoise & Hare)
    // slow -> 1 step
    // fast -> 2 steps

    // If cycle exists → slow == fast at some point
    // If no cycle → fast reaches null

    // Start of a Cycle -
    // Naive way - store all the visited elements in a list , if current element already present in
    // the list (repeated) , then that's the start of the cycle but this method requires extra space
    // O(n)

    // Preferred Way (My Understanding) -
    // at the point where slow and fast meets , we have to pause slow at that point
    // then take a new pointer at head (or resue fast)
    // both(paused slow and new fast at head) should move one node at a time
    // point where slow pointer and new(fast) pointer meet is start of the cycle

//  1. Detect cycle using slow & fast
//  2. When they meet → keep slow there
//  3. Take a new pointer from head
//  4. Move both one step at a time
//  5. Where they meet → start of cycle

    // Why this works - Meeting point is "aligned" such that both are same distance from cycle start


    // STACK (LIFO - last in , first out)
    // we need -> int top;
    // Operations - Push() , Pop() , Peek() , isEmpty() ---- cannot remove elements from middle

    // QUEUE (FIFO - First in , First out)
    // we need - front pointer , rear pointer
    // Operations - enqueue() , dequeue() , peek() , isempty()

    // front → where we REMOVE (dequeue)
    // rear  → where we INSERT (enqueue)

//    enqueue(10), enqueue(20), enqueue(30)
//    [10, 20, 30, _]
//    ↑         ↑
//    front     rear

    // Queue does NOT delete elements from array , It just moves front pointer
    // Unused space at beginning → wasted memory ,,,, to solve this - Circular Queue exists



    // SORTING ALGORITHMS -

    // Bubble Sort ->
    // Push largest element to end in each pass ( j > j+1 -> swap)
    // [5, 3, 2, 4]
    //  Pass 1 → [3, 2, 4, 5]
    //  Pass 2 → [2, 3, 4, 5]

    // Selection Sort ->
    // Find minimum , put it in the correct position
    // [5, 3, 2, 4]
    //Pass 1 → pick min(2) → swap with 5 → [2, 3, 5, 4]
    //Pass 2 → pick min(3) → no change

    // Insertion Sort -> insert element into correct position in sorted part

    // HOW ARRAY IS DIVIDED
    //[ sorted part | unsorted part ]
    //Initially: [5 | 3, 2, 4]
    //First element is always “sorted”

    // Compare 3 with 5 → shift 5 right
    //[5, 5, 2, 4]
//    Now insert 3:
//    [3, 5, 2, 4]

    // IMPORTANT - We DO NOT swap , We SHIFT elements
    // 1. Store current element (key)
    //2. Compare with left side
    //3. Shift bigger elements right
    //4. Insert key in correct position



    // Bubble → push max to end
    //Selection → pick min
    //Insertion → build sorted part

    //+-------------------------+-----------+--------------+------------+------------------+
    //| Sorting Algorithm       | Best Case | Average Case | Worst Case | Space Complexity |
    //+-------------------------+-----------+--------------+------------+------------------+
    //| Bubble Sort (Optimized) | O(n)      | O(n^2)       | O(n^2)     | O(1)             |
    //+-------------------------+-----------+--------------+------------+------------------+
    //| Selection Sort          | O(n^2)    | O(n^2)       | O(n^2)     | O(1)             |
    //+-------------------------+-----------+--------------+------------+------------------+
    //| Insertion Sort          | O(n)      | O(n^2)       | O(n^2)     | O(1)             |
    //+-------------------------+-----------+--------------+------------+------------------+


    // SEARCHING ALGORITHMS

    // Binary Search -
    // Search in sorted array → cut search space in half


    // HASHING
    // Store and retrieve data in O(1)
    // Use case - frequence counting





}
