package M303_13;

import java.io.File;

public class FileExample {

    public static void main(String[] args) {
        // main constructor usage is the name of the file
        // this can include a partial path or the full path

        // this is considered an absolute path because it contains the root of the directory and all directorys to the file we want
        File absolute = new File("C:\\Users\\eric\\development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\temp.txt");

        // relative - starts in the current working directory and goes from there
        File file = new File("src/temp.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println("exists " + file.exists());
        System.out.println("is Directory " + file.isDirectory());
        System.out.println("is Hidden " + file.isHidden());
        System.out.println("can read " + file.canRead());
        System.out.println("can write " + file.canWrite());
        System.out.println("can execute " + file.canExecute());
        System.out.println("size " + file.length());

        if ( file.isDirectory() ) {
            // lets list the files in this directory
            File[] files = file.listFiles();
            for ( File f : files ) {
                System.out.println("===> " + f.getName());
            }
        }

        // BE VERY CAREFUL WHAT YOU DELETE ... because .. there is no passing go and it will delete a directory and all the contents
        //file.delete();

        // example for creating a new directory
        File newDirectory = new File("asdf");
        // make a new directory
        if ( ! newDirectory.exists() ) {
            newDirectory.mkdir();
        }

    }
}
