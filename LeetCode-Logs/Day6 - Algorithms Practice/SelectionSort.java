public class SelectionSort {
    // Time Complexity - O(n²) - No matter what → always checks everything

    // Selection Sort -> loop through the elements , find the smallest element
    // place them in the start (swap) , continue looping from next element
    // [5,9,1,7] , look from index 0 to 3 -> smallest = 1
    // [1 | 9,5,7] , 0 index is sorted , look from 1 to 3 -> smallest = 5
    // [1,5 | 9,7] , until 1 index is sorted , look from 2 to 3 -> smallest = 7
    // [1,5,7 | 9] , 9 is smallest , place it at 3 (loop is sorted)

    static void SelectionSort (int[] arr) {
        for (int i = 0;i<arr.length;i++) {
            int lowIndex = i;
            for (int j= i;j<arr.length;j++) {
                if (arr[j] < arr[lowIndex]) {
                    lowIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[lowIndex];
            arr[lowIndex] = temp;
        }
    }

    // Improvements (BY CHATGPT)
    // Inner loop can start from i+1  (if not , you will be comparing arr[i] with itself
    // Smallest element already in place (no need to swap)
    // if (lowIndex != i) {
    //    swap
    // }

    public static void main(String[] args) {
        int[] arr = {5,9,1,7};
        SelectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

// REVERSE SORTING


