public class Day6Practice {
    static int[] reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0 ; i<arr.length/2;i++) { // shortcut - while(start<end)
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        for (int i = 0 ; i<str.length()/2;i++) { //while(start<end) - no need of extra variable i
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
