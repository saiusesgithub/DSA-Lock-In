07042026

morning half - learnt about sliding window (in placement training class)
(wrote notes in the java file -> LeetCode-Logs\Day7 - Sliding Window\SlidingWindow.java )
kinda struggled with it for a long time but then slowly got hang of it 
mainly struggled cuz lacked focus cuz not a silent place cuz placement training class was going on

asked chatgpt and it suggested to do below programs

from afternoon -
1:30 to 2:00 - 

1800. Maximum Ascending Subarray Sum - Easy

my implementation (NO HINTS / Discussions) - copied the code to IDE and debugged using built in debugger in IntelliJ idea

class Solution {
    public int maxAscendingSum(int[] nums) {
        int end = 1;
        int maxSum = 0;
        int tempSum = nums[0];

        while (end < nums.length) {
            if (nums[end - 1] >= nums[end]) {
                maxSum = Math.max(maxSum, tempSum);
                tempSum = 0;
            }

            tempSum += nums[end];
            end++;
        }
        maxSum = Math.max(maxSum, tempSum);
        return maxSum;
    }
}

Runtime
0ms
Beats100.00%
Memory
42.80MB
Beats93.21%


-----------------------------------------------------------------------------


643. Maximum Average Subarray I - Easy

initial solution (no hints , completely by myself)

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = 0;
        double length = 1;
        double maxAvg = nums[end] / length;
        double tempAvg = 0;
        double sum = 0;

        while (end < nums.length) {
            length = end - start + 1;
            if (length <= k) {  
                sum += nums[end];
                end++;
            }
            else {
                sum-=nums[start];
                start++;
            }
            tempAvg = sum / length;
            maxAvg = Math.max(maxAvg,tempAvg);
            
        }
        return maxAvg;
    }
}

came up with solution , mostly working , some cases failing 

NOT SOLVED , WORK ON THIS AGAIN

did half in college 
tried a little bit after coming home

(also the other 2 questions which chatgpt gave were too complex for me , direct jump to medium questions)
i gotta take it slow , if i do medium now, ill get demotivated and lose confidence

-------------------------------------------------------------------------

randomly picked up these questions from the problem's list - 

35. Search Insert Position - Easy

man really messed up in the first try (didn't read question properly) and even after reading , if i dont have book OR i dont debug in IntelliJ then man i cant come up with solutions

copied the code to IntelliJ and debugged step by step 
yeah , for me personally , ig that feels like the cheatcode 

step by step debugging 
BUT i SHOULD do dryruns as i wont have IDE all the time

class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = binarySearch(nums,target,0,nums.length-1);
        return result;
    }

    int binarySearch(int[] nums, int target , int low , int high) {
        int mid = (low+high) / 2;
        if (low > high) {
            return low;
        }
        if (target == nums[mid]) {
            return mid;
        }
        else if (target < nums[mid]) {
            return binarySearch(nums,target,low,mid-1);
        }
        else {
            return binarySearch(nums,target,mid+1,high);
        }
    }
}

Runtime
0ms
Beats100.00%
Memory
45.03MB
Beats6.38%

atleast didn't take any hints tho

MAN I GOTTA LEARN THE METHOD WITHOUT USING RECURSION AND LOW,HIGH separately

-----------------------------------------------------------------------

258. Add Digits - Easy

came up with kinda this solution
not working for some reason

class Solution {
    public int addDigits(int num) {
        int result = 0;
        while (num > 9) {
        while(num > 0) {
            result = result + num%10;
            num = num/10;
        }
        num=result;
    }
        return result;
    }
}

so looked at hints in Leetcode and they linked to a Wikipedia article - https://en.wikipedia.org/wiki/Digital_root

in that found this formula and solved -

class Solution {
    public int addDigits(int num) {
        return 1+((num-1) % (10-1));  
}
}

Runtime
1ms
Beats98.09%
Memory
42.84MB
Beats15.92%

MAN HOW WAS I SUPPOSED TO KNOW THAT FORMULA

they gave this in the description - Follow up: Could you do it without any loop/recursion in O(1) runtime? so they kinda hinted that this is the intended solution

--------------------------------------------------

came across this in 
https://leetcode.com/explore/learn/card/the-leetcode-beginners-guide/


1672. Richest Customer Wealth - Easy

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for (int i =0;i<accounts.length;i++) {
            int tempSum=0;
            for (int j =0;j<accounts[i].length;j++) {
                tempSum += accounts[i][j];
            }
            maxSum = Math.max(maxSum,tempSum);
        }
        return maxSum;
        
    }
}

Runtime
0ms
Beats100.00%
Memory
44.58MB
Beats65.88%


--------------------------------------------------

came across this in 
https://leetcode.com/explore/learn/card/the-leetcode-beginners-guide/

383. Ransom Note - Easy 

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int j = 0;j<magazine.length();j++) {
            int index = magazine.charAt(j) - 'a';
            arr[index] = arr[index] + 1;
        }
        
        for (int i = 0;i<ransomNote.length();i++) {
            int index = ransomNote.charAt(i) - 'a';
            arr[index] = arr[index] - 1;
            if(arr[index] < 0) {
                return false;
            }
        }
        return true;

    }
}

Runtime
1ms
Beats99.94%
Memory
46.51MB
Beats55.30%


-------------------------------------------------

came across this in 
https://leetcode.com/explore/learn/card/the-leetcode-beginners-guide/

412. Fizz Buzz - Easy 

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1 ; i <= n ; i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                list.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                list.add("Fizz");
            }
            else if (i % 5 ==0) {
                list.add("Buzz");
            }
            else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

}

Runtime
1ms
Beats100.00%
Memory
47.08MB
Beats18.82%

-----------------------------------------------------

1480. Running Sum of 1d Array - Easy

class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];

        int sum = 0;
        for (int i =0;i<nums.length;i++) {
            sum+=nums[i];
            result[i] = sum;
        }
        return result;

        
    }
}

Runtime
0ms
Beats100.00%
Memory
44.56MB
Beats10.19%


improvement - 

class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i =0;i<nums.length;i++) {
            sum+=nums[i];
            nums[i] = sum;
        }
        return nums;   
    }
}

Runtime
0ms
Beats100.00%
Memory
44.15MB
Beats79.49%

-------------------------------------------------------------

1342. Number of Steps to Reduce a Number to Zero - Easy

class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num/2;
                count++;
            }
            else {
                num--;
                count++;
            }
        }
        return count;
        
    }
}

Runtime
0ms
Beats100.00%
Memory
41.98MB
Beats90.76%

------------------------------------------------------------

2396. Strictly Palindromic Number - Medium 

LETS GOOOO DID MY FIRST MEDIUM QUESTION WITHOUT ANY HINTS
i mean i kinda sorted problems with most acceptance rate and picked this medium question but still

class Solution {
    public boolean isStrictlyPalindromic(int n) {
       for (int i =2;i<=n-2;i++) {
            String s = Integer.toString(n , i);
            if (!isPalindrome(s)) {
                return false;
            }
       } 
       return true;
    }

    static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

Runtime
0ms
Beats100.00%
Memory
42.08MB
Beats70.93%

-----------------------------------------------------------------


237. Delete Node in a Linked List - Medium 

SECOND MEDIUM QUESTION LETSGOO

when i read it first , kinda felt overwhelmed cuz description seems pretty complex 
but then , found the trick

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;   
    }
}

THAT IS IT , THE ENTIRE CODE
(most of the people is discussion didn't figure it out , almost even i didn't , then it suddenly clicked)

Runtime
0ms
Beats100.00%
Memory
45.22MB
Beats49.96%

-------------------------------------------


APART FROM ALL THESE
did 10 basic/easy questions on geeksforgeeks (i only did the simple ones today to keep it light)