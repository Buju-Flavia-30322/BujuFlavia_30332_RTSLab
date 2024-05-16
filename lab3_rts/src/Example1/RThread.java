package Example1;

public class RThread extends Thread
{ // Define a class named RThread which extends Thread class

    FileService service; // Declare a variable to hold reference to a FileService object

    public RThread(FileService service) { // Constructor for the RThread class
        this.service = service; // Assign the provided FileService object to the service variable
    }

    public void run(){ // Override the run method of the Thread class

        while (!Main.isStopThreads()){ // Execute the loop until the stopThreads flag is set to true in the Main class

            try { // Try block to handle exceptions

                String readMsg = service.read(); // Read a message from the FileService object
                System.out.println(readMsg); // Print the read message
                Thread.sleep(3000); // Pause the execution of the thread for 3000 milliseconds (3 seconds)

            }
            catch (Exception e) { // Catch any exceptions
                e.printStackTrace(); // Print the stack trace of the exception
            }
        }
    }
}