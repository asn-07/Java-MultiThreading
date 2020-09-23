package com.basics.thread_1_definingThread;

/**
 * @author Anand SN
 */

/**
 *
 *Definition - What does Thread mean?
 *A thread, in the context of Java, is the path followed when executing a program.
 * All Java programs have at least one thread, known as the main thread, which is created by the Java Virtual Machine (JVM) at the program’s start,
 * when the main() method is invoked with the main thread.
 *
 * The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.
 */


/**
 * Defining the Thread by extending Thread Class
 *
 * Thread scheduler is the part of JVM.
 * Responsible for scheduling thread, i,e if multiple threads are waiting to get the chance of execution then
 * in which order Thread will be executed by Thread Scheduler
 *
 * We can't expect exact algorithm followed by Thread scheduler. It is varied from JVM to JVM. Hence we can't expect Thread
 * execution order and Exact output.
 */


public class MainThread {

    public static void main(String[] args) {

        DefineThreadByExtendingThreadClass t = new DefineThreadByExtendingThreadClass(); // It is the class which extended Thread Class.
        t.setName("Demo Thread"); // Naming the Thread
        t.start(); // Starting of the Thread, Internally calls run() method, Especially No-Argument run() method

        // Below code execution is the job of main Thread
        //we can get current executing thread object by using Thread.currentThread() method.
        System.out.println("Executed by :" +Thread.currentThread().getName()+" Thread");

        for (int i=0; i<10; i++){
            System.out.println("Main Thread count : "+i);
        }
    }
}

//Defining a Thread by Extending Thread Class
class DefineThreadByExtendingThreadClass extends Thread{

    public void run(){
        System.out.println("Executed by "+Thread.currentThread().getName());

        for (int i=0; i<10; i++){
            System.out.println("Child Thread count: "+ i);
        }// Job of Thread, Executed by child thread
    }
}

/**
 * Note : Not Recommended as Inheritance benefit is missing because
 * we can't extend any other class if we extend Thread class to define Thread.
 */