package coffee_shop;

public class InvalidInputException extends Exception {

    // 1) extends Exception
    // 2) Create a constructor that takes a string and calls super to init parent

    public InvalidInputException(String message) {
        super(message);
    }

}
