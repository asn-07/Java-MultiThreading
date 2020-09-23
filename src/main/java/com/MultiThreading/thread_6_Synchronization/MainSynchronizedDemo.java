package com.MultiThreading.thread_6_Synchronization;

/**
 * @author Anand SN
 */

/**
 * synchronized is the modifier applicable only for methods and Blocks BUT not FOR CLASSES AND VARIABLES.
 *
 * If multiple Threads are trying to operate simultaneously on the same java Object then there may be a chance of data inconsistency
 * problem. To overcome this problem we should go for synchronized keyword.
 *
 * If a method or a block declared as synchronized then at a time only one thread is allowed to execute that method or block on the given
 * object so that data inconsistency problem will be solved. Increases the waiting time and creates performance problem.Hence if there
 * is no specific requirement then it is not recommended to use synchronized keyword.
 */

 class Display {

    public synchronized void wish(String name) { //important

        for (int i=0; i<10; i++){
            System.out.println("Good Morning : ");

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }
}

/**
 * CONCLUSION : If multiple Threads are operating on same java object then synchronized is required else it is not required
 */

 class MyThread extends Thread {

    Display d;
    String name;

    public MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }


    public void run(){
        d.wish(name);
    }
}


 public class MainSynchronizedDemo {

    public static void main(String[] args) {

        Display d = new Display();

        MyThread t1 = new MyThread(d,"Dhoni");

        MyThread t2 = new MyThread(d,"Yuvaraj");

        t1.start();

        t2.start();

    }
}