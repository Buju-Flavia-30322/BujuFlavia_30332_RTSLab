package Example1;

public class WThread extends Thread{ // Define a class named WThread which extends Thread class

    FileService service; // Declare a variable to hold reference to a FileService object

    public WThread(FileService service) { // Constructor for the WThread class
        this.service = service; // Assign the provided FileService object to the service variable
    }

    public void run(){ // Override the run method of the Thread class

        while(!Main.isStopThreads()){ // Execute the loop until the stopThreads flag is set to true in the Main class

            String msg = String.valueOf(Math.round(Math.random()*100)); // Generate a random message

            service.write(msg); // Write the generated message using the FileService object

            try {
                Thread.sleep(2000); // Pause the execution of the thread for 2000 milliseconds (2 seconds)
            } catch (InterruptedException e) { // Catch InterruptedException if it occurs
                e.printStackTrace(); // Print the stack trace of the exception
            }
        }
    }
}