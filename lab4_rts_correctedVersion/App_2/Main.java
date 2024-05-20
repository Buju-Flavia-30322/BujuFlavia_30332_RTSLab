package App_2;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock1=new ReentrantLock(); //locks
        ReentrantLock lock2=new ReentrantLock();


        new ExecutionThread1(lock1, lock2, 2, 4,4, 6, 4).start();
		new ExecutionThread1(lock2, lock1, 3, 5, 5, 7, 5).start();
    }
}