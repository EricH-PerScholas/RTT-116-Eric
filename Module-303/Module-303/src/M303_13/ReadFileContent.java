package M303_13;

import java.io.*;

public class ReadFileContent {

    public static void whileLoop1() {
        File file = new File("src/temp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            // another style is assinging to and evaluating at the same time
            // when the end of file is reached br.readLine() will return null  !!!!!!!!!!!!!!!!!
            while ((st = br.readLine()) != null) {

                // Print the string
                System.out.println(st);
            }

            System.out.println();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static void whileLoop2() {
        File file = new File("src/temp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st = br.readLine();
            // the 2 loops are the exat same the only difference is... in whileLoop1 we are doing 2 operations on a single line
            while (st != null) {

                // Print the string
                System.out.println(st);

                // with this way you have to remember to read the next line at the end of the while loop
                st = br.readLine();
            }

            System.out.println();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)   {


    }
}
