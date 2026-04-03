03/04/2026 

21. Merge Two Sorted Lists - Easy

took a lot of time to understand , like used pen and paper and visualised for a lot of time 
and then kinda got a hand of it -

first implementation 

/** (this comment is given by them)
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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode mergedHead = new ListNode(-1000,null);
        ListNode originalMergedHead = mergedHead;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        while(head1 != null || head2 != null) {
        if (head1 == null) {
            mergedHead.next = new ListNode(head2.val);
            mergedHead = mergedHead.next;
            break;
        }
        if (head2 == null) {
            mergedHead.next = new ListNode(head1.val);
            mergedHead = mergedHead.next;
            break;
        }
        if (head1.val <= head2.val) {
            if (mergedHead.val == -1000) {
                mergedHead.val = head1.val;
            } 
            else {
            mergedHead.next = new ListNode(head1.val,null);
            mergedHead = mergedHead.next;
            }
            head1 = head1.next;
        }
        else if (head1.val > head2.val) {
            if (mergedHead.val == -1000) {
                mergedHead.val = head2.val;
            } 
            else {
                mergedHead.next = new ListNode(head2.val,null);
                mergedHead = mergedHead.next;
            }
            head2 = head2.next;
        }
        }
       return originalMergedHead; 
    }
}


until this part , didn't even look at discussions or chatgpt 

but one type of testcases failing -> if first linkedlist reaches end , then I am just copying one element from the second linkedin list , not the entire remaining second linkedlist ,,

took chatgpt help (ONLY HINT -> prompt - I am doing Leetcode , DONT GIVE DIRECT CODE, just small hints)

it said to use a while loop to copy remaining of the elements


then did this - 
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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode mergedHead = new ListNode(-1000,null);
        ListNode originalMergedHead = mergedHead;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        while(head1 != null || head2 != null) {
        if (head1 == null) {
            while(head2 != null) {
            mergedHead.next = new ListNode(head2.val);
            mergedHead = mergedHead.next;
            head2 = head2.next;      // ALSO FORGOT THESE SO GETTING OUT OF MEMORY ERROR (chatgpt pointed out)
            }
            break;
        }
        if (head2 == null) {
            while(head1 != null) {
            mergedHead.next = new ListNode(head1.val);
            mergedHead = mergedHead.next;   
            head1 = head1.next;      // ALSO FORGOT THESE SO GETTING OUT OF MEMORY ERROR (chatgpt pointed out)
            }
            break;
        }
        if (head1.val <= head2.val) {
            if (mergedHead.val == -1000) {
                mergedHead.val = head1.val;
            } 
            else {
            mergedHead.next = new ListNode(head1.val,null);
            mergedHead = mergedHead.next;
            }
            head1 = head1.next;
        }
        else if (head1.val > head2.val) {
            if (mergedHead.val == -1000) {
                mergedHead.val = head2.val;
            } 
            else {
                mergedHead.next = new ListNode(head2.val,null);
                mergedHead = mergedHead.next;
            }
            head2 = head2.next;
        }
        }
       return originalMergedHead; 
    }
}

Runtime
0ms
Beats100.00%
Memory
44.25MB
Beats66.02%



very messy , LOT OF IMPROVEMENTS CAN BE DONE 

COME BACK TO THIS AND DO IMPROVEMENTS

took 1 HR to complete this problem
-----------------------------------------------------------------------------------------



26. Remove Duplicates from Sorted Array - Easy

tried converting to hashset but for some reason , not working 
looked at all 3 hints 
didn't really understand at first sight (all 3 hints) 

and then thought about it and kinda slowly clicked (turns out it is a two pointer problem ;-;)

i need to work on pattern recognition man (consider all the techniques i know)

so implemented this -- (without looking at discussion or any chatgpt hints)

class Solution {
    public int removeDuplicates(int[] nums) {
        int current = 1;
        int nextUnique = 1;
        while (current < nums.length) {
            if (nums[current] == nums[current-1]) {
                current++;
            }
            else if (nums[current] != nums[current-1]) {
                nums[nextUnique] = nums[current];
                nextUnique++;
                current++;
            }
        }
        return nextUnique;
    }
}

Runtime
1ms
Beats78.08%
Memory
46.53MB
Beats86.96%



-------------------------------------------------

28. Find the Index of the First Occurrence in a String- Easy
kinda started it but turns out we need to implement KMP algorithm
idk KMP algorithm 
so left it unsolved

