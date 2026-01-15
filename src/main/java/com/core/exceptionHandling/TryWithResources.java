package JAVA_7;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TryWithResources {

	public static void main(String[] args) {
		
		 String filePath = "example.txt";

	        // Use try-with-resources to open and read the file
	        try (FileInputStream fileInputStream = new FileInputStream(filePath);
	        	 Connection con= null;	) 
	        {
	            int data;
	            while ((data = fileInputStream.read()) != -1) {
	                System.out.print((char) data);
	            }
	        } catch (IOException|SQLException e) {
	            System.err.println("An error occurred: " + e.getMessage());
	        }
	}
}
