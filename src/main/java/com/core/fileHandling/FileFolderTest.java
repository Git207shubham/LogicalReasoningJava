package com.core.fileHandling;

import java.io.File;
import java.io.IOException;

public class FileFolderTest {

    public static void main(String args[]) {

        File f1 = new File("E:\\ZzzNewFolder\\abcd");
        f1.mkdir();
        File f2 = new File("E:\\ZzzNewFolder\\abcd\\File-1.txt");
        File f3 = new File(f1, "File-2.txt");

        // creates all directories including parent directories
        File f4 = new File("E:\\ZzzNewFolder\\aa\\ab");

        //does not create parent directories and nor the file
        File f5 = new File("E:\\ZzzNewFolder\\bb\\bc\\abcd.txt");


        try {
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            f4.mkdirs();
            f5.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f6 = new File("E:\\ZzzNewFolder\\");
        String array[] = f6.list(); // lists all files and folders present in the directory
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
