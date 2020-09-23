package com.basics.thread_3_utilities;

/**
 * @author Anand SN
 */
public class MainThread {
    public static void main(String[] args) {

        ThreadUtility utility = new ThreadUtility();
        Thread t1 = new Thread(utility);

        t1.setName("demoThread"); //Setting the name of the thread

        t1.setPriority(10);//Setting the Thread Priority. Allowed values are 1 to 10
        /**
         * t1.setPriority(Thread.MAX_PRIORITY); //value is 10
         * t1.setPriority(Thread.MIN_PRIORITY); // value is 1
         * t1.setPriority(Thread.NORM_PRIORITY); // value is 5

         * Thread Scheduler will use priorities while allocating processor
         * The Thread which is having highest priority will get the chance first
         */

        t1.start();

        System.out.println("Priority of the "+Thread.currentThread().getName()+ " thread is "+Thread.currentThread().getPriority());
        for (int i=0; i<10;i++){
            System.out.println("Main Thread Counts : "+i);
        }

    }
}

class ThreadUtility implements Runnable{

    @Override
    public void run() {

        System.out.println("Executed by the thread : "+Thread.currentThread().getName());
        System.out.println("Thread priority is : "+Thread.currentThread().getPriority());

        for (int i=0; i<10;i++){
            System.out.println("Child Thread Counts : "+i);
        }

    }
}

