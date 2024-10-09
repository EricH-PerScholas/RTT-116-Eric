package M303_7;

public class Average {

    public static void main(String [] args ) {

        double[] values = { 1.2, 6.5, 3.2, 9.6, 8.5 };

        // the average is the sum of all values divided by the number of values

        double sum = 0.0;
        // old style for loop
//        for ( int pos = 0 ; pos < values.length ; pos++ ) {
//            sum = sum + values[pos];
//        }

        // new style for loop
        for ( double v : values ) {
            sum = sum + v;
        }

        // calculate the average
        double avg = sum / values.length;

        System.out.println("The sum of the values is " + sum);
        System.out.println("The average is " + avg);
    }
}
