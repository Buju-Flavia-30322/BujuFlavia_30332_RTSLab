package App_4;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(2);
        new Fir(s, 5,5,3,6, 1).start();
        new Fir(s, 3,3,4,7, 1).start();
        new Fir(s, 6,6,5,7, 1).start();
    }
}
