04/04/2026

387. First Unique Character in a String - Easy

started with this cuz i already did it while practicing with ChatGPT

my initial solution - 

import java.util.*;
import java.lang.*;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i =0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i),value+1);
            }
            else {
                map.put(s.charAt(i),1);
            }
        }

        for (int j = 0;j<s.length();j++) {
            if (map.get(s.charAt(j)) == 1) {
                return j;
            }
        }
        return -1;
    }
}

passed all test cases but sucks
Runtime
43ms
Beats5.75%
Memory
47.30MB
Beats18.62%

idk came up with this something 

class Solution {
    public int firstUniqChar(String s) {
        int pointer = 0;
        for (int i = 1 ; i < s.length(); i++) {
            char c = s.charAt(pointer);
            if (s.charAt(i) == c) {
                while (s.charAt(pointer) != c) {
                    pointer++;
                }
            }
        }
        return pointer;
    }
}

but test cases not passing

so I thought , I will keep the pointer at one char , if char found again in the loop , then move the pointer ,, and then return pointer cuz that char at that pointer hasn't been found 

but having problem with , what if consecutive duplicates or like no unique characters at all
how to return -1

WASTED SO MUCH TIME ON THIS MAN


discussions tab - 

Brute force :
Time complexity : O(n^2)
Space complexity : O(1)
you can run two loop , one inside another and check weather it is present in whole string or not .

Optimise :
Time complexity : O(n)
Space complexity : O(1)
you can use unordered_map and then search where the value is 1 and return it's index else return -1

asked chatgpt for time and space complexity of my initial passed solution
O(n) time and O(n) space

improvement to original method - as only lower case letters , chatgpt said we can use an array of 26 

so ig , map each letter to one index in the array , and store frequency of that letter in that index of array

why its better -> fixed space O(1) and reduces overhead of hashing , getting hashed value map.get() -> overhead , so using arrays improves the run time

came up with this - 

class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }

        for (int j = 0; j < s.length; j++) {
            int index1 = s.charAt(j) - 'a';
            if (arr[index1] == 1) {
                return j;
            }
        }
        return -1;
    }
}


Runtime
6ms
Beats84.48%
Memory
47.30MB
Beats18.62%


LEARN HOW TO DECREASE THESE BOTH
like using one extra variable change the memory??	
turns out no

asked chatgpt - 


When you write:

int index = s.charAt(i) - 'a';
This is just a local primitive variable (int)
It takes 4 bytes
It lives on the stack
It gets reused every iteration

👉 So total memory is still:

O(1) (constant)
Not dependent on input size


Memory changes significantly when you:
Create new arrays → O(n)
Use HashMap / objects → overhead
Store extra data structures
👉 NOT when using a single int

Why memory is still ~47MB even after optimization (that part is interesting)
That 47MB is NOT your code’s actual memory usage
It includes a lot of hidden overhead from Java + LeetCode environment

🤯 Then where does 47MB come from?
1. JVM Overhead ☕

Java runs inside the Java Virtual Machine (JVM):

👉 This alone can take tens of MB

2. Input String Storage

The string s:

Stored as a character array internally
Size ≈ 2 bytes × length

👉 Large test cases → more memory

3. LeetCode Measurement Style

LeetCode:
Measures total memory of the process
Not just your variables

👉 So it includes:

JVM
Input
Internal buffers
Execution framework



most memory comes from JVM and environment overhead. My optimization reduces algorithmic space from O(n) to O(1), but the absolute memory difference is too small compared to total runtime memory.


so like the time and memory is common for all languages?? , like i get compared with people using python and c++ in terms of memory and space ? or else only java

👉 No, you are NOT directly compared across languages fairly
But…
👉 On LeetCode, your submission appears in a mixed pool (all languages)


Different languages have very different baselines:

🟦 Java
Runs on JVM → higher memory (tens of MB)
Slightly slower startup
🟨 Python
Slower execution 🐢
High memory due to dynamic typing
🟩 C++
Very fast ⚡
Low memory (no VM)


Not really “apples to apples”
Example:
A C++ solution might show 2MB
Java shows 47MB
Python shows 60MB+


👉 That doesn’t mean your Java code is worse

Important Insight (Interview perspective)

Interviewers don’t care about:

“Beats X%”
They care about:

Time complexity ✅
Space complexity ✅
Clean logic ✅


❌ Not a fair cross-language comparison
⚠️ LeetCode rankings may mix languages
✅ Focus on complexity, not MB/ms
✅ Your optimization (HashMap → array) is what matters


--------------------------------------------------------------------------

203. Remove Linked List Elements - Easy

my implementation - 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pointer = dummy;

        if (pointer == null) {
            return head;
        }
        while (pointer.next != null) {
        if (pointer.next.val == val) {
            pointer.next = pointer.next.next;
        }
        else {
            pointer = pointer.next;
        }
    }
    return dummy.next;     
    }
}

Runtime
1ms
Beats95.70%
Memory
47.19MB
Beats85.14%

LETSGOOO

but I mean I already practiced this problem while learning so that's why it was so easy (but the dummy node concept was new , I didn't practice that)


solution with 0ms runtime (even more optimised)
from solutions tab - 

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val);

        if (head.val == val) {
            return head.next;   // delete current node
        } else {
            return head;        // keep current node
        }
    }
}

USES RECURSION DAMN
------------------------------------------------------------------------------------


27. Remove Element - Easy

my implementation - 

class Solution {
    public int removeElement(int[] nums, int val) {
        int current = 0;
        int nextValid =0;

        while (current < nums.length) {
            if (nums[current] == val) {
                current++;
            }
            else {
                nums[nextValid] = nums[current];
                nextValid++;
                current++;
            }
        }
        return nextValid;
        
    }
}

Runtime
0ms
Beats100.00%
Memory
43.45MB
Beats70.54%


LETS GOOOOOOOOOOOOOO

no help from chatgpt , didn't even look at the discussions tab or the hints


another way - We can move all the occurrences of this element to the end of the array. Use two pointers! 

[0,2,3,4,0]
val = 3
we can do 
[0,2,0,4,3]

order doesn't matter ig 
decrement the second pointer from back return the second pointer as end of array (all the elements after second pointer are the removed elements , ignore)

also need to be careful with the submissions man ,, i shouldn't just submit anything for streak 
i will get streak BUT my submissions acceptance rate will go down

its already at some 46% ;-;
gotta take care of that




