package App_2;

import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread1 extends Thread {

    ReentrantLock lock1,lock2;
	int sleep, activity_min1, activity_max1,activity_min2, activity_max2;
	public ExecutionThread1(ReentrantLock lock1, ReentrantLock lock2, int activity_min1,int activity_max1, int activity_min2,int activity_max2, int sleep) {
		this.lock1=lock1;
		this.lock2 = lock2;
		this.activity_max1 = activity_max1;
		this.activity_min1=activity_min1;
		this.activity_max2 = activity_max2;
		this.activity_min2=activity_min2;
		this.sleep=sleep;
		}

    public void run() {
    	System.out.println(this.getName()+ " - STATE 1"); //P1 
		int k1 = (int) Math.round(Math.random()*(activity_max1 - activity_min1) + activity_min1); 
        for (int i = 0; i < k1 * 100000; i++) {
            i++; i--;
        									 }

         lock1.lock();

            System.out.println(this.getName()+ " - STATE 2 - P9 engaged"); //P4
        	int k2 = (int) Math.round(Math.random()*(activity_max2 - activity_min2) + activity_min2); 
            for (int i = 0; i < k2 * 100000; i++) {
                i++; i--;
            						}

            if (lock2.tryLock()) {
                try {
                    System.out.println(this.getName() + " - STATE 3 - P10 engaged"); //P6
                    Thread.sleep(Math.round(Math.random() * sleep * 500)); //T6
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{lock2.unlock();}
            }
            lock1.unlock();


        System.out.println(this.getName()+ " - STATE 4 - monitors disengaged"); // P7
    }
}