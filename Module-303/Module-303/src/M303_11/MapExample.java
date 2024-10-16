package M303_11;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        // this creates a new hash map where the key is of type string and the value is of type integer
        Map<String, Integer> numbers = new HashMap<>();

        // we can put things into the map.  The first arguement is the key and the second is the value
        // the value can be a duplicate but the key can not
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("ten", 10);
        numbers.put("tenn", 10);
        // when I set the same key value a second time it overwrites the original value
        numbers.put("ten", 100);

        // this basically means the value when there is no key is ....
        // this is very very very rare
        numbers.put(null, 100000);

        // to erase a value this will leave the key in the hashmap but will set the value of that key to null or nothing
        // this happesn from time to time
        // in a way this is setting the value to empty. however it is not deleting the key from the keySet
        numbers.put("one", null);

        // we are askign the map for a key that does not exist it will retun null meaning not existing
        // the get method returns null when not found
        Integer notFound = numbers.get("thousand");
        System.out.println("not found == " + notFound);

        // we can retrieve things from the map using the key
        Integer x = numbers.get("one"); // this will return the Integer 1
        Integer x2 = numbers.get("two"); // this will return the Integer 2

        // we can also loop over the hashmap similar to how we could loop over a list
        // first we need to get the set of all keys in the map
        // the method to get the set of keys from the map is called keySet();
        // we do not know what order the keyset will return in .. not guaranteed
        // !!!!!!!! IMPORTANT TO KNOW AND UNDERSTAND LOOPING OVER THEY KEYS TO GET THE VALUES
        // !!!!!!!! THIS GETS DONE ALLOT
        for ( String key : numbers.keySet()) {
            Integer value = numbers.get(key);
            System.out.println(key + " == " + value);
        }

        // we can also loop over the values in the hashmap
        // not alot of uses for this but it is part of the hashmap
        for ( Integer i : numbers.values() ) {
            // with this technique we do not know which key belogs with which value .. jsut the vales themselves
            // also this is random order
            System.out.println(i);
        }

    }

}
