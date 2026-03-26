import java.util.*;

public class Day2 {
    public static void main(String[] args) {
        // ArrayList (Dynamic array -resizable, Stores objects (not primitives → use Integer, not int)
        ArrayList<Integer> list = new ArrayList<>();

        // Operations on ArrayList
        list.add(10);
        list.get(0);
        list.set(0,20);
        list.remove(0);    // removes index , not value
        list.size();

        // HashMap
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('a', 1);        // insert/update
        map.get('a');           // get value
        map.containsKey('a');   // check
        map.remove('a');    // delete

        // IMPORTANT Pattern in HashMap (Frequency Counting)
        char c = 'a';
        if (map.containsKey(c)) {
            map.put(c,map.get(c) + 1);
        } else {
            map.put(c,1);
        }

        // How to loop through HashMaps (Loop through Keys)
        for (char key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
        // How to loop through HashMaps (Loop through Values)
        for (int val : map.values()) {
            System.out.println(val);
        }

        // HashSet (Stores only unique values - no duplicates)
        // used to remove duplicates
        HashSet<Integer> set = new HashSet<>();

        // Iterating through elements in HashSet
        for (int x : set) {
            System.out.println(x);
        }

    }

}
