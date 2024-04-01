package Example3;

import java.util.Random;

class JoinTestThread extends Thread{

    Thread t;
    String n;

    int num;

    public int getNum(){
        return this.num;
    }

    JoinTestThread(String n, int num, Thread t){

        this.setName(n);
        this.n = n;
        this.t=t;
        this.num = num;

    }

    public int getNumDiv(int num){
        Random random = new Random();

        // Generate a random number greater than 20000
        int randomNumber = random.nextInt(Integer.MAX_VALUE - num) + num + 1;
        System.out.println("random number: " + randomNumber);
        int div = 2;
        int numDiv = 2;
        int copy = randomNumber;

        while(div <= randomNumber/2){
            if(randomNumber % div == 0)
            {
                numDiv++;
                System.out.println(div + " for " + randomNumber);
            }

            while(copy % div == 0)
                copy /= div;

            div++;
        }
        return numDiv;
    }

    public void run() {

        System.out.println("Thread "+n+" has entered the run() method");

        try {

            if (t != null) t.join();
            System.out.println("Thread "+n+" executing operation.");
            int numDiv = getNumDiv(getNum());
            Main.sum += numDiv;
            System.out.println("Thread "+n+" has terminated operation.");

        }
        catch(Exception e){e.printStackTrace();}
    }
}
