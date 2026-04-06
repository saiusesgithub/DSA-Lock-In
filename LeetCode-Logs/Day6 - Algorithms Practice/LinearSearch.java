public class LinearSearch {
    public static void main() {
        int[] arr = {2,5,1,6,2};
        int target = 42;
        int index = LinearSearch(arr,target);
        if (index == -1) {
            System.out.println("Element Not Found");
        }
        else {
            System.out.println("Element found at: "+ index);
        }
    }

    static int LinearSearch(int[] arr, int target) {
        for (int i =0;i<arr.length;i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }

}
