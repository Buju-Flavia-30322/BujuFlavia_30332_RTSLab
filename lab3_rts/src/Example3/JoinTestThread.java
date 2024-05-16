package Example3;

import java.util.Random;

class JoinTestThread extends Thread{ // Define a class named JoinTestThread which extends Thread class

    Thread t; // Declare a variable to hold reference to another thread
    String n; // Declare a string variable to hold the name of the thread
    int num; // Declare an integer variable to hold a number

    public int getNum(){ // Define a method to get the value of the num variable
        return this.num; // Return the value of the num variable
    }

    JoinTestThread(String n, int num, Thread t){ // Constructor for the JoinTestThread class

        this.setName(n); // Set the name of the thread
        this.n = n; // Assign the name of the thread
        this.t=t; // Assign the reference to another thread
        this.num = num; // Assign the value of num

    }

    public int getNumDiv(int num){ // Define a method to calculate the number of divisors for a given number

        Random random = new Random(); // Create an instance of the Random class

        // Generate a random number greater than 20000
        int randomNumber = random.nextInt(Integer.MAX_VALUE - num) + num + 1; // Generate a random number within a specified range
        System.out.println("random number: " + randomNumber); // Print the random number
        int div = 2; // Initialize the divisor to 2
        int numDiv = 2; // Initialize the number of divisors to 2 (every number is divisible by 1 and itself)
        int copy = randomNumber; // Create a copy of the random number

        while(div <= randomNumber/2){ // Iterate until the divisor is less than or equal to half of the random number
            if(randomNumber % div == 0) // Check if the random number is divisible by the current divisor
            {
                numDiv++; // Increment the number of divisors
                System.out.println(div + " for " + randomNumber); // Print the divisor
                Main.sum += div;
            }

            while(copy % div == 0) // Check if the copy of the random number is divisible by the current divisor
                copy /= div; // Divide the copy by the divisor

            div++; // Increment the divisor
        }
        return numDiv; // Return the number of divisors
    }

    public void run() { // Override the run method of the Thread class

        System.out.println("Thread "+n+" has entered the run() method"); // Print a message indicating the thread has entered the run method

        try { //handle exceptions

            if (t != null) t.join(); // If there is a dependent thread, wait for it to finish execution
            System.out.println("Thread "+n+" executing operation."); // thread is executing an operation
            int numDiv = getNumDiv(getNum()); // Calculate the number of divisors for the given number
            Main.sum += numDiv; // Update the sum variable in the Main class by adding the number of divisors
            System.out.println("Thread "+n+" has terminated operation."); // Print a message indicating the thread has terminated its operation

        }
        catch(Exception e){ // Catch any exceptions
            e.printStackTrace(); // Print the stack trace of the exception
        }
        System.out.println(Main.sum + this.getName()); // Print the value of sum after both threads have finished execution
    }
}