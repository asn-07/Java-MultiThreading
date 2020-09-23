package com.MultiThreading.thread_8_SynchronizedBlocks;

/**
 * @author Anand SN
 */

/**
 * Synchronized block or Synchronized statements
 *
 * If very few lines of the code required synchronization then it is not recommended to declare entire method as synchronized.
 * We have to enclose those few lines of the code by using synchronized block.
 *
 * The main advantage of synchronized block over synchronized method is, synchronized block reduces waiting time of the threads
 * and improves performance of the system.
 *
 * If a Thread got lock of current object then only it is allowed to execute that particular block. --------1. Here we can pass object or Display.class
 *
 * The Lock concept is applicable for Object types and Class types but not for Primitive types. If we pass primitive type as argument to
 * synchronized block then we will get Compile time error
 */


 class Display {
     public void wish(String name){
         // Assume here 10000 lines of code is there.

         //synchronized block begins
         /*synchronized (Display.class){
           By above Display.class we can get class level lock and proceed same as below.
         }*/
         synchronized (this) { //-------------------- 1
             for (int i = 65; i <= 75; i++) {
                 System.out.println("Good Morning");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(name);
             }

         } //End of synchronized block

         // Assume here also 10000 lines of code is there.
     }
 }

 class MyThread extends Thread{
    Display d;
    String name;
    MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }
    public void run(){

        d.wish(name);

    }
 }

 public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        Display d = new Display();

        MyThread t1 = new MyThread(d,"Dhoni");
        MyThread t2 = new MyThread(d,"Yuvaraj");
        t1.start();
        t2.start();
    }
 }

/**
 * What is Race Condition in Java?
 *
 * If multiple threads are operating simultaneously on a same java object then there may be a chance of data inconsistency problem,
 * this is nothing but Race condition. (In general). we can overcome this problem by using synchronized keyword.
 */


/**
 * Is a Thread can acquire multiple locks simultaneously?
 * Yes, Off course from different objects it can acquire as many as possible.
 *
 class X{
    public synchronized void m1(){
        //Here Thread has a lock of X

        Y y = new Y();
        synchronized(y){
        //Here Thread has a lock of Y
        }
    }
 }
 *
 */