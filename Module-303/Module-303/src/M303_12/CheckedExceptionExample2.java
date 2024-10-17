package M303_12;

public class CheckedExceptionExample2 {

    // !!!!!!!!! NOTE : this example throws the exception all the way up and off the top of the call stack in the main method

    public void start() throws CustomException {
        // start method has now the same choice in either deal with it or throw it again
        method1();
    }

    public void method1() throws CustomException {
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


    public static void main(String[] args) throws CustomException {
        CheckedExceptionExample2 cee = new CheckedExceptionExample2();
        cee.start();
    }
}
