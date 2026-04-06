public class BubbleSort {
    // Time Complexity -
    // Worst Case - O(n²)
    // Average Case - O(n²)
    // Best Case - O(n) -> Optimised BubbleSort

    // Bubble Sort
    // repeatedly compare adjacent elements and swap if they are in wrong order
    // After each pass, the largest element moves ("bubbles up") to its correct position at the end

    // [5,9,1,7] , compare adjacent elements:

    // Pass 1:
    // (5,9) ok → [5,9,1,7]
    // (9,1) swap → [5,1,9,7]
    // (9,7) swap → [5,1,7,9]
    // → 9 is now sorted
    // [5,1,7 | 9]

    // Pass 2:
    // (5,1) swap → [1,5,7,9]
    // (5,7) ok → [1,5,7,9]
    // → 7 is now sorted
    // [1,5 | 7,9]

    // Pass 3:
    // (1,5) ok → [1,5,7,9]
    // → already sorted
    // [1 | 5,7,9]

    // Final sorted array:
    // [1,5,7,9]

    // Improvements by ChatGPT -
    // Reduce inner loop range
    // After each pass, the last i elements are already sorted.
    // j < arr.length - i - 1
    // lets say i = 1 -> last element sorted , go until length-1;

    // simple bubble sort (compares sorted elements too)
    static void BubbleSort(int[] arr) {
        for (int i =0;i<arr.length;i++) {
            for (int j = 0 ; j<arr.length-i-1;j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }



    static void OptimisedBubbleSort(int[] arr) {
        boolean swapped = false;

        for (int i =0;i<arr.length;i++) {
            for (int j = 0; j<arr.length-1;j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // if no swaps happened (in the first traversal) then already sorted
            if (swapped == false) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {4,8,1,3};
        OptimisedBubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}

// REVERSE SORTING