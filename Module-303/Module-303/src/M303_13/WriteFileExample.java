package M303_13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;

public class WriteFileExample {

    public static void main(String[] args) {

        File file = new File("src/temp1.txt");

        BufferedWriter bw = null;

        try {

            // creating a new file writer with a single argument (file) it will overwrite the existing file.
            // create a new file writer and the 2nd arguement, true is append and false is overwrite
            bw = new BufferedWriter(new FileWriter(file,true));

            bw.write("Line 1\n");
            bw.write("Line 2\n");
            bw.write("Line 3");
            bw.write(" more on line 3\n");

            // as we are writing to the file we are actually writing to a buffer in memeory
            // when the buffer fills it will automatically write the buffer to the file as a chunk
            // as an engineer .. we have finished writing all that we want to write to the file ...
            // the final buffer may not have completely filled and we have a partial buffer
            // we need to flush that buffer to force it to write what ever it has to the file even tho its not full
            bw.flush();

            // this closes the writer and releases resources at the operating system level
            // technically for best practice this close should be in a finally block of the try catch
            bw.close();
        } catch ( Exception e ) {
            // we dont care what happened we just care that we were unsuccessful
            e.printStackTrace();
        } finally {
            if ( bw != null ) {
                try {
                    bw.close();
                } catch ( Exception e ) {
                    // well I tried to close
                }
            }
        }

    }
}
