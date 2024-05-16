package Example1;

public class Main {

    private static boolean stopThreads = false; // Declare a static boolean variable to control whether threads should stop

    public static void main(String[] args){ // Main method which serves as the entry point of the program

        FileService service = new FileService("messages.txt"); // Create a FileService object with the file name "messages.txt"
        RThread reader = new RThread(service); // Create an instance of RThread class with the FileService object
        WThread writer = new WThread(service); // Create an instance of WThread class with the FileService object

        reader.start(); // Start the reader thread
        writer.start(); // Start the writer thread

    }

    public static boolean isStopThreads(){ // Method to check whether threads should stop

        return stopThreads; // Return the value of the stopThreads variable

    }

}