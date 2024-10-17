package M303_12;

public class ExceptionExample {


    public static void main(String[] args) {

        int [] numbers = { 1 , 2, 3, 4, 5 };

        // this will try to access the array at position 10 which does not exist
        // this will throw an exception
        try {
            // ArithmaticException
            //int x = 10 / 0;

            // ArrayIndexOutofBoundsException
            //System.out.println(numbers[10]);

            // StringIndexOutofBoundsException
            String s1 = "abc";
            //s1.charAt(10);

            // NullPointerException
            // this is the most common form of programmer error
            String s2 = null;
            s2.toUpperCase();

            // this line of code will not execute if an exception happens in the code above it
            // this is very important to know and very powerful feature of mondern programming languages
            System.out.println("This is the last line of the try catch block and will only execute if no problem");
        } catch ( ArithmeticException ae ) {
            // this is the code for when the divide by 0
            System.out.println("Divide by 0 exception");
            try {
                // some code
            } catch ( Exception e1 ) {
                // I dont care what happens
            }
        } catch ( ArrayIndexOutOfBoundsException aiobe ) {
            // specifically catching only ArrayIndexOutOfBoundsException
            aiobe.printStackTrace();
            System.out.println("=====> " + aiobe.getMessage());
        } catch ( Exception e ) {
            // most of the time I just catch Exception because I dont care what happened I just care that it failed
            // all exceptions extend from Exception
            System.out.println("This is something unexpected" + e.getMessage());
            e.printStackTrace();
        } finally {
            // finally block is optional
            // this code will execute no matter what
            // in both success or failure cases
            // often times it is used to cleanup or close a resource
            // you need to justify using a finally block with a valid reason
            System.out.println("-- finally --");
        }

        // okay to continue with code here
    }

}
