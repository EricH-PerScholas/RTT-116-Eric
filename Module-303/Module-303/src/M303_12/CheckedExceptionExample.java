package M303_12;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExceptionExample {

    // this one chooses to deal with the exception in the start method after being thrown again by method1

    public void start() {
        // start method has now the same choice in either deal with it or throw it again
        try {
            method1();
        } catch ( Exception e ) {

        }
    }

    public void method1() throws CustomException, IOException, FileNotFoundException {
        System.out.println("method1");

        // whats shown here is #2
        method2();
    }

    // throwing an exception here causes method1 to have to
    // 1) either catch the exception with a try catch block
    // or
    // 2) throw the exception for the calling method to catch
    public void method2() throws CustomException {
        System.out.println("method2");
        throw new CustomException("Error in method 2");
    }


    public static void main(String[] args) {
        CheckedExceptionExample cee = new CheckedExceptionExample();
        cee.start();
    }
}
