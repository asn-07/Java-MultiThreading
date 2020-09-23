package com.basics.thread_4_ExecutionPrevention;

/**
 * @author Anand SN
 */


/*
 * If a Thread wants to wait until completing some other Thread then we should go for join() method.
 *
 * WeddingCardPrinting Thread t2 has to wait until VenueFixing Thread t2 completion. Therefore t2 has to call t1.join()
 * similarly WeddingCardDistribution Thread  t3 has to wait until WeddingCardPrinting thread t2 completion. Hence t3 has to call t2.join();
 *
 * Every join method throws InterruptedException which is checked exception hence we should compulsorily handle it
 * either by try-catch or throws keyword Otherwise Compile time error.
 *
 * public final void join() throws InterruptedException
 */


/**
 * Waiting of main Thread until completing of child Thread
 */

class ThreadJoin implements Runnable {

    @Override
    public void run() {
        System.out.println("Executed by the thread : "+Thread.currentThread().getName());
        System.out.println("Priority of the "+Thread.currentThread().getName()+" thread is "+Thread.currentThread().getPriority());

        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread counts : "+i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class MainThreadJoin {
    public static void main(String[] args) throws InterruptedException {

        //join()
        ThreadJoin threadJoin = new ThreadJoin();
        Thread t1 = new Thread(threadJoin);
        t1.setName("threadJoin");
        t1.start();

        t1.join(); //Excecuted by main Thread. so Main Thread has to wait until completion of child thread completion.
        //t1.join(10000);

        System.out.println("Priority of the "+Thread.currentThread().getName()+ " thread is "+Thread.currentThread().getPriority());
        for (int i=0; i<10;i++){
            System.out.println("Main Thread Counts : "+i);

        }
    }
}
