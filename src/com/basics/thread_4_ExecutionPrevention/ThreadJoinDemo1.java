package com.basics.thread_4_ExecutionPrevention;

/**
 * @author Anand SN
 */

/**
 * Waiting of Child Thread Until completing o Main Thread
 */

class Mythread extends Thread{
    static Thread mainThread; //Declare a static variable of type Thread Object --1

    public void run(){
        try {
            mainThread.join();
            //mainThread.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i<10; i++){
            System.out.println("Child Thread");
        }
    }
}

public class ThreadJoinDemo1 {
    public static void main(String[] args) throws InterruptedException {

        Mythread.mainThread = Thread.currentThread(); //Assign current Thread to static variable of the MyThread class ---2

        Mythread t = new Mythread();
        t.start();
        //t.join();// Deadlock ------- 3

        for (int i=0; i<10; i++){
            System.out.println("Main Thread ");
            Thread.sleep(2000);
        }
    }
}


/**
 * If main Thread calls join method on child Thread object and child thread calls join method on main thread object Then
 * Both Threads will wait forever and the program will be stucked (This is something like deadlock) ------3
 * In this case thread has to wait infinite amount of time
 */


