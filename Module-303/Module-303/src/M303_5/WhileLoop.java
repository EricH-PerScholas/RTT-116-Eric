package M303_5;

public class WhileLoop {



    public static void main(String [] args ) {

        // this would create an infinite loop
//        while ( true ) {
//            System.out.println("Inside while loop.");
//        }


        // while loops have some kind of condition
        // this is very similar to a for loop and really a for loop is better than
        String word = "abcdefg";
        int pos = 0;
        while ( pos < word.length() ) {
            pos = pos + 1;
            System.out.println("Inside while loop.");
        }

        boolean c = false;
        while ( c ) {
            // this code can never execute because the condition on the while loop will
            // get checked and not enter the code
            System.out.println("Inside while codition false");
        }

        // run the code at least one time before checking exit condition
        int x = 5;
        do {
            System.out.println("Inside do while");
            x = x + 1;
        }while (x < 5);



    }
}
