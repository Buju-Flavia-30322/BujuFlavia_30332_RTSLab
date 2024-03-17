package main;
import java.util.Random;
import java.util.Arrays;
public class TenRandomNumbers
{
    public static void main(String[] args)
    {
        //initialize an array that will get 10 random numbers
        int[] array = new int[10];

        // populate the array with random numbers !! import java.util.Random
        Random rand= new Random(); //creezi un obiect de tipu importului
        for(int i=0; i<10;i++)
        {
            array[i] = rand.nextInt(100); // nr random de la 0 la 99
        }

        //now we sort it with function sort
        Arrays.sort(array); //!!!!!import java.util.Arrays;
        System.out.println("the sorted array: ");
        for (int i=0; i<10;i++)
        {
            System.out.println(array[i]);
        }

    }
}
