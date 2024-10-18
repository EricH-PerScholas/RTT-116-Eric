package M303_13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerWriter {

    public static void main(String[] args) {

        // character input stream that the user types on the keyboard
        // and the scanner is going to wait for the human to do it
        Scanner scanner = new Scanner(System.in);

        try {
            File file = new File("src/temp2.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file,true));

            System.out.print("Enter a string to write to the file: ");

            String input = scanner.nextLine();

            // this is writing on a stream to a file
            pw.println(input);

            // this is writing the same variable on a stream that appears in the console
            System.out.println(input);

            // !!!!! Always remember to flush your streams so the output works
            pw.flush();

        } catch ( Exception e ) {

        }
    }
}
