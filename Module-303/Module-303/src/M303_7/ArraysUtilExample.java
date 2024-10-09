package M303_7;

import java.util.Arrays;

public class ArraysUtilExample {

    public static void main (String[] args ) {

        // this line creates a new array of size 10
        double[] dValues = new double[10];

        // this utility fills all the values of the array with 50.0
        Arrays.fill(dValues, -1);

        // print the entire array
        System.out.println(Arrays.toString(dValues));

    }

}
