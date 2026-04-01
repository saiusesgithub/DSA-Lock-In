import java.util.HashMap;

public class Day7Practice {

    // https://youtube.com/shorts/jku7OJ6uA68?si=TgWlNkImPh5oh1Sm
    // https://youtube.com/shorts/jLBMVvJlYDQ?si=m6KdgQaR5MaJfl_D

    // move zeroes to end problem
    // 2 pointers , i (keeps track of index) , j (keeps track of where next non zero element should go)
    // loop through elements  , initially i =0;j=0
    // if zero -> do nothing (i++ automatically)
    // if non-zero -> place arr[i] at arr[k]  , k++
    // after the loop ends , all the elements from k are zeroes , so use another loop and set
    void moveZeroes(int arr[]) {
        int k=0;
        for (int i = 0;i<arr.length;i++) {
            if (arr[i] != 0) {
                arr[k] = arr[i];
                k++;
            }
        }
        for (int j=k;j<arr.length;j++) {
            arr[j] = 0;
        }
    }


    // first non-repeating character
    // create a hashmap using loop
    // loop through the string order through the hashmap
    // return index of first key where value = 1; if none then return -1;

    int firstUniqueCharacter(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i =0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                int currentValue = map.get(s.charAt(i));
                map.put(s.charAt(i),currentValue+1);
//              map.compute(s.charAt(i), (k, currentValue) -> currentValue + 1); - simpler way
            }
            else {
                map.put(s.charAt(i),1);
            }
        }
        for (int i =0;i<s.length();i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    boolean isAnagram(String a,String b){

        if (a.length() != b.length()) {
            return false;
        }

        HashMap <Character,Integer> map = new HashMap<>();
        for (int i =0;i<a.length();i++) {
            if (map.containsKey(a.charAt(i))){
                int value = map.get(a.charAt(i));
                map.put(a.charAt(i),value+1);
            }
            else {
                map.put(a.charAt(i),1);
            }
        }

        for (int i =0;i<b.length();i++) {
            char key = b.charAt(i);
            int value = map.get(key); // missed edge case - what if key is not in map itself? -> if (!map.containsKey(key)) return false;
            value --; // I should decrement before checking
            if (value < 0) {
                return false;
            }
            map.put(key,value);

        }
        return true;
    }
}
