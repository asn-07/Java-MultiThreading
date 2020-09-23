package com.MultiThreading.thread_4_ExecutionPrevention;

/**
 * @author Anand SN
 */

/*
 * yield() method causes to pause current executing thread to give the chance for waiting ##Threads of same priority##
 * If there is no waiting Thread or all waiting Threads have low priority then same Thread can continue its execution.
 * Which waiting thread will get the chance of execution is depends on the Thread scheduler.
 * public static native void yield(); Prototype
 */

class ThreadYield implements Runnable{

    @Override
    public void run() {
        System.out.println("Executed by the thread : "+Thread.currentThread().getName());
        System.out.println("Priority of the "+Thread.currentThread().getName()+" thread is "+Thread.currentThread().getPriority());

        for (int i=0; i<10;i++){
            System.out.println("Child Thread Counts : "+i);
            Thread.yield();
        }
    }
}

public class MainThreadYield {
    public static void main(String[] args) {

        //yield()
        ThreadYield threadYield = new ThreadYield();
        Thread t1 = new Thread(threadYield);
        t1.setName("threadYield");
        t1.start();
        //t1.interrupt();

        System.out.println("Priority of the "+Thread.currentThread().getName()+ " thread is "+Thread.currentThread().getPriority());
        for (int i=0; i<10;i++){
            System.out.println("Main Thread Counts : "+i);

        }
    }
}
