package com.basics.thread_6_Synchronization;

/**
 * @author Anand SN
 */


/**
 * Just an Example
 */
public class ThreadExample_ReservationSystem {

    public boolean  checkAvailability(){

        System.out.println("Just Read Operation,  Wherever object state is not changed, just like read() operation");

        return true;
    }

    public synchronized void bookTicket(){
        System.out.println("Update Operation.  Wherever we are performing update operation like add, remove, delete, replace, i.e where state of object is changing");
    }
}
