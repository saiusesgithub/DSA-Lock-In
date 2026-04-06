public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 25;
        int index = BinarySearch(arr,0,arr.length-1,target);
        System.out.println(index);

    }

    static int BinarySearch(int[] arr , int start, int end , int target) {
        // element not found case
        // if the element is not present, the range becomes invalid:
        // start crosses end  -> we get StackOverflow error

//        Example (target NOT found)
//        [1, 2, 3, 4, 5]
//        target = 10
//
//        Steps:
//        start=0, end=4 → mid=2 → 3 < 10 → go right
//        start=3, end=4 → mid=3 → 4 < 10 → go right
//        start=4, end=4 → mid=4 → 5 < 10 → go right
//        start=5, end=4 → ❗ start > end
//        Now we STOP and return -1

        if (start > end) {  // missed this edge case
            return -1;
        }
        int midIndex = (start+end) / 2;  // forgot () here -> had precedence issues

        if (arr[midIndex] == target) {
            return midIndex;
        }
        else if (target < arr[midIndex]) {
            return BinarySearch(arr,start,midIndex,target);
        }
        else {  // (target > arr[midIndex])
            return BinarySearch(arr,midIndex+1,end,target);
        }
    }
}
