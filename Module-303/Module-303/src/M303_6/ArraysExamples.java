package M303_6;

public class ArraysExamples {

    public static void main(String [] args) {

        // this makes a new array of size 10 and all elements will be 0
        int[] numbers = new int[10];

        // to initialize an array we can just loop over it and set all values to something
        for ( int pos = 0 ; pos < numbers.length ; pos++) {
            numbers[pos] = 1;
            System.out.println("number[" + pos + "] = " + numbers[pos]);
        }


        // array by hard coding it
        // this will create a new int array with size of 6
        // and automatically fill the array with the given values
        int [] numbers1 = { 1, 2, 3, 4 ,5, 6};

        // this will create an array of size 5 with the given values
        String [] strings = { "one", "two", "three", "four", "five"};
    }
}
