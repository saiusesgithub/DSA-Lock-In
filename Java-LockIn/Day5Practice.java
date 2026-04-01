import java.util.HashMap;

public class Day5Practice {

    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // BUG - You are checking before moving pointers (Initially EQUAL!)
                return true;
            }
        }
        return false;
    }

    static Node findCycleStart(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                break;
            }
        }

        // ChatGPT Improvement - ❌ No cycle   // ALWAYS Consider edge cases
        if (fast == null || fast.next == null) {
            return null;
        }

        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }

    static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {  // if I don't use else and just keep increment outside if statement -> I will miss if there are multiple consecutive duplicates
                temp = temp.next; // ALWAYS MISSING THIS (Try running programs so that I don't miss this)
            }
        }
        return head;
    }

}

class Stack {
    int[] arr;
    int top = -1;

//    Stack(int[] arr) {    // WRONG - user should not pass array, stack should create its own
//        this.arr = arr;
//    }

    Stack(int size) {
        arr = new int[size];
    }

    void push(int x) {
        if (top != arr.length - 1) {
            top++;
            arr[top] = x;
        }
    }

    int pop() {
        if (top != -1) {
            int value = arr[top];
            top--;
            return value;
        }
//        return top;   // should return removed value
        return -1; // or throw exception
    }

    int peek() {
        if (top!= -1) {
            return arr[top];
        }
        return 0;
    }

    boolean isEmpty() {
        return top==-1;
    }



}

class Queue{
    int[] arr;
    int front;
    int rear;
    int size;

    Queue(int size) {
        arr = new int[size];
        front =0;
        rear = -1;
        this.size = size;
    }

    void enqueue(int x) {
//        if (front != size - 1) {
//            front++;
//            arr[front] = x;
//        }  // WE SHOULD INSERT USING REAR
        if (rear != size-1) {
            rear++;
            arr[rear] = x;
        }

    }

    int dequeue() {
        if (front > rear) {
            System.out.println("Queue Overflow");
            return -1;
        }
        front++;
        return arr[front++];
    }

    int peek() {
        if (front > rear) return -1;
        return arr[front];
    }

    boolean isEmpty() {
        return front > rear;
    }
}

class Sort {
    static void bubbleSort(int[] arr) {
// Hint from ChatGPT -
//        Outer loop → passes
//        Inner loop → compare adjacent
//        swap if arr[j] > arr[j+1]

        for (int i =0;i<arr.length-1;i++) {
            // Last pass unnecessary , initially used i<arr.length
            for (int j =0;j<arr.length-i-1;j++) {
                // initially used arr.length
                // use arr.length - 1 (or else INDEX ERROR)
                // Every pass compares entire array → waste , After each pass → largest element settles at end (so no need to check end again)
                // so use (j < arr.length - i - 1)
                // Every pass → pushes max to end , So reduce range each time
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] arr) {

        for (int i = 0 ; i < arr.length ; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j=i;j<arr.length;j++) { // improvement - use j = i+1 (already assume arr[i] is min , no need of comparision with itself)
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }

            // improvement - always swapping even if minIndex == i
//            if (minIndex != i) {
//                below code here
//            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    static void InsertionSort(int[] arr) {
        for (int i = 1;i<arr.length;i++) {
            int key = arr[i];
            int j = i-1;
            while (arr[j] > key&&j>0) {  // Improvement - j may become -1 -> crash so use - &&j>0
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}

class Search {

    static int binarySearch(int[] arr,int target,int low,int high) {
        if (low > high) return -1; // im NOT considering edge cases BRUH
        int mid = (low+high) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        else if (target < arr[mid]) {
            return binarySearch(arr,target,low,mid-1); // bug - just calling , not returning
            // bug - in the above recursion statement -> mid-1 should be used (mid already checked so no need again)
        }
        else if (target > arr[mid]) {
            return binarySearch(arr,target,mid+1,high);
        }
        return -1;
    }

}

class Hashing {
    static void frequency(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0 ; i<arr.length;i++) {
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]) +1;
                map.put(arr[i], value);
            }
            else {
                map.put(arr[i],1);
            }
        }
        System.out.println(map);
    }

    // Alternate methods/Improvements (ChatGPT) ->

    // map.computeIfPresent(arr[i],(key,value) -> value+1); // update existing value if present

    // map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    // getOrDefault(key, 0) - returns value if exists → else returns 0

    //  for (int key : map.keySet()) {
    //      System.out.println(key + " -> " + map.get(key));
    //  }
}

