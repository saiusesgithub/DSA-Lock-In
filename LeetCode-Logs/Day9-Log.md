09/04/2026

didnt focus on leetcode today
morning half of placement training - worked on devops lock in phase 5 (prometheus and grafana)

in afternoon , did these easy questions just to keep up the streak
(man i am doing just easy questions, like i am searching and picking easy questions instead of progressing
in a structured manner)

1 medium question per day >>>> 3-4 easy questions

1486. XOR Operation in an Array - Easy
```java
class Solution {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];

        for (int i = 0;i<n;i++) {
            arr[i] = start + 2 * i;
        }
        int result = arr[0];

        for (int j = 1;j<arr.length;j++) {
            result = result ^ arr[j];
        }
        return result;
    }
}
```
Runtime
0ms
Beats100.00%
Memory
41.94MB
Beats81.56%


-------------------------------------------------------------------------------

2798. Number of Employees Who Met the Target - Easy
```java
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int i : hours) {
            if (i >= target) {
                count++;
            }
        }
        return count;
        
    }
}
```

Runtime
0ms
Beats100.00%
Memory
44.41MB
Beats13.52%

-------------------------------------------------------------------------------


2235. Add Two Integers - Easy
```java
class Solution {
    public int sum(int num1, int num2) {
        return num1+num2;
    }
}
```
Runtime
0ms
Beats100.00%
Memory
42.25MB
Beats64.70%

-------------------------------------------------------------------------------

771. Jewels and Stones - Easy
```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0 ; i< stones.length();i++) {
            for (int j = 0 ; j < jewels.length();j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
        
    }
}
```
Runtime
0ms
Beats100.00%
Memory
43.04MB
Beats76.12%


-----------------------------------------------------------------------------

1929. Concatenation of Array - Easy

```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];

        for (int i =0;i<nums.length;i++) {
            arr[i] = nums[i];
        }
        int j = 0;
        for (int k =nums.length;k<nums.length*2;k++) {
            arr[k] = nums[j];
            j++;
        }
        return arr;
        
    }
}
```
Runtime
1ms
Beats96.51%
Memory
47.34MB
Beats25.82%

---------------------------------------------------------------------------

136. Single Number - Easy
```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i =1;i<nums.length;i++) {
            result = result ^ nums[i];
        }
        return result;
        
    }
}
```
Runtime
1ms
Beats99.98%
Memory
46.84MB
Beats72.77%

---------------------------------------------------------------------------


