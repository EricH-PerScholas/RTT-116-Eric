package org.perscholas;

public class EscapeSequenceExample {

    public static void main(String[] args) {
        System.out.print("This is line 1\nThis is line 2\n");
        // System.out.println - automatically includes a new line for you
        // this another memorize thing in that print does include a new line
        System.out.println("This is line 3");
        System.out.println("This is line 4");

        // if we want to express a tab in a string
        System.out.println("This is a tab ->\t<-");
        System.out.println("This is a tab ->1\t<-");
        System.out.println("This is a tab ->12\t<-");
        System.out.println("This is a tab ->123\t<-");
        System.out.println("This is a tab ->1234\t<-");

        // we are going to use a \ to escape the " so that java thinks its actually the character
        // and not the end of the string
        System.out.println("What happens if we want to have a \" in the string itself");

        // because the \ is the escape character it too needs to be escaped
        System.out.println("We want to print out the \\ backslash character");

        // this a string literal meaning that new string object is created and set to "abc"
        String x = "abc";
        String y = new String("abc");

        // this will print upper case
        System.out.println(x.toUpperCase());

        // in contrast to a primitive type - there are no functions in a primitive data type
        int a = 5;
    }

}
