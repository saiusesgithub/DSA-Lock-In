import java.util.*;

public class Day2Practice {
    public static void main(String[] args) {
        System.out.println("No. Of Elements in ArrayList: ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Element " + i + ":");
            list.add(sc.nextInt());
            sum += list.get(i);
        }
        System.out.println("Sum: " + sum);

        System.out.println("List after all even elements removed: ");
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.get(i) % 2 != 0) {
                oddList.add(list.get(i));
            }
        }

        // Improvement by ChatGPT , I was supposed to remove even elements from the arraylist
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 !=0) {
//                list.remove(i);
//                i--;   // adjust
//            }
//        }
//        Internally: it shifts all elements left (No gaps left) ,
//        we are just adjusting i-- for the loop so it doesn't miss any indices
        sc.nextLine();
        System.out.print("Input String: ");
        String str = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println("HashMap: ");
        for (char key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        for (char key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println("first non-repeating character: " + key);
                break;
            }
        }

        // PROBLEM - HashMap is unordered
//        input - aabccd
//        Map may store:
//        c → 2
//        a → 2
//        d → 1
//        b → 1
//
//        Your code may print: d
//        instead of: b
//
//        Fix - loop through string again
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (map.get(c) == 1) {
//                // this is correct answer
//            }
//        }

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        boolean isAnagram = true;
        for (int i = 0 ; i < str1.length();i++) {
            char key = str1.charAt(i);
            if(map1.containsKey(key) ) {
                map1.put(key, map1.get(key) + 1);
            }
            else {
                map1.put(key,1);
            }
        }
        for (int i = 0 ; i < str2.length();i++) {
            char key = str2.charAt(i);
            if(map2.containsKey(key) ) {
                map2.put(key, map2.get(key) + 1);
            }
            else {
                map2.put(key,1);
            }
        }

        if (str1.length() != str2.length()) {
            isAnagram = false;
        }

        for (char key1 : map1.keySet()) {
            if (map1.get(key1) != map2.get(key1)) { // bug - What if key not present in map2.get(key1) - returns null , crash or wrong comparision
                isAnagram = false;
                break;
            }
        }

        System.out.println(isAnagram? "Anagram" :"Not Anagram" );

        // ChatGPT Improvements (In Anagram Program)
//        compare safely -
//        for (char key : map1.keySet()) {
//            if (!map2.containsKey(key)) → not anagram
//            if (map1.get(key) != map2.get(key)) → not anagram
//        }
        // Use a flag to keep track
        // boolean isAnagram = true;

        int[] arr = {2,15,2,3,5,6,11,11,11};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < arr.length;  i++) {
            set.add(arr[i]);
        }
        System.out.println("No Duplicates Set :" + set);
 // how to access elements in hashset??

        System.out.println(arr.length != set.size() ? "Array Has Duplicates" : "Array Doesn't Duplicates");

        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0 ; i < arr.length;i++) {
            if (seen.contains(arr[i])) {
                System.out.println("first repeating element :" + arr[i]);
                break;
            }
            else {
                seen.add(arr[i]);
            }
        }
    }
}
