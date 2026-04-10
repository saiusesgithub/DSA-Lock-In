10 04 2026

Started doing at night , so not really focused (the entire day was wasted in other stuff , didnt even touch until night , even in night too , just to keep the streak alive)

2824. Count Pairs Whose Sum is Less than Target - Easy

```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int result = 0;
        for (int i =0;i<nums.size();i++) {
            for (int j =0;j<nums.size();j++) {
                if (nums.get(i) + nums.get(j) < target && i < j) {
                    result++;
                }
            }
        }
        return result; 
    }
}
```

Runtime
4ms
Beats6.86%
Memory
44.27MB
Beats37.29%

really tired so looked at Leetcode hints -

Hint 1
The constraints are small enough for a brute-force solution to pass

looked at solutions 
not completely different solution , just optimisation required for the current one 

```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int result = 0;
        for (int i =0;i<nums.size()-1;i++) {
            for (int j =i;j<nums.size();j++) {                                           // just j = i instead of j = 0 improves so much
                if (nums.get(i) + nums.get(j) < target && i<j) {
                    result++;
                }
            }
        }
        return result; 
    }
}
```

Runtime
2ms
Beats98.29%
Memory
44.04MB
Beats73.89%

------------------------------------------------------------------------------------------------------------------

3701. Compute Alternating Sum - Easy

```java
class Solution {
    public int alternatingSum(int[] nums) {
        int result = 0;
        for (int i = 0 ; i< nums.length;i++) {
            if (i % 2 == 0) {
                result += nums[i];
            }
            else {
                result -= nums[i];
            }
        }
        return result;
    }
}
```

Runtime
1ms
Beats98.76%
Memory
46.48MB
Beats55.58%


---------------------------------------------------------------------------------------------------------------

2894. Divisible and Non-divisible Sums Difference - Easy

```java
class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 = num2 + i;
            } else {
                num1 = num1 + i;
            }
        }
        return num1 - num2;
    }
}
```
Runtime
1ms
Beats93.26%
Memory
41.98MB
Beats99.00%

-----------------------------------------------------------------------------------------------------------------

also did some easy geeksforgeeks problems