import java.util.*;

public class Day1Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // PROBLEM 1
        System.out.print("Size Of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Sum Of Array: ");
        int sum = 0;
        for (int i =0;i<n;i++) {
            sum+=arr[i];
        }
        System.out.println(sum);

        System.out.print("Avg Of Array: ");
        double avg = (double)sum/n;
        System.out.println(avg);

        // PROBLEM 2 (second-largest element)
        int max = arr[0];
        int second_max = max;

        // My Initial Implementation
//        for (int i =0;i<n;i++) {
//            if (arr[i] > max) {
//                second_max = max;
//                max = arr[i];
//            }
//        }
//        Problem - If all elements same → wrong ,
//        If decreasing array → wrong (You NEVER update second_max unless new max appears)

        // ChatGPT Suggestion
        for (int i =0;i<n;i++) {
            if (arr[i] > max) {
                second_max = max;
                max = arr[i];
            }
            else if (arr[i] < max && arr[i] > second_max) {
                second_max = arr[i];
            }
        }
        System.out.println("Second Largest Element: "+second_max);

        // what does this mean? - int second_max = Integer.MIN_VALUE;


    }

    // Improvements -> size param = redundant (we already have arr.length)
    int sum(int size, int[] arr) {
        int sum =0;
        for (int i =0;i <size;i++) {
            sum += arr[i];
        }
        return sum;
    }

    int max(int size, int[] arr) {
        int max =arr[0];

        // Improvement -> You’re looping from i = 0 - unnecessary compare with itself
        for (int i =0;i <size;i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }



    int vowels(String str) {
        int vowels = 0;
        for (int i =0 ; i < str.length() ; i ++) {
            char c = str.charAt(i);
            switch(c) {
                case 'A':
                    vowels++;
                    break;
                case 'E':
                    vowels++;
                    break;
                case 'I':
                    vowels++;
                    break;
                case 'O':
                    vowels++;
                    break;
                case 'U':
                    vowels++;
                    break;
                default:
            }
        }
        return vowels;
    }

    // ChatGPT Improvement (I thought of doing this first , but felt its gonna get messy
    // in fact , switch got messy tbh
//    char c = Character.toLowerCase(str.charAt(i));
//        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//        vowels++;
//    }

    boolean palindrome(String str) {
        for (int i = 0 ; i < str.length();i++)  {
            if ((str.charAt(i) != str.charAt(str.length()-i-1))){
                return false;
            }}
        return true;
    }

    // ChatGPT Improvements -
    // You loop till full length → unnecessary (half is enough)

//   for (int i = 0; i < str.length() / 2; i++)

//    Before loop (Preprocessing) :
//    str = str.toLowerCase();
//    str = str.replace(" ", "");

    // Can you do this?
//  str.charAt(i).toLowerCase()
//
//  👉 ❌ NO
//
//    Why:
//    charAt(i) → returns char (primitive)
//    primitives don’t have methods
//
// ✅ Correct way:
//    char c = Character.toLowerCase(str.charAt(i));
}

