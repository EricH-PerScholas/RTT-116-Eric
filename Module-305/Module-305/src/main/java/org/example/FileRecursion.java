package org.example;

import java.io.File;

public class FileRecursion {

    public static void main(String[] args ) {
        File f = new File(".");
        listFiles(f);
    }

    public static void listFiles(File rootDirectory) {
        // give me a list of all the file and directories
        File[] files = rootDirectory.listFiles();

        for ( File file : files ) {
            if ( file.isDirectory() ) {
                listFiles(file);
            } else {
                // this is just a plain file so lets print the name
                System.out.println(file.getAbsolutePath());
            }
        }
    }

}
