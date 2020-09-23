package com.MultiThreading.thread_2_definingThread2ndWay;

/**
 * @author Anand SN
 */

/**
 * Defining a Thread by implementing the Runnable Interface
 *
 * Runnable(I) interface present in java.lang package and it has only one method i.e public void run().
 */
public class MainThread {
    public static void main(String[] args) {

        DefineThreadByImplementingRunnableInterface t = new DefineThreadByImplementingRunnableInterface();
        Thread newThread = new Thread(t);
        newThread.setName("Demo Thread-2");

        newThread.start();
        /**
         * Thread class start() method is responsible to register the thread with thread scheduler
         * and all other mandatory activities , Hence without executing Thread class start() method
         * there is no chance of starting new thread in java, due to this Thread class start() method is considered as Heart Of Multithreading
         */

        System.out.println("Executed by "+Thread.currentThread().getName()+ " Thread");
        for (int i=0; i<10; i++){
            System.out.println("Main Thread Count "+i);
        }
    }
}

class DefineThreadByImplementingRunnableInterface implements Runnable{

    @Override
    public void run() {

        System.out.println("Executed by "+Thread.currentThread().getName());

        for (int i=0; i<10; i++){
            System.out.println("Child Thread Count "+i);
        }
    }
}
/**
 * Note : Recommended as Inheritance benifit is available
 * we can extend any other class if we implements Runnable interface to define Thread.
 */