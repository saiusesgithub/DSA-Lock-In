12 04 2026

did java basics and solved 10 patterns in strivers A2Z dsa sheet (figure out/plan a way in which i can learn something in striver sheet theory and do problems related to that on that day)
so searched for patterns in Leetcode ,
didn't get those kinda patterns but found this question - 

290. Word Pattern - Easy

came up with this solution initially - 
```java
// class test {
//    static boolean wordPattern(String pattern, String s) {
//        String[] strList = s.split(" ");
//        HashMap<Character,String> map = new HashMap<>();
//
//        if (strList.length != pattern.length()) {
//            return false;
//        }
//        for (int i =0;i<pattern.length();i++) {
//            if ( map.containsKey(pattern.charAt(i))) {
//                if (!(map.get(pattern.charAt(i)).equals(strList[i]))) {
//                    return false;
//                }
//            }
//            else {
//                map.put(pattern.charAt(i) , strList[i] );
//            }
//        }
//        return true;
//
//    }
```
but was having some error , looked at discussion (some one mentioned use another hashmap to check bi directional something)

so did this ( searched a lot of stuff on google like core java syntax like how to find out size of hashmap in java etc and came up with this (pasted code into IntelliJ Idea and did a lot of 
debugging )
```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strList = s.split(" ");
        HashMap<Character,String> map = new HashMap<>();

        if (strList.length != pattern.length()) {
            return false;
        }

        for (int i =0;i<pattern.length();i++) {
            if ( map.containsKey(pattern.charAt(i))) {
                if (!(map.get(pattern.charAt(i)).equals(strList[i]))) {
                    return false;
                }
            }
            else {
                map.put(pattern.charAt(i) , strList[i] );
            }
        }

        HashMap<String,Integer> map2 = new HashMap<>();
        for (String value : map.values()) {
            if (map2.containsKey(value)) {
                return false;
            }
            else {
                map2.put(value,1);
            }
        }
        return true;
    }
}
```
Runtime
1ms
Beats82.87%
Memory
42.96MB
Beats24.13%

-------------------------------------------------------------------------------------------------------------------------------------------

3285. Find Indices of Stable Mountains - Easy
```java
class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1;i<height.length;i++) {
            if (height[i-1] > threshold) {
                list.add(i);
            }
        }
        return list; 
    }
}
```
Runtime
1ms
Beats100.00%
Memory
45.87MB
Beats61.06%

-------------------------------------------------------------------------------------------------------------------------------------------


3264. Final Array State After K Multiplication Operations I - Easy
```java
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        for (int i =0;i<k;i++)  {
            int lowIndex=0;
            for (int j =0;j<nums.length;j++) {
                if (nums[j] < nums[lowIndex]) {
                    lowIndex = j;
                }
            }
            nums[lowIndex] = nums[lowIndex] * multiplier;
        }
        return nums;
    }
}
```
Runtime
1ms
Beats100.00%
Memory
46.69MB
Beats83.29%

-------------------------------------------------------------------------------------------------------------------------------------------


1496. Path Crossing - Easy
```java
class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<List<Integer>> set = new HashSet();
        int x = 0;
        int y = 0;
        ArrayList<Integer> initial = new ArrayList<>(Arrays.asList(0,0));
        set.add(initial);
        for (int i =0;i<path.length();i++) {
            switch(path.charAt(i)) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'W':
                    y--;
                    break;
                case 'E':
                    y++;
                    break;
            }
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(x,y));
            if (!set.add(list)) {
                return true;
            }
        }
        return false;   
    }
}
```
Runtime
1ms
Beats99.41%
Memory
43.32MB
Beats75.78%


while writing , thought not the best solution and need to optimise it more (use simpler data structures rather than arraylist etc but damn)

-----------------------------------------------------------------------------------------------------------

