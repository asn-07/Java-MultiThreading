package com.basics.thread_4_ExecutionPrevention;

/**
 * @author Anand SN
 */


/**
 *If a Thread don't want to perform any operation for a particular amount of time then we should go for sleep() method.
 *
 * public static native void sleep(long ms) throws InterruptedException
 */
public class ThreadSleep{

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Executed by the thread : "+Thread.currentThread().getName());
        System.out.println("Thread priority is : "+Thread.currentThread().getPriority());

        for (int i=0; i<10;i++){
            System.out.println("Child Thread counts : "+i);
            Thread.sleep(1000);
        }
    }
}