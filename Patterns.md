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
