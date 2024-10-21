package M303_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamForEachExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");


        // called a lambda expreassion
        // in one line of code we are going to loop over the entire list and print all elements to upper case
        list.stream().forEach((e) -> {
                    // could have many lines of code in here
                    System.out.println(e.toUpperCase());
                }
        );

        // how you will most often see it
        list.stream().forEach(anything -> System.out.println(anything.toUpperCase()));
        // these 2 lines are the same ... not sure what the subtle difference is .. not sure if it matters
        list.forEach(anything -> System.out.println(anything.toUpperCase()));


        // super nice fast way of removing an item from a list in one line of code
        // the remove if will affect the original list
        list.removeIf(e -> e.startsWith("o"));

        System.out.println("===========================================");


        // primary use for this filter is when your trying to find something in a list of entities
        // this stream did not affect the original list
        List<String> filteredList = list.stream().filter(e -> !e.startsWith("o")).collect(Collectors.toList());

        // this is the same as above
        List<String> filteredList2 = list.stream().filter(e -> !e.startsWith("o")).toList();

        // note that we can chain this together to do 2 filters
        // formatting like this can also help increase the readability of the code
        List<String> filteredList1 = list.stream()
                .filter(e -> !e.startsWith("o"))
                .filter(e -> e.startsWith("t"))
                .collect(Collectors.toList());

        // loop over the filtered list and print elements
        filteredList1.stream().forEach(a -> System.out.println(a));
    }


}
