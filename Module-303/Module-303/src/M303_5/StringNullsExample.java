package M303_5;

public class StringNullsExample {

    public static void main(String[] args) {

        // !!!!!!!!!! null is not equal to an empty string

        // null is its own built in part of the language
        // no memory has been allocated and this is simply a variable that has no value
        String s = null;  // this string does not exist at all
        String s1 = "";   // this string exists as an object in memory and we call functions on it

        System.out.println("The length of s1 = " + s1.length());
        // note that I Can still call functions on s1 because its a real object
        s1.trim();
        s1.toUpperCase();

        // we can check if s exists by saying s == null
        if ( s == null ) {
            System.out.println("the valirable s does not exist");
        }

        // NullPointerException
        //s.length();

        // check for an empty string
        if ( s == null || s.length() == 0 ) {
            // the string is empty
            System.out.println("the string is empty");
        }

        // doing comparisons ... in Java can never compare strings this way .. will always produce the wrong result
        // however it might fool you sometimes
        if ( s == s1 ) {
            // this is always wrong
        }

        // this is the correct way of doing string comparison
        // the problem we have ... is that s is null in our case here
        if ( s != null && s.equals(s1) ) {
            // then the 2 strings are equal in a safe way
            System.out.println("Will never print becuase null is not equal to empty string");
        } else {
            System.out.println("null is not equal to an empty string");
        }

        // for the code we have here .. we could simply check
        // in this simple case we know s is null so this if statement will work
        // in real life you may not know this for 100% sure so we have to do the null check like above
        if ( s1.equals(s) ) {
            System.out.println("Will never print becuase null is not equal to empty string");
        } else {
            System.out.println("null is not equal to an empty string");
        }
    }


}
