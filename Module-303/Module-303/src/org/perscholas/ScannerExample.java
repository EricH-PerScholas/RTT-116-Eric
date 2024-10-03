package org.perscholas;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        System.out.print("Enter the radius of the circle ");

        Scanner scanner = new Scanner(System.in);

        // after scanning an number we need to do a scanner.nextLine() to throw
        // the new line character (which was created when you pressed enter on the keyboard)
        // into the garbage
        // IMPORTANT
        // when we type this on the keyboard we are actually press 3 keys
        // 2
        // 0
        // enter
        // the nextDouble() takes the 2 and the 0 and puts it into the variable x
        // the scanner still contains the new line character created when you pressed enter
        double x = scanner.nextDouble();
        // calling nextLine after nextDoulbe will consume the new line character from the scanner
        // and essentially throw it in the garbage .. this will leave the scanner empty so the next time the
        // user enters data we can capture it wihtout having leftovers from the previus call
        scanner.nextLine();

        System.out.println("You have entered a radius of " + x);

        double area = x * x * 3.14159;

        System.out.println("The area of the circle is " + area);

        System.out.println("Enter your name : ");
        String name = scanner.nextLine();
        System.out.println(name);
    }

}
