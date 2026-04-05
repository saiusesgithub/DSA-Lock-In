05042026

657. Robot Return to Origin - Easy (Problem of the day)

initial solution - 

class Solution {
    public boolean judgeCircle(String moves) {
        int initialXCord = 0;
        int initialYCord = 0;
        int XCord = 0;
        int YCord = 0;
        for (int i =0;i<moves.length();i++) {
            if (moves.charAt(i) == 'U') {
                YCord++;
            }
            else if (moves.charAt(i) == 'D') {
                YCord--;
            }
            else if (moves.charAt(i) == 'L') {
                XCord--;
            }
            else if (moves.charAt(i) == 'R') {
                XCord++;
            }
        }
        if (XCord == initialXCord && YCord == initialYCord) {
            return true;
        }
        return false;
    }
}

Runtime
8ms
Beats24.19%
Memory
45.68MB
Beats65.59%


then tried something like this -

if ((moves.equals("UD")) || (moves.equals("DU")) || (moves.equals("LR")) || (moves.equals("RL"))) {
            return true;
        }
return false;

but failed this test case -> moves = "RLUURDDDLU"

tried this , a little better - 

class Solution {
    public boolean judgeCircle(String moves) {
        int initialXCord = 0;
        int initialYCord = 0;
        int XCord = 0;
        int YCord = 0;
        for (int i =0;i<moves.length();i++) {
            switch(moves.charAt(i)) {
                case 'U':
                    YCord++;
                    break;
                case 'D':
                    YCord--;
                    break;
                case 'L':
                    XCord--;
                    break;
                case 'R':
                    XCord++;
                    break;
            }
        }
        if (XCord == initialXCord && YCord == initialYCord) {
            return true;
        }
        return false;
    }
}

Runtime
6ms
Beats49.49%
Memory
45.60MB
Beats75.15%


came up with this (even worse man ;-;) - 

class Solution {
    public boolean judgeCircle(String moves) {
        int L = 0;
        int R = 0;
        int U = 0;
        int D = 0;
        for (int i =0;i<moves.length();i++) {
            switch(moves.charAt(i)){
                case 'L':
                L++;
                break;
                case 'R':
                R++;
                break;
                case 'U':
                U++;
                break;
                case 'D':
                D++;
                break;
            }
        }
        if (L == R && U==D) {
            return true;
        }
        return false;
    }
}

Runtime
6ms
Beats49.49%
Memory
45.70MB
Beats57.48%


came across this in discussions - 
Much easiest way, just count 2 variables x and y with increment and decrement, depending on operation so in this case result is true if x and y are both 0, otherwise it's false.

class Solution {
    public boolean judgeCircle(String moves) {
        int X = 0;
        int Y = 0;
        for (int i =0;i<moves.length();i++) {
            switch(moves.charAt(i)){
                case 'L':
                Y--;
                break;
                case 'R':
                Y++;
                break;
                case 'U':
                X++;
                break;
                case 'D':
                X--;
                break;
            }
        }
        if ( X==0 && Y==0) {
            return true;
        }
        return false;
    }
}

Runtime
5ms
Beats68.18%
Memory
45.75MB
Beats57.48%

ChatGpt reflection - 
PROMPT - i am doing leetcode , DONT GIVE DIRECT ANSWER , just hints - (how can i optimise this more)


First Reality Check
All your solutions are already O(n) → you’re looping once → optimal time complexity

👉 so don’t chase “better algo” here
👉 focus on cleaner / tighter implementation

after chatgpt hints - 

class Solution {
    public boolean judgeCircle(String moves) {
        int X = 0;
        int Y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U' || c == 'D') {
                X+= ( c == 'U' ? 1 : -1);   
            }
            else {
                Y+= ( c == 'R' ? 1 : -1);
            }
        }
        return (X==0 && Y==0);
    }
}

Runtime
5ms
Beats68.18%
Memory
46.24MB
Beats25.09%

bruh became worse

Reason 1 — toCharArray() cost (BIG one)
for (char c : moves.toCharArray())

👉 this creates a new array in memory

copies entire string → O(n)
extra memory allocation
garbage collection later

Reason 3 — runtime noise

LeetCode runtime:

5ms vs 6ms vs 8ms
👉 mostly noise / JVM variance

don’t overthink small ms differences


did this - 
class Solution {
    public boolean judgeCircle(String moves) {
        int X = 0;
        int Y = 0;
        for (int i =0;i<moves.length();i++) {
            char c = moves.charAt(i);
            if (c == 'U' || c == 'D') {
                X+= ( c == 'U' ? 1 : -1);   
            }
            else {
                Y+= ( c == 'R' ? 1 : -1);
            }
        }
        return (X==0 && Y==0);
    }
}

Runtime
7ms
Beats30.80%
Memory
45.67MB
Beats65.59%


BRUH I am ruining the problem even more 
enough man , spending too much time on this 

--------------------------------------------------------------


283. Move Zeroes - Easy

initial implementation (cuz i already did very similar problem, done easily) 

class Solution {
    public void moveZeroes(int[] nums) {
        int current =0;
        int nextNonZero = 0;
        while (current < nums.length) {
            if (nums[current] == 0) {
                current++;
            }
            else {
                nums[nextNonZero] = nums[current];
                current++;
                nextNonZero++;
            }
        }
        for (int i =nextNonZero ; i < nums.length;i++) {
            nums[i] = 0;
        }
        
    }
}

Runtime
2ms
Beats91.01%
Memory
47.45MB
Beats94.50%

---------------------------------------------------------------

242. Valid Anagram - Easy


kinda did this while learning java 
so came up with some random solution - 

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), value+1);  
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int j = 0;j<t.length();j++) {
            if (!map.containsKey(t.charAt(j))) {
                return false;
            }

            if ( map.get(t.charAt(j)) != 1 ) {
                return false;
            }
        }
        return true;
    }
}

then remembered nah nah nah , 
I gotta loop through the second string and decrement that character value in the hashmap , if each character value in hashmap is 0 after looped through string2 , then its an anagram


solution (works but not optimised) -

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), value+1);  
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int j = 0;j<t.length();j++) {
            if (!map.containsKey(t.charAt(j))) {
                return false;
            }
            int value1 = map.get(t.charAt(j));
            value1 = value1 -1;
            map.put(t.charAt(j),value1);
        }

        for (int k = 0;k<s.length();k++) {
            if(map.get(s.charAt(k)) != 0) {
                return false;
            }
        }
        return true;
    }
}

Runtime
26ms
Beats5.48%
Memory
47.39MB
Beats6.45%

added this small improvement - 

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), value+1);  
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int j = 0;j<t.length();j++) {
            if (!map.containsKey(t.charAt(j))) {
                return false;
            }
            int value1 = map.get(t.charAt(j));
            value1 = value1 -1;
            map.put(t.charAt(j),value1);

            if (value1 < 0) {
                return false;
            }
        }

        for (int k = 0;k<s.length();k++) {
            if(map.get(s.charAt(k)) != 0) {
                return false;
            }
        }
        return true;
    }
}

Runtime
22ms
Beats7.37%
Memory
47.28MB
Beats6.45%

nah bro

asked chatgpt how to improve time and space complexity -> (no solution , I am doing Leetcode , just hints)

good news first: your time complexity is already O(n) ✅
you can’t asymptotically improve beyond that for this problem


HINTS (chatgpt) - 

You’re using HashMap

👉 but what is the constraint?

characters are lowercase a–z

💡 hint:

fixed size = 26
do you really need hashing?


after looking at the array hint (only hint , not direct solution) , came up with this -> 

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        for (int i =0;i<s.length();i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }
        for (int j =0;j<t.length();j++) {
            int index1 = t.charAt(j) - 'a';
            arr[index1]--;
        }
        for (int k =0;k<arr.length;k++) {
            if (arr[k] != 0) {
                return false;
            }
        }
        return true;
    }
}

Runtime
4ms
Beats82.17%
Memory
44.20MB
Beats92.25%

okkk so no of loops wasn't the problem


looked at solutions of other people , as we are using arrays , no need of 2 loops for string1 and string2 , both actions can be performed at same time cuz entire array is accessible 

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i =0;i<s.length();i++) {
            int index1 = s.charAt(i) - 'a';
            arr[index1]++;

            int index2 = t.charAt(i) - 'a';
            arr[index2]--;
        }
        for (int k =0;k<arr.length;k++) {
            if (arr[k] != 0) {
                return false;
            }
        }
        return true;
    }
}

Runtime
6ms
Beats43.31%
Memory
44.11MB
Beats92.25%


WHY DID RUNTIME BECOME WORSE

asked chatgpt ->

LeetCode timing noise

This is actually very important:

👉 4ms vs 6ms is NOT meaningful

Different runs = different servers
JVM warmup differences
Background load

💥 On another submission, your second code might show 3ms

both solutions are O(n)

---------------------------------------------------------------------

practice dry runs
more patterns
learn about time and space complexity
look at others problems



man not spending enough time on book and paper , switching directly to problems bruh
----------------------------------------------------------------------------




came up with this slop - 

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0;i<nums1.length;i++) {
            
            if (map.containsKey(nums1[i])) {
                int value = map.get(nums1[i]);
                map.put(nums1[i],1);
            }
            else {
                map.put(nums1[i],1);
            }
        }
        HashSet set = new HashSet();

        for (int j =0;j<nums2.length;j++) {
            if (map.containsKey(nums2[j])) {
                set.add(nums2[j]);
            }
        }
        int size = set.size();
        int[] arr = new int[size];
        int p  = 0;
        for (int i : set) {
            arr[p] = i;
            p++;
        }
        return arr;
    }
}


i dont even need a hashmap here

// left in between
// i am getting so stressed man
// my brain isn't working properly 
// i am getting anxiety and demotivation and stress cuz i am not able to do easy questions

also left this in between -> 2. Add Two Numbers

also searching for syntax in google man (AND NOT NOTING DOWN WHAT I SEARCHED FOR , LIKE NOT WRITING DOWN STUFF IDK / I FORGOT)

---------------------------------------------------------------

but as i reflect upon it now
people spend years on DSA

man some people started in their 1st year itself and didn't stop

should i have started in my first year
actually

no
i dont regret not starting

cuz if i only focused on dsa
i would miss exploring all these technologies and all these projects etc
:>

but from now on , lock in (alongside main domain)




