02/04/2026

344. Reverse String - Easy


initially wrote this code directly - 
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        for (int k = 0; k < s.length; k++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

but the original string wasn't modifying


asked chatgpt with this prompt - 
DONT GIVE MY ANY SOLUTION , JUST HINTS TOWARDS SOLUTION ,, i am doing leetcode and original string isnt modiying

AND OMG , I missed an important bug 

when "i" reaches middle , at that point , all the elements are already reversed 
but currently my loop goes until length-1 , so elements are being reversed again giving me the original string

If you continue after crossing the middle, You are basically undoing previous swaps ->
a b c d
→ swap → d b c a
→ swap → d c b a
→ swap again → back towards original?

so did this and worked! - 
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        for (int k = 0; k < s.length/2; k++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

Runtime
0ms
Beats100.00% DAMMNNN!!! LETSGO!
Memory
48.26MB
Beats66.43%

alternative (chatgpt hint) - 
while(i <= j) loop also works


---------------------------------------------------------------------------



initial attempt (without returning the merged array as original array  - 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] arr = new int[m + n];
        if (m == 0) {
            arr = nums2;
            return;
        }
        if (n == 0) {
            arr = nums1;
            return;
        }
        for (int k = 0; k < m + n; k++) {
            if (nums1[i] <= nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                arr[k] = nums2[j];
                j++;
            }
        }

        for (int p = 0; p < arr.length; p++) {
            System.out.println(arr[p]);
        }

    }
}

second implemention cuz we shouldn't count trailing zeroes in array (should only consider size given by m or n) 

import java.util.*;
import java.lang.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] arr = new int[m + n];
        int[] updatedNums1 = Arrays.copyOfRange(nums1,0,m-1);
        int[] updatedNums2 = Arrays.copyOfRange(nums2,0,n-1);
        if (m == 0) {
            arr = updatedNums2;
            return;
        }
        if (n == 0) {
            arr = updatedNums1;
            return;
        }
        for (int k = 0; k < m + n; k++) {
            if (updatedNums1[i] <= updatedNums2[j]) {
                arr[k] = updatedNums1[i];
                i++;
            } else if (updatedNums1[i] > updatedNums2[j]) {
                arr[k] = updatedNums2[j];
                j++;
            }
        }

        for (int p = 0; p < arr.length; p++) {
            System.out.println(arr[p]);
        }

    }
}

but kept having arrayindexoutofbounds exception cuz  k = m+n
lets say all elements are small in array 1 than array 2 
array 1 index will reach m-1 , then it will go to m cuz smaller , so error


was spending too much time -> so looked at discussion tab and solutions tab 

most people aren't even using 2 pointer , they are just sorting 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}


was completely lost , didn't even understand chatgpt answer kinda 

but then somewhere in the discussions/solutions tab i saw 
people combining both arrays and then just sorting 


also had some confusion because didn't read the question properly 
like man ,  A LOT OF CONFUSION CAUSED CUZ DIDNT READ QUESTION PROPERLY	

did this - 

import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++) {
                nums1[i] = nums2[j];
                j++;
        }
        Arrays.sort(nums1);

    }
}


Runtime
4ms
Beats15.08%
Memory
43.64MB
Beats82.92%


in question-> Follow up: Can you come up with an algorithm that runs in O(m + n) time?

tbh i dont even know how to check time complexity of the current solution

WORK ON THIS AGAIN 

----------------------------------------------------------------------

977. Squares of a Sorted Array - Easy

directly did this - 
import java.util.Arrays;
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i<nums.length;i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

Runtime
10ms
Beats37.21%
Memory
47.91MB
Beats18.86%


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

i guess , the better way is to , loop through the elements , square the element and then place that in the correct place using sorting techniques (discussions said selection sort)

found this solution visualizer in disscussions - https://robertocannella-f5b4b.web.app/coding-challenges/sorted-squares
after understanding the two pointer solution from there , implemented this - 

import java.util.Arrays;
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length]; 
        for (int i = 0; i<nums.length;i++) {
            nums[i] = nums[i] * nums[i];
        }
        int j = 0;
        int k = nums.length-1;
        for (int l = nums.length-1 ; l >= 0;l--) {
            if (nums[j] >= nums[k]) {
                arr[l] = nums[j];
                j++;
            }
            else if (nums[j] < nums[k]) {
                arr[l] = nums[k];
                k--;
            }
        }
        return arr;
    }
}

Runtime
1ms
Beats99.99%
Memory
47.27MB
Beats70.74%


-------------------------------------------------------------------------






class Solution {
    public boolean isPalindrome(int x) {
        String reversed = "";
        int original = x;
        while (x > 0) {
            int lastDigit = x % 10;
            reversed = reversed + lastDigit;
            x = x / 10;
        }
        try {
            if (original == 0) {
                return true;
            }
            if (original == Integer.parseInt(reversed)) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

Runtime
17ms
Beats5.57%
Memory
46.76MB
Beats11.71%







class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int reversed = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            reversed = (reversed * 10) + lastDigit;
            x = x / 10;
        }
        try {
            if (original == 0) {
                return true;
            }
            if (original == reversed) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

Runtime
5ms
Beats79.84%
Memory
45.82MB
Beats80.70%



Big optimization (important 🚀)

You actually don’t need to reverse the entire number.

Ask yourself:

When checking palindrome, do I need all digits… or just compare halves?

This avoids overflow and is more efficient.

