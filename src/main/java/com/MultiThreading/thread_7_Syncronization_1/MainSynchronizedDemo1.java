package com.MultiThreading.thread_7_Syncronization_1;

/**
 * @author Anand SN
 */
 public class MainSynchronizedDemo1 {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread1 t1 = new MyThread1(d);
        MyThread2 t2 = new MyThread2(d);
        t2.start();
        t1.start();
    }
}

 class Display{
    public synchronized void displayNumbers(){
        for (int i=0; i<10; i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void displayChars(){
        for (int i=65; i<=75; i++){
            System.out.println((char)i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 class MyThread1 extends Thread{
    Display d;
    MyThread1(Display d){
        this.d = d;
    }
    public void run(){
        d.displayNumbers();
    }
}

 class MyThread2 extends Thread{
    Display d;
    MyThread2(Display d){
        this.d = d;
    }
    public void run(){
        d.displayChars();
    }
}

/**
 * Class Level Lock
 *
 * Every class in java has a unique lock which is nothing but a class level lock.
 *
 * If a Thread wants to execute a static synchronized method then Thread required class level lock, then only it is allowed to execute
 * static synchronized method of that class. Once method execution completes automatically Thread releases the lock.
 *
 * While a Thread executing static synchronized method, The remaining Threads are not allowed to execute any static
 * synchronized method of that class simultaneously.
 * But Remaining Threads are allowed to execute the following methods simultaneously:
 * 1. Normal static methods,
 * 2. synchronized instance methods,
 * 3. normal instance methods.
 */
