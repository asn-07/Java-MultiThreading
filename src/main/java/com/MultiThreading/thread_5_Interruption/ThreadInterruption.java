package com.MultiThreading.thread_5_Interruption;

/**
 * @author Anand SN
 */

/**
 * HOW A THREAD CAN INTERRUPT ANOTHER THREAD
 *
 * A thread can interrupt a sleeping thread or waiting thread by using interrupt() method of Thread class
 */
 public class ThreadInterruption {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        t.interrupt();// Executed by main thread : Main Thread interrupts child thread

        System.out.println("End of main thread");
    }
}

 class MyThread extends Thread{
    public void run(){

        try {
            for (int i=0; i<10; i++) {
                System.out.println("I am lazy Thread");
                sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("I got Interrupted ");
        }
    }
}