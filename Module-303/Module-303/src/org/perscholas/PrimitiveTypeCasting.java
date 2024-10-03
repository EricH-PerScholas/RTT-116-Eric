package org.perscholas;

public class PrimitiveTypeCasting {

    public static void main(String[] args) {
        int x = 5;

        // because y is an integer I can only put the whole number into it
        int y = 5 / 2;
        System.out.println(y);

        // I am dividing 2 whole numbers that are integers and putting the result into a double which
        // gives the anser 2.0
        double z = 5 / 2;
        System.out.println(z);

        // this will give us the proper answer of 2.5 because we used two doulbe valeus in our division
        double d = 5.0 / 2.0;
        System.out.println(d);

        // now we introduce type casting
        int j = 5;
        int k = 2;
        double e = (double)j / (double)k;
        System.out.println(e);
    }

}
