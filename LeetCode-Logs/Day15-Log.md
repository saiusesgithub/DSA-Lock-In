15 04 2026

141. Linked List Cycle - Easy

9:45 pm to 10:10 pm
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && slow != null && fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
        
    }
}
```
picked this cuz i practiced the slow fast pointer approach while practicing java

but 

Runtime
1ms
Beats13.79%
Memory
46.93MB
Beats20.41%

BRUH

saw this then - 
Follow up: Can you solve it using O(1) (i.e. constant) memory?

these are the mentioned topics - 
Topics
Hash Table
Linked List
Two Pointers

came up with this method -
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode pointer = head;
        int index = 0;
        while(pointer!=null) {
            if (map.containsKey(index)) {
                return true;
            }
            else {
                map.put(index,1);
            }
            index++;
            pointer = pointer.next;
        }
        return false;
    }
}
```

BUT index is always increasing , asked chatgpt for hint and it kinda said (you are storing index in hashmap , not the node ,, I CAN STORE THE NODE ITSELF IN THE HASHMAP) -
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode pointer = head;
        while(pointer!=null) {
            if (map.containsKey(pointer)) {
                return true;
            }
            else {
                map.put(pointer,1);
            }
            pointer = pointer.next;
        }
        return false;
    }
}
```
Runtime
7ms
Beats9.48%
Memory
46.47MB
Beats94.02%

BROOOOO
looked at the solutions and EXACT SAME AS MINE 
only difference 

I used (fast != null && slow != null && fast.next!=null && fast.next.next != null) instead of (fast != null && fast.next!=null)
WAS THOSE 2 MORE CHECKS MAKING SO MUCH DIFFERENCE
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
        
    }
}
```
Runtime
0ms
Beats100.00%
Memory
46.80MB
Beats38.16%


----------------------------------------------------------------------------------------------------------------------------------------------

10:10 pm to 10:20 pm - 

2181. Merge Nodes in Between Zeros - Medium
```java
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode resultLLHead = new ListNode();
        ListNode resultLLPointer = resultLLHead;
        int sum = 0;
        ListNode pointer = head;
        while (pointer != null) {
            if (pointer.val ==0) {
                ListNode temp = new ListNode(sum);
                resultLLPointer.next = temp;
                resultLLPointer = temp;  
                sum = 0;
            }
            sum = sum +pointer.val;
            pointer = pointer.next;
        }
        return resultLLHead.next.next;
        
    }
}
```
Runtime
6ms
Beats71.04%
Memory
260.83MB
Beats29.40%

I can still improve the time and space by somehow modifying the original LL instead of making new LL

Hint 1 
How can you use two pointers to modify the original list into the new list?
Hint 2
Have a pointer traverse the entire linked list, while another pointer looks at a node that is currently being modified.
Hint 3
Keep on summing the values of the nodes between the traversal pointer and the modifying pointer until the former comes across a ‘0’. In that case, the modifying pointer is incremented to modify the next node.
Hint 4
Do not forget to have the next pointer of the final node of the modified list point to null.

----------------------------------------------------------------------------------------------------------------------------------------------

1108. Defanging an IP Address - Easy

10:50 to 11:00pm 
```java
class Solution {
    public String defangIPaddr(String address) {
        String result = "";
        for (int i =0;i<address.length();i++) {
            if (address.charAt(i) == '.') {
                result = result + "[.]";
            }
            else {
                result = result + address.charAt(i);
            }
        }
        return result;
    }
}
```
Runtime
3ms
Beats20.19%
Memory
43.10MB
Beats15.84%

it was really late and really tired so 

Also i gotta start doing strivers sheet consistently man 
one topic per day 
randomly did questions today

------------------------------------------------------------------------------------------------------------
