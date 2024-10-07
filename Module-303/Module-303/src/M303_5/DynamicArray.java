package M303_5;

public class DynamicArray {

    // pos = 01234567890
    // val = 1234567891
    //                0


    public static double[] insert(double[] array, int position, double value) {
        // step 1 is we need to make a new array that is of size one larger
        double[] result = new double[array.length + 1];

        // step 2
        // copy all the elements from 0 to the position we insert to the new array
        for ( int pos = 0 ; pos < position ; pos++ ) {
            result[pos] = array[pos];
        }

        // step 3
        // we set the incoming value at the insert position
        result[position] = value;

        // step 4
        // move all the remaining values to the end of the new array
        for ( int pos = position ; pos < array.length ; pos++ ) {
            result[pos + 1] = array[pos];
        }

        return result;
    }

    /**
     *  check to make sure that the position is a valid position in the array
     *
     */
    public static double[] delete(double[] array, int position) {
        // if the position is larger than the size of the array
        // or if the position is less than 0
        if ( (position >= array.length) || (position < 0) ) {
            System.out.println("Unable to delete element at " + position + " because it is not a valid position");
            // lets get out of here with out doing any work
            // we pass back the incoming array because we did not modify it
            return array;
        }

        // step 1 is create a new array that is 1 smaller
        double[] result = new double[array.length - 1];

        // step 2
        // copy all the elements from 0 to the position we insert to the new array
        for ( int pos = 0 ; pos < position ; pos++ ) {
            result[pos] = array[pos];
        }

        // step 3 - shift remaining values left or back by 1
        for ( int pos = position + 1 ; pos < array.length ; pos++ ) {
            result[pos - 1] = array[pos];
        }

        return result;
    }

    public static double[] append(double[] array, double value ) {
        // step 1 is we need to make a new array that is of size one larger
        double[] result = new double[array.length + 1];

        // step 2
        // copy all the elements from 0 to the position we insert to the new array
        for ( int pos = 0 ; pos < array.length ; pos++ ) {
            result[pos] = array[pos];
        }

        // step 3 - could do this a couple different ways
        result[array.length] = value;

        return result;
    }


    public static void main(String[] args) {
         double[] numbers = { 1 , 2, 3 ,4 ,5 , 6 ,7, 8, 9, 10};
         numbers = insert( numbers , 3 , 3.5);
         numbers = delete( numbers , 11);
         numbers = append(numbers, 20);
    }
}
