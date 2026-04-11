11 04 2026


actually explored the strivers dsa sheet today for the first time (REALLY REALLY USEFUL MAN)
perfect plan/structured roadmap
thought of starting the striver a-z dsa sheet today 
but it was already night as spent most of the today working on college club stuff and then did devops project (added prometheus and grafana to my portfolio ci cd pipeline)

so quickly did these for the streaks - 

7. Reverse Integer- Medium

thought damn , easy only

came up with this - 

class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int lastDigit = x%10;

            if (result > (Integer.MAX_VALUE)) {
                return 0;
            }
            result = (result * 10) + lastDigit;
            x = x / 10; 
        }
        return result;
    }
}

but then read question properly 
If reversing x causes the value to go outside the signed 32-bit integer range [-2power31, 2power31 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

got the value of 2power31 and checked > and < but this test case was failing - 1534236469
its below 2power31 tho , checked comments said the same thing ,, then looked at solution and did this - 

class Solution {
    public int reverse(int x) {
        int result = 0;
        int num = Math.abs(x);
        while (num != 0) {
            int lastDigit = num % 10;

            if (result > (Integer.MAX_VALUE - lastDigit) / 10) {
                return 0;
            }
            result = (result * 10) + lastDigit;
            num = num / 10;
        }
        if (x > 0) {
            return result;
        } else {
            return -result;
        }

    }
}

Runtime
1ms
Beats99.97%
Memory
42.46MB
Beats84.20%

------------------------------------------------------------------------------------------------------------------

MAN I SHOULD DO DSA FIRST THING IN THE MORNING CUZ RN ITS NIGHT , I am tired , sleepy , can't focus like morning bruh 


looked for some more easy ones to keep streak alive -- 

1290. Convert Binary Number in a Linked List to Integer - Easy

class Solution {
    public int getDecimalValue(ListNode head) {
        String binary = "";
        while (head!=null) {
            binary = binary + head.val;
            head = head.next;
        }
        return Integer.parseInt(binary,2);
    }
}

Runtime
4ms
Beats5.27%
Memory
43.04MB
Beats23.47%

BRUH 

looked at hints 

You can solve the problem in O(1) memory using bits operation. use shift left operation ( << ) and or operation ( | ) to get the decimal value in one operation.
man how was I supposed to know that , I mean the condition is that the elements can only be zero or one in the linkedin list 
but I didn't see enough patterns to recognise it nor didn't have enough practice

WORK ON THIS AGAIN (really cannot focus now)
(MAKE A LIST OF PATTERNS WHENEVER I ENCOUNTER NEW ONE)


-----------------------------------------------------------------------------------------------------------------

876. Middle of the Linked List - Easy


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            return slow.next;
        }
        return slow;
    }
}


Runtime
0ms
Beats100.00%
Memory
42.75MB
Beats77.55%

recently saw this while scrolling through striver sheet like clicked random one and got this and it said - use slow and fast pointer approach
DAMN
didn't even think of that
keep track of patterns man

-----------------------------------------------------------------------------------------------------------------


tried some , did half but really sleepy and couldnt focus man
START STRIVER'S A-Z DSA SHEET FROM TOMORROW


told this to chatgpt - 

BRO , today is 11th april ,, and until now,man i have been doing a lot of easy (LITERALLY THE MOST BASIC) leetcode questions just to increase the number and feel good ,, like i did around 40 easy questions ,, but now man , enough is enough , what happened is done ,, lets start proper way from today ,, 11th april ,, i want a proper roadmap ,,i came acorss this - https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z (seems like a good structured roadmap , but do they teach too? , if they do then ill only follow this (free??))