package com.core.fileHandling;

import java.io.File;
import java.io.IOException;

public class FileFolderTest {

    public static void main(String args[]) {

        // new File(...) only creates a Java object for the path - nothing is created on disk yet
        File f1 = new File("E:\\ZzzNewFolder\\abcd");
        // mkdir() creates ONE folder; returns false if the parent (E:\ZzzNewFolder) does not exist
        f1.mkdir();
        File f2 = new File("E:\\ZzzNewFolder\\abcd\\File-1.txt");
        // File(parentFolder, childName) constructor -> E:\ZzzNewFolder\abcd\File-2.txt
        File f3 = new File(f1, "File-2.txt");

        // creates all directories including parent directories
        File f4 = new File("E:\\ZzzNewFolder\\aa\\ab");

        //does not create parent directories and nor the file
        File f5 = new File("E:\\ZzzNewFolder\\bb\\bc\\abcd.txt");


        try {
            // createNewFile() returns false if it already exists (f1 is already a folder)
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            f4.mkdirs();
            // throws IOException here because folders bb\bc do not exist
            f5.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f6 = new File("E:\\ZzzNewFolder\\");
        // lists all files and folders present in the directory
        // NOTE: list() returns null if the folder does not exist -> NullPointerException below
        String array[] = f6.list();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
