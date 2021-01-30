package ru.geekbrains.home_Java_Chat_History;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorEx {
    private final int count = 5;
    SimpleDateFormat sdf = null;
    ExecutorService executorService;

    public ExecutorEx() {
        sdf = new  SimpleDateFormat("HH:mm:ss.S");

        CountDownLatch cdl1 = new CountDownLatch(count);
        CountDownLatch cdl2 = new CountDownLatch(count);
        CountDownLatch cdl3 = new CountDownLatch(count);

        executorService = Executors.newFixedThreadPool(3);
        System.out.println("start");
        executorService.execute(new myThread(cdl1, "A"));
        executorService.execute(new myThread(cdl2, "B"));
        executorService.execute(new myThread(cdl3, "C"));

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
    void printMess(final String temp1) {
        String text = sdf.format(new Date()) + " : " + temp1;
        System.out.println(text);
    }




class myThread implements Runnable {

    String name;
    CountDownLatch latch;

    public myThread(CountDownLatch latch, String name) {
        this.name = name;
        this.latch = latch;
        new Thread(this);
    }

    @Override
    public void run() {
        try {
        for (int i = 0; i < count; i++) {
           printMess(name + " - " + i);
           latch.countDown();
           Thread.sleep((long) (Math.random() * 2000));
            }
            printMess(name + " completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




    }

}
}
