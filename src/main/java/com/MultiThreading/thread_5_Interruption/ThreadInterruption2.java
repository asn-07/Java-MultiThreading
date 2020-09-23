package com.MultiThreading.thread_5_Interruption;

/**
 * @author Anand SN
 */


/**
 *  interrupt call never be wasted.
 *
 *
 * Whenever we are calling interrupt() method, If the target thread is not in sleeping state or waiting state, then there is no
 * impact of interrupt call immediately.
 *
 * interrupt call will be waited until target thread entered into sleeping or waiting state.
 *
 * If the target thread entered into sleeping or waiting thread then immediately interrupt call will interrupt the target thread.
 *
 *
 * If the target thread never entered into sleeping or waiting state in its lifetime then there is no impact of interrupt call.
 * This is the only case where interrupt call will be wasted
 */
 class MyThread2 extends Thread{
     public void run(){
         for (int i=0; i<10000; i++) {
             System.out.println("I am lazy Thread");
         }
         System.out.println("I am entering into the sleeping state");

         try {
             Thread.sleep(10000);
         } catch (InterruptedException e) {
             System.out.println("I got Interrupted");
         }
     }
}

public class ThreadInterruption2 {
    public static void main(String[] args) {
        MyThread2 t2 = new MyThread2();
        t2.start();

        t2.interrupt(); //Executed by main Thread: Interrupted by main thread
        System.out.println("End of main Thread");
    }
}

/**
 * In the above example interrupt call waited until child thread completes for loop 10000 times.
 */
