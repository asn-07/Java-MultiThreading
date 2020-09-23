package com.MultiThreading.thread_4_ExecutionPrevention;

/**
 * @author Anand SN
 */

/**
 * If a Thread calls join method on same Thread itself then the program will be stucked. (This is something like deadlock).
 * In this case thread has to wait infinite amount of time
 */

public class ThreadJoinDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
        System.out.println("Hello Worlds");
    }
}
