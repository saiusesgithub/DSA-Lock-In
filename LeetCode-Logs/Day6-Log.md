06042026

placement training classes from today
so took laptop and practiced java

in the morning half, implemented -> 
linear search
binary search
bubble sort
selection sort

and overall in college today, did these problems ->

704. Binary Search - Easy - 

initial implementation - 

class Solution {
    public int search(int[] nums, int target) {
        return BubbleSort(nums, 0 , nums.length-1 , target);

    }

    static public int BubbleSort( int[] arr , int start , int end , int target ) {
        int mid = (start + end)/2;
        
        if (start > end ) {
            return -1;
        }

        if (arr[mid] == target) {
            return mid;
        }
        else if (target < arr[mid] ) {
            return BubbleSort(arr,start,mid-1,target);
        }
        else {
            return BubbleSort(arr,mid+1,end,target);
        }

    }
}

Runtime
0ms
Beats100.00%
Memory
48.29MB
Beats76.75%

works but not the intended way (i am creating another method)
so solve this again

--------------------------------------------------------------

13. Roman to Integer - Easy

initial - 

import java.util.Map;
class Solution {
    static int romanToInt(String s) {
        Map<Character,Integer> map = Map.of(
                'I' , 1,
                'V' , 5,
                'X' , 10,
                'L' , 50,
                'C' , 100,
                'D' , 500,
                'M' , 1000
        );

        int num = 0;
        for (int i =0;i<s.length()-1;i++) {
            char c = s.charAt(i);
            int value = 0;
            if (c == 'I' && s.charAt(i+1) == 'V') {
                value = 4;
                i++;
            }
            else if (c == 'I' && s.charAt(i+1) == 'X') {
                value = 9;
                i++;
            }
            else if (c == 'X' && s.charAt(i+1) == 'L') {
                value = 40;
                i++;
            }
            else if (c == 'X' && s.charAt(i+1) == 'C') {
                value = 90;
                i++;
            }
            else if (c == 'C' && s.charAt(i+1) == 'D') {
                value = 400;
                i++;
            }
            else if (c == 'C' && s.charAt(i+1) == 'M') {
                value = 900;
                i++;
            }
            else {
                if (i == s.length() - 2) {
                    value = map.get(c) + map.get(s.charAt(i+1));
                }
                else {
                    value = map.get(c);
                }
            }
            num += value;
        }
        return num;
    }

    public static void main() {
        int num = romanToInt("MDCXCV");
        System.out.println(num);
    }
}


final working after taking a lot of hints from chatgpt - 

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = Map.of(
            'I' , 1,
            'V' , 5,
            'X' , 10,
            'L' , 50,
            'C' , 100,
            'D' , 500,
            'M' , 1000
        );

        int num = 0;
        int i =0;
        for (i =0;i<s.length()-1;i++) {
            char c = s.charAt(i);
            int value = 0;
            if (c == 'I' && s.charAt(i+1) == 'V') {
                value = 4;
                i++;
            }
            else if (c == 'I' && s.charAt(i+1) == 'X') {
                value = 9;
                i++;
            }
            else if (c == 'X' && s.charAt(i+1) == 'L') {
                value = 40;
                i++;
            }
            else if (c == 'X' && s.charAt(i+1) == 'C') {
                value = 90;
                i++;
            }
            else if (c == 'C' && s.charAt(i+1) == 'D') {
                value = 400;
                i++;
            }
            else if (c == 'C' && s.charAt(i+1) == 'M') {
                value = 900;
                i++;
            }
            else {
            value = map.get(c);
            }
            num += value;
        }
        if (i == s.length() - 1) {
        num += map.get(s.charAt(s.length()-1));
        }
        return num;
    }
}

Runtime
5ms
Beats35.64%
Memory
46.84MB
Beats25.41%

man i came up with a trash solution/method to solve
instead of fixing it , if it takes too long
ig just screw the old method and starting from scratch is best option

chatgpt review / hints / mistakes - 

🔴 1. Overcomplicating the last element
Your initial mistake:
if (i == s.length() - 2) {
    value = map.get(c) + map.get(s.charAt(i+1));
}

👉 Problem:

You tried to handle the last two characters inside the loop
This mixes responsibilities:
Loop = process one step
But you made it process two elements conditionally

⚠️ Result:

Hard to reason about
Breaks when i++ happens in pair cases
Leads to double counting / skipping

🟡 2. Mixing two different strategies

You accidentally combined:

Strategy A (correct pair handling):
if (IV, IX, etc) → take both, do i++
Strategy B (manual last handling):
if (last two chars) → add both

👉 These two conflict with each other

🔴 3. Not tracking index movement properly

When you do:

i++;

👉 You're skipping the next character intentionally.

But your original code:

Did not account for this when handling the last case
Assumed i moves linearly

⚠️ That’s why your edge cases broke.

🟢 4. What your working version fixed

This line is the key:

if (i == s.length() - 1)

👉 Insight:

You now check where the loop actually ended
Not where you think it should end

💡 This is the real learning:

"Loop index after execution matters more than assumptions before execution"

🟡 5. Hidden design issue (important)

Your approach:

if (IV, IX, XL, XC, CD, CM)

👉 This is:

Hardcoded
Not scalable
Easy to miss cases in similar problems

Better mental model (for future):

Compare current value with next value instead of memorizing pairs

🟢 6. What you did RIGHT

Give yourself credit here:

✔ Correct use of Map
✔ Correct handling of subtractive pairs
✔ Correct use of i++ to skip
✔ Eventually fixed edge case properly

🧠 Final takeaway (most important)
❌ Your original mindset:
"Handle edge cases inside the loop"

✅ Better mindset:
"Let the loop do one clean job, handle leftovers separately"


SOLVE THIS AGAIN PROPERLY



--------------

83. Remove Duplicates from Sorted List - Easy


first try - 

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return head;

        ListNode pointer = head;
        while (pointer.next != null) {
        if (pointer.next.val == pointer.val) {
            pointer.next = pointer.next.next;
        }
        else {
            pointer = pointer.next;
        }
    }
    return head;
        
    }
}

Runtime
0ms
Beats100.00%
Memory
45.53MB
Beats40.57%

LETS GO!

-------------------------------------------------------------------

after coming home - 
didnt do any cuz other works + NO PROPER PLAN MAN
i am randomly doing stuff bruh

i got a really great chance 
this one week

i can REALLY LOCK IN
ONLY DSA IN COLLEGE
after coming home , ONLY PROJECTS / DOMAIN LEARNING

