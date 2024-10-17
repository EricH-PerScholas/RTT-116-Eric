package org.perscholas;

import java.util.ArrayList;
import java.util.List;

public class CompareToExample {

    public static void main(String[] args ) {

        // any negative result means less than
        // 0 mean equals
        // any positive result means greater than

        String s1 = "abc";
        String s2 = "ABC";

        int result = s1.compareTo(s2);

        System.out.println(s1 + " == " + s2 + " compareTo = " + result);


        Integer i1 = 20;
        Integer i2 = 10;

        int r1 = i1.compareTo(i2);

        System.out.println(i1 + " == " + i2 + " compareTo = " + r1);


        // --------------------------------

        List<String> l1 = new ArrayList<>();
        l1.add("abc");
        l1.add("xyz");

        List<String> l2 = new ArrayList<>();
        l2.add("abc");
        l2.add("xyz");


    }

}
