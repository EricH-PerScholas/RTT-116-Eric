package M303_4;

public class IfStatementsExample {

    public static void main(String[] args) {

        double radius = 30;

        if (radius > 20) {
            System.out.println("Radius greater than 20");
        } else if (radius > 10) {
            System.out.println("Radius greater than 10");
        } else {
            System.out.println("Radius less than or equal to 10");
        }

        System.out.println("Done");


        // -- booleans

        // if the boolean is set to true .. the if not specified if statement will always be checking if true
        boolean save = true;
        if (save) {
            // the same as saying if ( save == true ) {
            // this will execute when the boolean is true
        }
        // this is the condition where save == false
        if (!save) {
            // the same as saying if ( save == false ) {
        }

        // compound conditionals
        // short circuiting means .. in this case if save is false the JVM will not even evauluate the radius
        if (save && (radius == 50)) {
            // both conditions are true
        } else {
            // one condition or the other is false or both are false
        }

        // this too will short circuit
        if (save || (radius == 50)) {
            // if etiher condition (or both) are true then execute here
        } else {

        }

        // grades

        int grade = 30;

        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else if ( grade >= 60 ) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        // case statement / switch statement
        switch(grade) {
            case 90: {
                System.out.println("you got a 90");
                break;
            }
            case 80: {
                System.out.println("you got a 80");
                break;
            }
            default : {
                // this is the else if no other conditions are met
            }
        }

    }
}
