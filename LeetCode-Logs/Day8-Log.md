08042026

in the morning half today - focused on bit manipulation (did 2 practice problems given by gpt , didnt do any leet code questions)


--------------------------------------------------------------

did this problem in morning half - (did in 15-20 minutes ig)

1669. Merge In Between Linked Lists - Medium

ALL BY MYSELF , NO HINTS - 
```java
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        int count = 0;
        ListNode temp1 = list1;
        ListNode temp2 = list1;
        ListNode temp3 = list2;
        while (pointer1 != null) {
            pointer1 = pointer1.next;
            count++;
            if (count == a-1) {
                temp1 = pointer1;
            }
            if (count == b+1) {
                temp2 = pointer1;
            }
        }

        while (pointer2 != null) {
            if (pointer2.next == null) {
                temp3 = pointer2;
            }
            pointer2 = pointer2.next;
        }
        temp1.next = list2;
        temp3.next = temp2;
        return list1;
    }
}
```

Runtime
2ms
Beats32.67%
Memory
49.00MB
Beats96.97%

ok ok I can improve the time complexity

only used one loop - 
```java
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        int count = 0;
        ListNode temp1 = list1;
        ListNode temp2 = list1;
        ListNode temp3 = list2;
        while (pointer1 != null) {
            if (pointer1.next == null) {
                temp3 = pointer1;
            }
            pointer1 = pointer1.next;
            count++;
            if (count == a-1) {
                temp1 = pointer1;
            }
            if (count == b+1) {
                temp2 = pointer1;
                pointer1 = list2;
            }
        }
        temp1.next = list2;
        temp3.next = temp2;
        return list1;
    }
}
``` 

BUT IT GOT MEMORY GOT WORSE MAN

Runtime
2ms
Beats32.67%
Memory
49.39MB
Beats57.71%

even with ChatGPT hints , the time complexity didn't get better

pick a better approach and redo it later 

--------------------------------------------------------

afternoon -

3110. Score of a String - Easy
```java
class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0;i<s.length()-1;i++) {
            int result = Math.abs((int)s.charAt(i) - (int)s.charAt(i+1));
            sum += result;
        }
        return sum;
    }
}
```
Runtime
1ms
Beats99.89%
Memory
43.12MB
Beats89.94%


---------------------------------------------------------

2011. Final Value of Variable After Performing Operations - Easy
```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i = 0 ; i < operations.length ; i++) {
            char operator = operations[i].charAt(1);
            if (operator == '+') {
                x++;
            }
            else if (operator == '-') {
                x--;
            }
            }
            return x;
    }
}
```
Runtime
0ms
Beats100.00%
Memory
44.36MB
Beats74.82%

-----------------------------------------------------------

1832. Check if the Sentence Is Pangram - Easy
```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for (int i = 0;i<sentence.length();i++) {
            int index = sentence.charAt(i) - 'a';
            arr[index]++;
        }
        for (int j = 0;j<arr.length;j++) {
            if (arr[j] == 0) {
                return false;
            }
        }
        return true;  
    }
}
```
Runtime
2ms
Beats68.33%
Memory
42.72MB
Beats89.03%


saw set approach in disscussions and implemented thinking that it would be faster cuz only 1 loop BUT - 
```java
import java.util.HashSet;
class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();  

        for (int i = 0;i<sentence.length();i++) {
            set.add(sentence.charAt(i));
        }
        if (set.size() != 26) {
            return false;
        }
        return true;
    }
}
```
Runtime
4ms
Beats25.46%
Memory
42.98MB
Beats62.75%

man it turned out worse than the array implementation (mostly because of set overhead and operations ig)


---------------------------------------------------

2469. Convert the Temperature - Easy
```java
class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        double[] arr = {kelvin,fahrenheit};
        return arr;
    }
}
```
Runtime
0ms
Beats100.00%
Memory
46.06MB
Beats68.34%

---------------------------------------------------

1512. Number of Good Pairs - Easy
```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count =0;
        for (int i = 0;i<nums.length;i++) {
            for (int j = 0;j<nums.length;j++) {
                if (nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }
        return count;
        
    }
}
```
Runtime
2ms
Beats6.34%
Memory
42.76MB
Beats70.93%


looked at hints - 
Count how many times each number appears. If a number appears n times, then n * (n – 1) // 2 good pairs can be made with this number.
```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                int value = map.get(i);
                map.put(i,value+1);
            }
            else {
                map.put(i,1);
            }
        }

        for (int value : map.values()) {
            int x = value * (value-1) / 2;
            result += x;
        }
        return result;
        
    }
}
```
Runtime
1ms
Beats83.94%
Memory
42.83MB
Beats52.80%

how was I supposed to know that formula ;-;
--------------------------------------------------

3541. Find Most Frequent Vowel and Consonant - Easy
```java
class Solution {
    public int maxFreqSum(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }
        int maxConsonant = 0;
        int maxVowel = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > maxVowel
                    && ( j == 0 || j == 4 || j == 8 || j == 14 || j == 20)) {
                        maxVowel = arr[j];
            }
            if (arr[j] > maxConsonant
                    && ( j != 0 && j != 4 && j != 8 && j != 14 && j != 20)) {
                        maxConsonant = arr[j];
            }
        }
        return maxConsonant + maxVowel;
    }
}
```
Runtime
2ms
Beats54.93%
Memory
43.30MB
Beats98.76%

gotta improve time complexity man

------------------------------------------------------

i am searching for the easiest questions in leetcode and doing them bruh
I GOTTA FOLLOW A STRICT PLAN MAN

PROPER ROADMAP
WATCH VIDEOS ON YT