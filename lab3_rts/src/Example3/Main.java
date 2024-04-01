package Example3;

public class Main {

    static int sum = 0;
    public static void main(String[] args){

        JoinTestThread w1 = new JoinTestThread("Thread 1", 50000, null);
        JoinTestThread w2 = new JoinTestThread("Thread 2",20000, w1);
        w1.start();
        w2.start();

        try{
            w1.join();
            w2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Main.sum);

    }

}
