package Example1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FileService {

    String fileName; // Declare a string variable to store the file name
    BufferedReader in; // Declare a BufferedReader variable for reading from the file
    PrintWriter out; // Declare a PrintWriter variable for writing to the file

    public FileService(String fname){ // Constructor to initialize the FileService object with a file name

        this.fileName = fname; // Assign the provided file name to the fileName variable

        try { // Try block to handle exceptions
            out = new PrintWriter(new FileWriter(fileName, true)); // Create a PrintWriter object to write to the file in append mode
            in = new BufferedReader(new FileReader(fileName)); // Create a BufferedReader object to read from the file
        } catch (Exception e) { // Catch any exceptions
            e.printStackTrace(); // Print the stack trace of the exception
        }
    }

    public void write(String msg) { // Method to write a message to the file
        Date date = new Date(System.currentTimeMillis()); // Create a Date object to represent the current date and time
        synchronized(this){ // Synchronize access to the PrintWriter object to ensure thread safety
            out.println("Date: " + date); // Write the current date and time to the file
            out.println("Message: " + msg); // Write the provided message to the file
            out.flush(); // Flush the PrintWriter to ensure that the data is written to the file immediately
        }
    }

    public String read() throws IOException { // Method to read messages from the file
        String iterator, last = "no message to read"; // Initialize variables to store the last message read from the file and the current message being read
        synchronized(this){ // Synchronize access to the BufferedReader object to ensure thread safety
            while ((iterator = in.readLine()) != null) { // Read each line from the file until the end is reached
                last = new Date(System.currentTimeMillis()) + " - " + iterator; // Store the current message along with the timestamp
            }
        }
        return last; // Return the last message read from the file
    }
}