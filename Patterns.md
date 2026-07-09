# Pattern 1 : Fixed-Size Frequency Array

Use this when the input range is small and fixed.

Examples:

- lowercase letters `a-z`
- uppercase letters `A-Z`
- digits `0-9`

## Idea

Instead of using a HashMap, use an array where each index represents one possible value.

```java
int[] freq = new int[26];
int index = ch - 'a';
freq[index]++;
```

Space Complexity -
Hashmap - O(n)
Array - O(1)

+ array implementation faster than hashmap because array operations are faster and lighter than hashamp operations


---

---

PATTERN - 

# Pattern: Two Pointers from Both Ends

Use when comparing elements from start and end.

Common use cases:
- palindrome check
- pair sum in sorted array
- reverse array/string

Logic:
left = 0
right = n - 1

while left < right:
    move left/right based on condition


---

---

pattern 

# Pattern: Two Pointers (Same Direction)

Use when rearranging or filtering an array while preserving relative order.

Idea:

- One pointer scans the array.
- The other pointer marks where the next valid element should be placed.

Examples:

- Move Zeroes
- Remove Duplicates from Sorted Array
- Remove Element
- Partition-type problems

Complexity:

Time: O(n)
Space: O(1) 