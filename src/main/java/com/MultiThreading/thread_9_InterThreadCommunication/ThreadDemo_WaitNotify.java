package com.MultiThreading.thread_9_InterThreadCommunication;

/**
 * @author Anand SN
 */

/**
 * Two Threads can communicate wih each other by using following methods:
 * wait()
 * notify()
 * notifyAll()
 *
 * these above methods are present in Object class but not in Thread class because Thread can call these methods on any java objects.
 *
 * In the Java language, you wait() on a particular instance of an Object – a monitor assigned to that object to be precise.
 * If you want to send a signal to one thread that is waiting on that specific object instance then you call notify() on that object.
 * If you want to send a signal to all threads that are waiting on that object instance, you use notifyAll() on that object.
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

/**
 * The Thread which is expecting updation, modification or calculation is responsible to call wait() method.
 * Then immediately thread will entered into waiting state.
 *
 * The Thread which is responsible to perform updation, after performing updation, It is responsible to call notify() method,
 * then waiting thread will get the notification internally and continue its execution with those updated results.
 *
 * To call wait(), notify() and notifyAll() methods compulsory the current Thread should be owner of that object.
 * i.e., current Thread should has lock of that object.
 * i.e., current Thread should be in synchronized area. Hence we can call wait(), notify() and notifyAll() methods only from synchronized area
 * otherwise we will get runtime exception saying IllegalMonitorStateException.
 *
 * Once a Thread calls wait() method on the given object 1st it releases the lock of that object immediately and entered into waiting state.
 *
 * Once a Thread calls notify() (or) notifyAll() methods it releases the lock of that object but may not immediately.
 *
 * Except these (wait(),notify(),notifyAll()) methods there is no other place(method) where Thread releases lock.
 *
 * Once a Thread calls wait(), notify(), notifyAll() methods on any object then it releases the lock of that particular object but not all locks it has.
 *
 * Prototypes :
 * 1. public final void wait()throws InterruptedException
 * 2. public final native void wait(long ms)throws InterruptedException
 * 3. public final void wait(long ms,int ns)throws InterruptedException
 * 4. public final native void notify()
 * 5. public final void notifyAll()
 *
 */
