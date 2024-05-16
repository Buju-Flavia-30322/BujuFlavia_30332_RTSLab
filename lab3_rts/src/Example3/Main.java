package Example3; // Define the package
public class Main
{
    static int sum = 0; // Declare a static integer variable named sum and initialize it to 0

    public static void main(String[] args){ // Define the main method which is the entry point of the program

        JoinTestThread w1 = new JoinTestThread("Thread 1", 50000, null); // Create a new instance of JoinTestThread with name "Thread 1", delay of 50000 milliseconds, and no dependency on other threads
        JoinTestThread w2 = new JoinTestThread("Thread 2",20000, w1); // Create a new instance of JoinTestThread with name "Thread 2", delay of 20000 milliseconds, and a dependency on w1 thread

        w1.start(); // Start execution of w1 thread
        w2.start(); // Start execution of w2 thread



    }

}
