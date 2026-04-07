
    // sliding window = a sub array that shrinks/grows
    // instead of checking every sub array (brute force , we maintain one window and adjust it)

    // left pointer -> start of window
    // right pointer -> end of window

    // expand -> move right
    // shrink -> move left

    // when do you shrink -> when your condition breaks

    // fixed window -> window size = constant (subarray of size k)
    // keep expanding right
    // if window size > k → shrink left

    // variable window -> (longest substring without repeating characters)
    // keep expanding right
    // if condition breaks , shrink left until condition valid again

    // expand–break–shrink cycle = sliding window
    // ADD → check → if invalid → SHRINK until valid

    // TEMPLATE -
    //    for (right = 0 → n):
    //    add element to window
    //
    //    while (window invalid):
    //    remove from left
    //    left++

    //    update answer

    //use sliding window when:
        //subarray / substring problem
        //continuous segment
        //you need:
        //max / min / count / length / sum


// dry run -> "abcabcbb"
// window          start    end     what-did-i-remove-now   valid?
// a               0        0       X                        Yes
// ab              0        1       X                        Yes
// abc             0        2       X                        Yes
// abca            XXXXX            a (duplicate)
// bca             1        3       X                        Yes
// bcab            XXXXX            b (duplicate)
// cab             2        4       X                        Yes
// cabc            XXXXX            c
// abc             3        5       X                        Yes
// abcb            XXXXX            a (b - duplicate)
// bcb             XXXXX            b
// cb              5        6       X                        Yes
// cbb             XXXXX            c (b - duplicate)
// bb              XXXXX            b
// b               7        7       X                        Yes


// dry run -> [2,1,5,1,3,2] with k=3
// window    start    end     what-did-i-remove-now     valid?
// 2         0        0
// 21        0        1
// 215       0        2
// 2151      0        3      remove 2 cuz window > k    NO
// 151       1        3
// 1513      1        4      remove 1 cuz window > k    NO
// 513       2        4
// 5132      2        5      remove 5 cuz window > k    NO
// 132       3        5


// EXAMPLE - maximum sum among all windows of size k


// ❌ BRUTE FORCE (what you’d normally do)
    //for every window:
    //calculate sum again
    //[2,1,5] → sum = 8
    //[1,5,1] → sum = 7
    //[5,1,3] → sum = 9
    //[1,3,2] → sum = 6
//👉 recalculating every time → waste

//✅ SLIDING WINDOW MAGIC
//👉 instead of recalculating
//new_sum = old_sum - element leaving window + element entering window

import java.util.Collections;
import java.util.HashSet;
import java.lang.Math;
import java.util.HashMap;

    public class SlidingWindow {
    public static void main(String[] args) {
        char[] str = {'a','b','b','a'};
        System.out.println(LongestRepeatingCharacterReplacement(str,1));
    }

    static int LongestSubStringWithoutDuplicates(char[] string) {
        // ['a','b','c','a','b','a']
        // Longest Substring Without Repeating Characters
        // Data structure
        // you said: array / hashmap (correct)
        // BUT for this problem: best = HashSet (or map if needed)
        // why? - we only care about existence (duplicate or not) , not frequency

        // use set
        //expand right:
        //    if char not in set → add
        //
        //    if char already in set → duplicate:
        //        shrink until valid (remove from left)
        //
        //update max length
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int longest = 1;
        int currentLength;
        if (string.length == 0) {
            return 0;
        }

        while (end < string.length) {
            while (set.contains(string[end])) {
                set.remove(string[start]);
                start++;
            }
            set.add(string[end]);
            currentLength = end - start + 1;
            longest = Math.max(currentLength, longest);
            end++;
        }
        return longest;

        // my initial solution -
//  static int LongestSubStringWithoutDuplicates(char[] string) {
//    HashSet<Character> set = new HashSet<>();
//    int start = 0;
//    int end = 0;
//    int longest = 1;
//
//    while (end < string.length) {
//        end++;
//        longest++;
//        // if duplicate is inserted/expanded
//        //      then keep shrinking until no duplicate
//        if () {
//            while () {
//                start++;
//                longest--;
//            }
//        }
//    }
//}



// HINT 1 — your loop order is off
//    you did:
//    end++;
//    longest++;
// when do you actually “see” the character?
//👉 you should:
//  * FIRST process `string[end]`
//  * THEN move `end`

// HINT 2 — what triggers shrinking?

//you left:
//if () {
//        while ()

//when is window invalid?
//
// you already answered this earlier - if (???? already exists in set)


//HINT 3 — shrinking logic
//    inside while:

//    start++;
//    longest--;
//
// missing the MOST important step
// what must happen to the set when I shrink?

// HINT 4 — longest variable mistake

//    you are doing:
//    longest++;
//    longest--;
//    this is wrong approach ❌
//
//    don’t track like this
//    👉 think:
//    current length = end - start + 1
//    longest = max(longest, current length)


//  HINT 5 — order of operations (very important)
//    inside loop:
//1. check if char exists
//2. if yes → shrink
//3. then add char
//4. update answer

// 🔥 FIRST — BIG BUG
//you wrote:
//if (!set.add(string[end])) {
//👉 ⚠️ set.add() already ADDS the element
//
//so:
//if it returns false → element is already there
//BUT you just tried to add it again

// HINT 3 — what to do while shrinking?
//    you wrote:
//            while () {
//    start++;
//    longest--;
//            }

//    what must I REMOVE from the window?
//    string[start]
//   so -
//    remove from set
//    then move start

// correct mental order:
// while (end < n):
//    if duplicate:
//        shrink until valid
//    add current char
//    update answer
//    move end

//❌ BUG (IMPORTANT)
//
//    currentLength = end - start + 1;
//
//    problem: you already did end++
//
//    so you’re calculating length with future index

//⚠️ SECOND ISSUE
//
//    you initialized:
//    int longest = 1;
//
//👉 edge case:
//    what if string is empty?

    }

    static int LongestSubStringWithoutDuplicates_withoutSeeingPractice(char[] string) {
        int start = 0;
        int end = 0;
        int longest = 1;
        int currentLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (end < string.length) {
            while(set.contains(string[end])) {
                set.remove(string[start]);  // mistake - used string[end]
                start++;
            }
            set.add(string[end]);
            // wrote this - longest = end - start + 1;
            // but currentLength = end - start + 1;
            currentLength = end - start + 1;
            longest = Math.max(currentLength,longest);
            end++;
        }
        return longest;
    }

    static int LongestRepeatingCharacterReplacement(char[] string,int k) {
        // spent way too much time on this , no hints except the below condition
        // invalid condition -> window_length - max_frequency > k
        // WORKS but not Optimised
        int start = 0;
        int end = 0;
        int window_length = 1;
        int longest = 1;
        int maxFreq = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        while(end < string.length) {

            if (map.containsKey(string[end])) {
                int value = map.get(string[end]);
                map.put(string[end] , value+1 );
            }
            else {
                map.put(string[end],1);
            }
            window_length = end - start + 1;
            maxFreq = Collections.max(map.values());

            while ( (window_length - maxFreq) > k) {
                int value = map.get(string[start]);
                map.put(string[start] , value-1 );
                start++;
                window_length = end - start + 1;
        //    maxFreq = Collections.max(map.values()); - no need to do this inside the loop
            }

            longest = Math.max(window_length , end);
            end++;
        }
        return longest;

        // ChatGPT Optimizations / Improvements -

//        ❌ ISSUE 1 — Collections.max(map.values())
//        maxFreq = Collections.max(map.values());
//
//        👉 inside loop
//        👉 AND inside shrink loop
//        ❌ this makes your solution O(n²)
//
//        we DON’T recompute maxFreq every time
//👉 update maxFreq ONLY when expanding:
//        maxFreq = max(maxFreq, freq of current char)


//❌ ISSUE 2 — WRONG longest UPDATE
//
//        longest = Math.max(window_length , end);
//
//👉 ❌ why are you comparing with end?
//
//👉 answer is ALWAYS based on:
//
//        window_length
//        NOT index

    }
}



