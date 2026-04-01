1/04/2026

FIRST PROPER DAY ON LEETCODE!

so from now on ig , keep doing problems on leetcode , if i come across a new topic , learn that topic , and then do some problems related to that topic for practice

1. Two Sum

initial solution - 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length;i++) {
            for (int j = 0 ; j < nums.length;j++) {
                if (nums[i] + nums[j] == target && i!=j) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
}


------------

after hint 2 - So, if we fix one of the numbers, say x, we have to scan the entire array to find the next number y which is value - x where value is the input parameter. Can we change our array somehow so that this search becomes faster? 



hint 3? - The second train of thought is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?


how can hashmap be used?? for searching? , i only learnt about frequency hashmap

i thought we would create a hashmap (index,value) ,,
from hint -> requiredvalue = target -x ;
find the index of required value from hashamp


LETS GO MAN -
after lot of debugging with book and pen --

import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0;i<nums.length;i++) {
            map.put(nums[i],i);
        }

        for (int i = 0;i<nums.length;i++) {
            int k = nums[i];
            int requiredValue = target - k;
            if (map.get(requiredValue) != null && map.get(requiredValue) != i) {
                arr[0] = i;
                arr[1] = map.get(requiredValue);
                break;
            }
        }
        return arr;
}
}


runtime - 4ms , beats 52.22%
memory - 46.54mb , beats 96.44%


// their optimal solution // HOLY SHIT MAN ALMOST EXACTLY SAME LESS GOOOOOOO- 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, return an empty array
        return new int[] {};
    }
}

(man spent too much time on this , around 40 ish minutes)
------------------------------------------------

125. Valid Palindrome
 

import java.util.*;
import java.lang.*;
class Solution {
    public boolean isPalindrome(String s) {
        
        String cleaned = "";

        for (int k = 0; k < s.length();k++) {
            char c = s.charAt(k);
            if (Character.isAlphabetic(c)) {
                cleaned = cleaned + c;
            }
        }
        int i =0;
        int j = cleaned.length()-1;
        cleaned = cleaned.toLowerCase();

        if(cleaned.length() == 0) {
            return true;
        }
        for (int l = 0 ; l <cleaned.length();l++) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
} 


did until here completely on my own , thought DAMN MY FIRST NO HINTS PROPER LEETCODE QUESTION

but then this testcase came while submitting - s="0P" (that is zero) , i am supposed to show false , but i am ignoring numbers 

to find numbers , there is no isNumeric method in java, we have to use try catch using NumberFormatException (Integer.parseInt(c)) or else some StringUtils.isInteger


opened discussions 
everyone having problem with 0P, if 0 is removed ,then p is single letter , hence palindrome


what others are doing - What I did was:
    remove all the non alpha numeric items from the string
    transform the string into a list
    create another list equally
    reverse this second list as O(1)
    compare these two lists


turns out in question , they also mentioned -> consider characters and numbers 

so searched on google for - how to find out if character is number in java 
Character.isDigit(c) ;;

GOT IT DAYUM 

import java.util.*;
import java.lang.*;
class Solution {
    public boolean isPalindrome(String s) {
        
        String cleaned = "";

        for (int k = 0; k < s.length();k++) {
            char c = s.charAt(k);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                cleaned = cleaned + c;
            }
        }
        int i =0;
        int j = cleaned.length()-1;
        cleaned = cleaned.toUpperCase();

        if(cleaned.length() == 0) {
            return true;
        }
        for (int l = 0 ; l <cleaned.length();l++) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}


Runtime
129ms
Beats5.10%

Memory
47.82MB
Beats8.30%


------------------------------------------------------------

217. Contains Duplicate

FIRST TRY!

import java.util.HashMap;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0 ; i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            else {
                map.put(nums[i],1);
            }
        }
        return false;
    }

}

but not very optimal 

Runtime
15ms
Beats64.89%
Memory
96.71MB
Beats17.62%


discussion tab - 

I can understand why Arrays.sort() is a better option in terms of space but how usingArrays.Sort() (3ms) is giving faster results than using HashSet (5ms) ?


omg - SET (size of set and size of array not equal -> duplicates present)



then wrote this - 

import java.util.HashMap;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();

        for (int i = 0 ; i < nums.length;i++) {
            set.add(nums[i]);
        }
        if (set.size() != nums.length) {
            return true;
        }
        return false;
    }

}

Runtime
22ms
Beats31.79%
Memory
80.64MB
Beats75.42%
bruh EVEN WORSE 

but that is because i am building the entire hashset (stopping in between for hashmap tho)
but i saw this in discussions panel ->
 

a lot of people are getting time limit exceeded error , I didn't get in any so far :D



saw this in one of the comment - 

set.add() method returns a boolean value. 
true: The specified element was not already present in the set and was successfully added.
false: The specified element was already present in the set. Because sets do not allow duplicate elements, the set remains unchanged

finally wrote this -

import java.util.HashMap;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();

        for (int i = 0 ; i < nums.length;i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}

Runtime
10ms
Beats99.66%
Memory
98.07MB
Beats5.34%

amazing runtime but memory sucks 



searching some java doubts/syntax online in google cuz i havent come across those in the one week i have been doing java
so with time , ig i wont do that too







------------------------------------------------


CHATGPT SUMMARY OF LOG -

# 🚀 DSA Lock-In — Day 8 (April 1)

📅 Date: 1 April 2026

---

## 🔥 Focus of the Day

Starting LeetCode + Real Problem Solving

---

## 🧠 Problem 1 — Two Sum

### Initial Thought (Brute Force)

```java
// O(n^2)
for (int i = 0; i < nums.length; i++) {
    for (int j = 0; j < nums.length; j++) {
        if (nums[i] + nums[j] == target && i != j) {
            return new int[]{i, j};
        }
    }
}
```

### Insight

👉 For each number `x`, we need to find `target - x`

This becomes a **search problem**

---

### 💡 Optimization Idea

Can we make search faster?

👉 Use **HashMap**

---

### Final Approach

* Store `(value → index)`
* For each element:

  * check if `target - value` exists

---

### Final Code

```java
HashMap<Integer,Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    map.put(nums[i], i);
}

for (int i = 0; i < nums.length; i++) {
    int required = target - nums[i];
    if (map.get(required) != null && map.get(required) != i) {
        return new int[]{i, map.get(required)};
    }
}
```

---

### 🧠 Key Learning

* HashMap is not just for frequency
* It can be used for **O(1) lookup**
* Problem reduced from:

  * O(n²) → O(n)

---

## 🧠 Problem 2 — Valid Palindrome

### Initial Approach

* Remove non-alphabet characters
* Compare string using two pointers

---

### Bug Faced

```text
Input: "0P"
```

👉 I ignored digits → wrong output

---

### 🔍 Fix

Used:

```java
Character.isDigit(c)
```

---

### Final Logic

* Keep only:

  * letters OR digits
* convert to same case
* apply two pointers

---

### ⚠️ Performance Issue

```text
Runtime: 129ms (very slow)
```

👉 Reason:

```java
cleaned = cleaned + c;
```

This creates new string every time → O(n²)

---

### 🧠 Key Learning

* Strings are immutable in Java
* Use `StringBuilder` for efficiency

---

## 🧠 Problem 3 — Contains Duplicate

### Approach 1 — HashMap

* store elements
* check if already exists

---

### Better Approach — HashSet

```java
if (!set.add(nums[i])) {
    return true;
}
```

---

### 💡 Insight

👉 `set.add()` returns false if element already exists

---

### Final Result

```text
Runtime: 10ms (🔥)
```

---

## 🧠 Key Learnings Today

### 🔥 1. HashMap is a Search Tool

Not just frequency counter

---

### 🔥 2. Pattern Recognition Started

* Two Sum → complement pattern
* Palindrome → two pointers
* Duplicate → set detection

---

### 🔥 3. Edge Cases Matter

* "0P" completely changed logic

---

### 🔥 4. Real Debugging Started

* Used discussion tab properly
* Didn’t blindly copy
* Understood WHY things fail

---

## ⚠️ Mistakes

* Overused String concatenation → slow
* Initially ignored digits
* Slight confusion on optimal structures

---

## 📈 Progress Check

👉 First proper LeetCode day
👉 Solved problems with real understanding
👉 Started thinking in patterns

---

## ⚡ Final Thought

Today felt like:

👉 “I can actually solve LeetCode problems”

And that’s a big shift.


⚡ Mentor Feedback (important)
🔥 What impressed me
You didn’t panic on bugs
You investigated (0P case)
You explored discussions smartly

⚠️ What to improve (very important)
1. Stop brute forcing too long

You stayed too long in brute force mindset in Two Sum.

👉 Train yourself to ask:

“Can I reduce this to lookup?”

2. Performance awareness

You saw 129ms but didn’t immediately fix it.

👉 Next step:

always ask why slow?

3. Clean thinking before coding

Some parts:

trial → debug → fix

👉 We want:

think → code → minimal debug

🔥 Final Verdict

👉 You are now officially:

“LeetCode beginner → moving towards intermediate”