package com.MultiThreading.thread_9_InterThreadCommunication;

/**
 * @author Anand SN
 */
 public class ThreadDemo_WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        synchronized (myThread){
            System.out.println(" *******   Main Thread wants Updation, so calling wait() method.   ******* ");
            myThread.wait();

            System.out.println(" *******   Main Thread got notification.   ******* ");
            System.out.println(" *******   total value is : "+myThread.total);
        }
    }
}

class MyThread extends Thread{
     int total=0;

     public void run(){
         synchronized (this){
             System.out.println(" *******   Child Thread Starts calculation or started Updating.   ******* ");

             for (int i=1; i<=100; i++){
                 total = total+i;
             }

             System.out.println(" *******   Updating of total is completed, child thread giving notification.   ******* ");
             this.notify();
         }
     }
}